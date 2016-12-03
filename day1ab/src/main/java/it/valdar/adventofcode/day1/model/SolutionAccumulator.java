package it.valdar.adventofcode.day1.model;

import it.valdar.adventofcode.day1.Functions;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by valdar on 02/12/16.
 */
public class SolutionAccumulator {
    private Direction lastDirection;
    private final Map<Direction, Integer> directionsTotals;

    public SolutionAccumulator(Direction lastDirection, Map<Direction, Integer> directionsTotals) {
        this.lastDirection = lastDirection;
        this.directionsTotals = directionsTotals;
    }

    public Map<Direction, Integer> getDirectionsTotals() {
        return directionsTotals;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

    public LocationCoordinate[] add(Instruction instruction){
        LocationCoordinate startingLocation = getCurrentLocation();
        lastDirection = Functions.newFacingDirection(instruction, lastDirection);
        directionsTotals.put( lastDirection, directionsTotals.get(lastDirection) + instruction.getBlocks() );
        //XXX: works only for positive number of blocks
        return IntStream.rangeClosed(1, instruction.getBlocks() )
                .mapToObj( blocks -> startingLocation.move(lastDirection, blocks) )
                .toArray(size -> new LocationCoordinate[size]);
    }

    public LocationCoordinate getCurrentLocation() {
        return new LocationCoordinate(  directionsTotals.get(Direction.NORTH) - directionsTotals.get(Direction.SOUTH),
                                        directionsTotals.get(Direction.WEST) - directionsTotals.get(Direction.EST) );
    }

}
