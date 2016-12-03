package it.valdar.adventofcode.day1;

import it.valdar.adventofcode.day1.model.Direction;
import it.valdar.adventofcode.day1.model.Instruction;
import it.valdar.adventofcode.day1.model.Turn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by valdar on 02/12/16.
 */
public class Day1aTests {

    @Test
    public void inputParsingTest() {
        final String input = "R5, L2, L1, R11, R3";
        final List<Instruction> expectedInstructions = new ArrayList<>();
        expectedInstructions.add(new Instruction(5, Turn.RIGHT));
        expectedInstructions.add(new Instruction(2, Turn.LEFT));
        expectedInstructions.add(new Instruction(1, Turn.LEFT));
        expectedInstructions.add(new Instruction(11, Turn.RIGHT));
        expectedInstructions.add(new Instruction(3, Turn.RIGHT));
        Iterator<Instruction> expectedIterator = expectedInstructions.listIterator();

        Instruction[] instructions = Functions.parseInput(input);

        for( Instruction inst : instructions ){
            assertEquals( expectedIterator.next(), inst );
        }
    }

    @Test
    public void instructionToDirectionMapTest() {
        Instruction left = new Instruction(1, Turn.LEFT);
        Instruction right = new Instruction(1, Turn.RIGHT);

        Direction newFacingDirection = Functions.newFacingDirection( left, Direction.NORTH );
        assertEquals(Direction.WEST, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( left, Direction.SOUTH );
        assertEquals(Direction.EST, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( left, Direction.WEST );
        assertEquals(Direction.SOUTH, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( left, Direction.EST );
        assertEquals(Direction.NORTH, newFacingDirection);

        newFacingDirection = Functions.newFacingDirection( right, Direction.NORTH );
        assertEquals(Direction.EST, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( right, Direction.SOUTH );
        assertEquals(Direction.WEST, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( right, Direction.WEST );
        assertEquals(Direction.NORTH, newFacingDirection);
        newFacingDirection = Functions.newFacingDirection( right, Direction.EST );
        assertEquals(Direction.SOUTH, newFacingDirection);
    }

    @Test
    public void solverTest() {
        Instruction[] problem1 = {  new Instruction(2, Turn.RIGHT),
                                    new Instruction(3, Turn.LEFT)};

        Instruction[] problem2 = {  new Instruction(2, Turn.RIGHT),
                                    new Instruction(2, Turn.RIGHT),
                                    new Instruction(2, Turn.RIGHT)};

        Instruction[] problem3 = {  new Instruction(5, Turn.RIGHT),
                                    new Instruction(5, Turn.LEFT),
                                    new Instruction(5, Turn.RIGHT),
                                    new Instruction(3, Turn.RIGHT)};

        Instruction[] problem4 = {  new Instruction(5, Turn.LEFT),
                                    new Instruction(64, Turn.RIGHT),
                                    new Instruction(5, Turn.RIGHT),
                                    new Instruction(65, Turn.RIGHT)};

        Instruction[] problem5 = {  new Instruction(8, Turn.RIGHT),
                                    new Instruction(4, Turn.RIGHT),
                                    new Instruction(4, Turn.RIGHT),
                                    new Instruction(8, Turn.RIGHT)};

        Instruction[] problem6 = {  new Instruction(1, Turn.RIGHT),
                                    new Instruction(1, Turn.RIGHT),
                                    new Instruction(3, Turn.RIGHT),
                                    new Instruction(3, Turn.RIGHT),
                                    new Instruction(2, Turn.RIGHT),
                                    new Instruction(8, Turn.RIGHT)};

//      L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2
        Instruction[] problem7 = {  new Instruction(2, Turn.RIGHT),
                new Instruction(1, Turn.LEFT),
                new Instruction(1, Turn.RIGHT),
                new Instruction(1, Turn.RIGHT),
                new Instruction(1, Turn.RIGHT),
                new Instruction(5, Turn.LEFT)
        };

        Integer result = Functions.solve( problem1, false);
        assertEquals(new Integer(5), result);

        result = Functions.solve( problem2, false);
        assertEquals(new Integer(2), result);

        result = Functions.solve( problem3, false);
        assertEquals(new Integer(12), result);

        result = Functions.solve( problem4, false);
        assertEquals(new Integer(1), result);

        result = Functions.solve( problem5, false);
        assertEquals(new Integer(8), result);

        result = Functions.solve( problem5, true);
        assertEquals(new Integer(4), result);

        result = Functions.solve( problem6, true);
        assertEquals(new Integer(0), result);

        result = Functions.solve( problem7, true);
        assertEquals(new Integer(2), result);
    }
}
