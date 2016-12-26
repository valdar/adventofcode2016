package it.valdar.adventofcode.day11.model;

import static java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by valdar on 22/12/16.
 */
public class State {

    private Map<Item, Integer> itmePositions = null;
    private Integer liftPosition = 0;
    private Map<Integer, Set<Item>> floorOccupation = null;
    private Integer MAX_FLOOR;

    public State(Map<Item, Integer> itmePositions, Integer liftPosition, Integer maxFloor) {
        this.itmePositions = itmePositions;
        this.liftPosition = liftPosition;
        this.MAX_FLOOR = maxFloor;
        floorOccupation = new HashMap<>();
        itmePositions.entrySet().forEach( e ->
                floorOccupation.compute( e.getValue(), (i,se) -> {
                    if(se==null){
                      se = new HashSet<Item>();
                    }
                    se.add( e.getKey() );
                    return se;
                } )
        );
    }

    public Set<State> produceNextValidStates(){
        Set<State> nextValidStates = new HashSet<>();
        Set<Item> movableItems = floorOccupation.get(liftPosition);
        List<Entry<Item, Item>> movableCombinations = generatePossible1or2Combinations( movableItems );
        Integer upFloor = (liftPosition + 1) > MAX_FLOOR ? null : (liftPosition + 1);
        Integer downFloor = (liftPosition - 1) < 1 ? null : (liftPosition - 1);

        movableCombinations.forEach( e -> {
            if( upFloor != null ){
                State newState = generateStates(upFloor, e);
                if( newState.isValidState() ){
                    nextValidStates.add( newState );
                }
            }
            if( downFloor != null ){
                State newState = generateStates(downFloor, e);
                if( newState.isValidState() ){
                    nextValidStates.add( newState );
                }
            }
        } );

        return nextValidStates;
    }

    private State generateStates( Integer floor, Entry<Item, Item> movedItems) {
        Map<Item, Integer> nextStateItmePositions = new HashMap<Item, Integer>( itmePositions );
        if( movedItems.getValue() != null ){
            nextStateItmePositions.put( movedItems.getKey(), floor );
            nextStateItmePositions.put( movedItems.getValue(), floor );
        } else {
            nextStateItmePositions.put( movedItems.getKey(), floor );
        }
        return new State( nextStateItmePositions, floor, MAX_FLOOR );
    }

    private List<Entry<Item, Item>> generatePossible1or2Combinations(Set<Item> items){
        List<Entry<Item, Item>> result = new ArrayList<Entry<Item, Item>>();
        Set<Item> helpreItems = new HashSet<>( items );
        items.stream().forEach( i -> {
            helpreItems.remove(i);
            result.add(new SimpleEntry<Item, Item>( i, null ) );
            helpreItems.forEach( hi -> {
                if( i.getType().equals( hi.getType() ) || i.getElemntName().equals( hi.getElemntName() ) ){
                    result.add( new SimpleEntry<Item, Item>( i, hi));
                }
            } );
        } );
        return result;
    }

    public boolean isValidState(){
        return
        floorOccupation.values().stream().filter( set -> {

            boolean allChipPaired = set.stream().filter( i -> {
                if( i.getType() == Type.CHIP ){
                    return !set.contains( new Item( Type.GENERATOR, i.getElemntName() ) );
                } else {
                    return false;
                }
            } ).count() == 0 ;

            boolean noGenerators = set.stream().filter( i -> i.getType() == Type.GENERATOR ).count() == 0;

            return !(allChipPaired || noGenerators);
        } ).count() == 0

        && floorOccupation.get(liftPosition) != null;
    }

    public boolean equivalent(State state) {
        if (!liftPosition.equals(state.liftPosition)) return false;

        Set<Item> checkedItems = new HashSet<>();
        Set<Item> otherStateCorrespondentItems = new HashSet<>();

        for( Integer floor : floorOccupation.keySet() ){
            Set<Item> currfloorItems = floorOccupation.get( floor );
            for( Item currItem : currfloorItems ){
                if( !checkedItems.contains( currItem ) ){
                    checkedItems.add( currItem );
                    Item correspondingItem = currItem.getType().equals( Type.GENERATOR ) ? new Item( Type.CHIP, currItem.getElemntName() ) : new Item( Type.GENERATOR, currItem.getElemntName() );
                    Integer correspondingItemPosition = itmePositions.get( correspondingItem );
                    checkedItems.add( correspondingItem );

                    boolean correspondencyFound = false;
                    for( Item otherStateCurrItem : state.floorOccupation.getOrDefault( floor, new HashSet<Item>() )  ){
                        if( otherStateCurrItem.getType().equals( currItem.getType() ) && !otherStateCorrespondentItems.contains( otherStateCurrItem ) ){
                            Item otherStateCorrespondingItem = otherStateCurrItem.getType().equals( Type.GENERATOR ) ? new Item( Type.CHIP, otherStateCurrItem.getElemntName() ) : new Item( Type.GENERATOR, otherStateCurrItem.getElemntName() );
                            Integer otherStateCorrespondingItemPosition = state.itmePositions.get( otherStateCorrespondingItem );

                            if( otherStateCorrespondingItemPosition == correspondingItemPosition && !otherStateCorrespondentItems.contains(otherStateCorrespondingItem) ){
                                correspondencyFound = true;
                                otherStateCorrespondentItems.add(otherStateCurrItem);
                                otherStateCorrespondentItems.add(otherStateCorrespondingItem);
                                break;
                            }
                        }
                    }
                    if( !correspondencyFound ) return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (!liftPosition.equals(state.liftPosition)) return false;
        if (!itmePositions.equals(state.itmePositions)) return false || equivalent(state);
        return floorOccupation.equals(state.floorOccupation) || equivalent(state);
    }

    @Override
    public int hashCode() {
        int result = itmePositions.hashCode();
        result = 31 * result + liftPosition.hashCode();
        result = 31 * result + floorOccupation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "State{" +
                "liftPosition=" + liftPosition +
                ", floorOccupation=" + floorOccupation +
                ", MAX_FLOOR=" + MAX_FLOOR +
                '}';
    }
}
