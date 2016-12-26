package it.valdar.adventofcode.day11;

import it.valdar.adventofcode.day11.model.State;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.AbstractMap.SimpleEntry;
/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static final Integer solver(State initialState, State targetState ){
        Map.Entry<State, Integer> finalReachedStates = null;
        Set<State> alreadyExploredStates = new HashSet<>();
        Queue<Map.Entry<State, Integer>> toBeExploredStates = new LinkedList<>();
        toBeExploredStates.add( new SimpleEntry<>( initialState, 0 ) );

        while( !toBeExploredStates.isEmpty() && finalReachedStates == null ){
            Map.Entry<State, Integer> currentState = toBeExploredStates.remove();
            if( currentState.getKey().equals( targetState ) ){
                finalReachedStates = currentState;
            } else if( !alreadyExploredStates.contains( currentState.getKey() ) ){
                alreadyExploredStates.add( currentState.getKey() );
                Set<State> nextStates = currentState.getKey().produceNextValidStates();
                toBeExploredStates.addAll(
                            nextStates.stream().filter( s -> !alreadyExploredStates.contains( s ) )
                                    .map( fs -> new SimpleEntry<State, Integer>( fs, currentState.getValue()+1 ) )
                                    .collect( Collectors.toSet() )
                    );
            }
            System.out.println( "Explored state at depth: " +currentState.getValue()+" and "+toBeExploredStates.size()+" left to explore!");
        }

        return finalReachedStates == null ? null : finalReachedStates.getValue();
    }
}