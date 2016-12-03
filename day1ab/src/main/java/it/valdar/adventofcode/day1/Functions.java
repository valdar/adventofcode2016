package it.valdar.adventofcode.day1;

import it.valdar.adventofcode.day1.model.Direction;
import it.valdar.adventofcode.day1.model.Instruction;
import it.valdar.adventofcode.day1.model.LocationCoordinate;
import it.valdar.adventofcode.day1.model.SolutionAccumulator;
import it.valdar.adventofcode.day1.model.Turn;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    private  static final Map<TurnDirection, Direction> tunrDirectionTodirectionLookup = Collections.unmodifiableMap(
            Stream.of(
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.LEFT, Direction.NORTH), Direction.WEST),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.RIGHT, Direction.NORTH), Direction.EST),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.LEFT, Direction.SOUTH), Direction.EST),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.RIGHT, Direction.SOUTH), Direction.WEST),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.LEFT, Direction.WEST), Direction.SOUTH),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.RIGHT, Direction.WEST), Direction.NORTH),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.LEFT, Direction.EST), Direction.NORTH),
            new AbstractMap.SimpleEntry<>(new TurnDirection(Turn.RIGHT, Direction.EST), Direction.SOUTH) )
            .collect( Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()) )
    );

    public static Instruction[] parseInput(String input ){
        Instruction[] result = Arrays.stream(input.split(","))
                .map( String::trim )
                .map( s -> {
                    Turn turn;
                    switch (s.substring(0,1)) {
                        case "L":
                            turn = Turn.LEFT;
                            break;
                        case "R":
                            turn = Turn.RIGHT;
                            break;
                        default: throw new RuntimeException("Not recognised instruction");
                    }
                    return new Instruction( Integer.parseInt(s.substring(1)), turn);
                } ).toArray(Instruction[]::new);

        return result;
    }

    public static Direction newFacingDirection(Instruction inst, Direction dir) {
        return tunrDirectionTodirectionLookup.get( new TurnDirection( inst.getTurn(), dir ) );
    }

    public static Integer solve(Instruction[] instructions, Boolean stopAtFirstVisitedTwice) {
        SolutionAccumulator accumulator = new SolutionAccumulator( Direction.NORTH, emptyInitialMap() );

        LocationCoordinate solutionCoordinates;
        if(stopAtFirstVisitedTwice){
            solutionCoordinates = getLocationCoordinate(instructions, accumulator );
        } else {
            for (Instruction currInstruction : instructions) {
                accumulator.add(currInstruction);
            }
            solutionCoordinates = accumulator.getCurrentLocation();
        }

        return Math.abs(solutionCoordinates.getNortSouth()) + Math.abs(solutionCoordinates.getWestEst());
    }

    private static LocationCoordinate getLocationCoordinate(Instruction[] instructions, SolutionAccumulator accumulator ) {
        Map<LocationCoordinate, Integer> visitedCoordinates = new HashMap<>();
        visitedCoordinates.put(new LocationCoordinate(0,0), 1);
        for (Instruction currInstruction : instructions) {
            LocationCoordinate[] currVisitedLocation = accumulator.add(currInstruction);
            for( LocationCoordinate currCoordinate : currVisitedLocation ){
                visitedCoordinates.put(currCoordinate, visitedCoordinates.getOrDefault(currCoordinate,0)+1);
                if( visitedCoordinates.get(currCoordinate).equals( new Integer(2) ) ){
                    return currCoordinate;
                }
            }
        }
        return accumulator.getCurrentLocation();
    }

    private static Map<Direction, Integer> emptyInitialMap() {
        Map<Direction, Integer> map = new HashMap<>();
        map.put(Direction.NORTH,0);
        map.put(Direction.SOUTH,0);
        map.put(Direction.WEST,0);
        map.put(Direction.EST,0);
        return map;
    }

    private static class TurnDirection {
        private Turn turn;
        private Direction direction;

        public TurnDirection(Turn turn, Direction direction) {
            this.turn = turn;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TurnDirection that = (TurnDirection) o;

            if (turn != that.turn) return false;
            return direction == that.direction;

        }

        @Override
        public int hashCode() {
            int result = turn != null ? turn.hashCode() : 0;
            result = 31 * result + (direction != null ? direction.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "turnDirection{" +
                    "turn=" + turn +
                    ", direction=" + direction +
                    '}';
        }
    }
}