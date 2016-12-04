package it.valdar.adventofcode.day2;

import it.valdar.adventofcode.day2.model.Instruction;
import it.valdar.adventofcode.day2.model.Key;
import it.valdar.adventofcode.day2.model.Keypad;
import it.valdar.adventofcode.day2.model.NormalKeypad;
import it.valdar.adventofcode.day2.model.OverEngineeredKeypad;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by valdar on 02/12/16.
 */
public class Day2Tests {

    @Test
    public void inputParsingTest() {
        final String input = "UDLLRR\n";
        final List<Instruction> expectedInstructions = new ArrayList(){{
            add(Instruction.U);
            add(Instruction.D);
            add(Instruction.L);
            add(Instruction.L);
            add(Instruction.R);
            add(Instruction.R); }};
        Iterator<Instruction> expectedIterator = expectedInstructions.listIterator();

        Instruction[] instructions = Functions.parseInput(input);

        for( Instruction inst : instructions ){
            assertEquals( expectedIterator.next(), inst );
        }
    }

    @Test
    public void instructionToNextKeyMapTest() {
        Keypad normalKeypad = new NormalKeypad();
        assertEquals(Key.ONE, normalKeypad.nextKey( Instruction.U, Key.ONE ));
        assertEquals(Key.FOUR, normalKeypad.nextKey( Instruction.D, Key.ONE ));
        assertEquals(Key.ONE, normalKeypad.nextKey( Instruction.L, Key.ONE ));
        assertEquals(Key.TWO, normalKeypad.nextKey( Instruction.R, Key.ONE ));

        assertEquals(Key.TWO, normalKeypad.nextKey( Instruction.U, Key.TWO ));
        assertEquals(Key.FIVE, normalKeypad.nextKey( Instruction.D, Key.TWO ));
        assertEquals(Key.ONE, normalKeypad.nextKey( Instruction.L, Key.TWO ));
        assertEquals(Key.THREE, normalKeypad.nextKey( Instruction.R, Key.TWO ));

        assertEquals(Key.THREE, normalKeypad.nextKey( Instruction.U, Key.THREE ));
        assertEquals(Key.SIX, normalKeypad.nextKey( Instruction.D, Key.THREE ));
        assertEquals(Key.TWO, normalKeypad.nextKey( Instruction.L, Key.THREE ));
        assertEquals(Key.THREE, normalKeypad.nextKey( Instruction.R, Key.THREE ));

        assertEquals(Key.ONE, normalKeypad.nextKey( Instruction.U, Key.FOUR ));
        assertEquals(Key.SEVEN, normalKeypad.nextKey( Instruction.D, Key.FOUR ));
        assertEquals(Key.FOUR, normalKeypad.nextKey( Instruction.L, Key.FOUR ));
        assertEquals(Key.FIVE, normalKeypad.nextKey( Instruction.R, Key.FOUR ));

        assertEquals(Key.TWO, normalKeypad.nextKey( Instruction.U, Key.FIVE ));
        assertEquals(Key.EIGHT, normalKeypad.nextKey( Instruction.D, Key.FIVE ));
        assertEquals(Key.FOUR, normalKeypad.nextKey( Instruction.L, Key.FIVE ));
        assertEquals(Key.SIX, normalKeypad.nextKey( Instruction.R, Key.FIVE ));

        assertEquals(Key.THREE, normalKeypad.nextKey( Instruction.U, Key.SIX ));
        assertEquals(Key.NINE, normalKeypad.nextKey( Instruction.D, Key.SIX ));
        assertEquals(Key.FIVE, normalKeypad.nextKey( Instruction.L, Key.SIX ));
        assertEquals(Key.SIX, normalKeypad.nextKey( Instruction.R, Key.SIX ));

        assertEquals(Key.FOUR, normalKeypad.nextKey( Instruction.U, Key.SEVEN ));
        assertEquals(Key.SEVEN, normalKeypad.nextKey( Instruction.D, Key.SEVEN ));
        assertEquals(Key.SEVEN, normalKeypad.nextKey( Instruction.L, Key.SEVEN ));
        assertEquals(Key.EIGHT, normalKeypad.nextKey( Instruction.R, Key.SEVEN ));

        assertEquals(Key.FIVE, normalKeypad.nextKey( Instruction.U, Key.EIGHT ));
        assertEquals(Key.EIGHT, normalKeypad.nextKey( Instruction.D, Key.EIGHT ));
        assertEquals(Key.SEVEN, normalKeypad.nextKey( Instruction.L, Key.EIGHT ));
        assertEquals(Key.NINE, normalKeypad.nextKey( Instruction.R, Key.EIGHT ));

        assertEquals(Key.SIX, normalKeypad.nextKey( Instruction.U, Key.NINE ));
        assertEquals(Key.NINE, normalKeypad.nextKey( Instruction.D, Key.NINE ));
        assertEquals(Key.EIGHT, normalKeypad.nextKey( Instruction.L, Key.NINE ));
        assertEquals(Key.NINE, normalKeypad.nextKey( Instruction.R, Key.NINE ));

        Keypad overEngineeredKeypad = new OverEngineeredKeypad();
        assertEquals(Key.ONE, overEngineeredKeypad.nextKey( Instruction.U, Key.ONE ));
        assertEquals(Key.THREE, overEngineeredKeypad.nextKey( Instruction.D, Key.ONE ));
        assertEquals(Key.ONE, overEngineeredKeypad.nextKey( Instruction.L, Key.ONE ));
        assertEquals(Key.ONE, overEngineeredKeypad.nextKey( Instruction.R, Key.ONE ));

        assertEquals(Key.TWO, overEngineeredKeypad.nextKey( Instruction.U, Key.TWO ));
        assertEquals(Key.SIX, overEngineeredKeypad.nextKey( Instruction.D, Key.TWO ));
        assertEquals(Key.TWO, overEngineeredKeypad.nextKey( Instruction.L, Key.TWO ));
        assertEquals(Key.THREE, overEngineeredKeypad.nextKey( Instruction.R, Key.TWO ));

        assertEquals(Key.ONE, overEngineeredKeypad.nextKey( Instruction.U, Key.THREE ));
        assertEquals(Key.SEVEN, overEngineeredKeypad.nextKey( Instruction.D, Key.THREE ));
        assertEquals(Key.TWO, overEngineeredKeypad.nextKey( Instruction.L, Key.THREE ));
        assertEquals(Key.FOUR, overEngineeredKeypad.nextKey( Instruction.R, Key.THREE ));

        assertEquals(Key.FOUR, overEngineeredKeypad.nextKey( Instruction.U, Key.FOUR ));
        assertEquals(Key.EIGHT, overEngineeredKeypad.nextKey( Instruction.D, Key.FOUR ));
        assertEquals(Key.THREE, overEngineeredKeypad.nextKey( Instruction.L, Key.FOUR ));
        assertEquals(Key.FOUR, overEngineeredKeypad.nextKey( Instruction.R, Key.FOUR ));

        assertEquals(Key.FIVE, overEngineeredKeypad.nextKey( Instruction.U, Key.FIVE ));
        assertEquals(Key.FIVE, overEngineeredKeypad.nextKey( Instruction.D, Key.FIVE ));
        assertEquals(Key.FIVE, overEngineeredKeypad.nextKey( Instruction.L, Key.FIVE ));
        assertEquals(Key.SIX, overEngineeredKeypad.nextKey( Instruction.R, Key.FIVE ));

        assertEquals(Key.TWO, overEngineeredKeypad.nextKey( Instruction.U, Key.SIX ));
        assertEquals(Key.A, overEngineeredKeypad.nextKey( Instruction.D, Key.SIX ));
        assertEquals(Key.FIVE, overEngineeredKeypad.nextKey( Instruction.L, Key.SIX ));
        assertEquals(Key.SEVEN, overEngineeredKeypad.nextKey( Instruction.R, Key.SIX ));

        assertEquals(Key.THREE, overEngineeredKeypad.nextKey( Instruction.U, Key.SEVEN ));
        assertEquals(Key.B, overEngineeredKeypad.nextKey( Instruction.D, Key.SEVEN ));
        assertEquals(Key.SIX, overEngineeredKeypad.nextKey( Instruction.L, Key.SEVEN ));
        assertEquals(Key.EIGHT, overEngineeredKeypad.nextKey( Instruction.R, Key.SEVEN ));

        assertEquals(Key.FOUR, overEngineeredKeypad.nextKey( Instruction.U, Key.EIGHT ));
        assertEquals(Key.C, overEngineeredKeypad.nextKey( Instruction.D, Key.EIGHT ));
        assertEquals(Key.SEVEN, overEngineeredKeypad.nextKey( Instruction.L, Key.EIGHT ));
        assertEquals(Key.NINE, overEngineeredKeypad.nextKey( Instruction.R, Key.EIGHT ));

        assertEquals(Key.NINE, overEngineeredKeypad.nextKey( Instruction.U, Key.NINE ));
        assertEquals(Key.NINE, overEngineeredKeypad.nextKey( Instruction.D, Key.NINE ));
        assertEquals(Key.EIGHT, overEngineeredKeypad.nextKey( Instruction.L, Key.NINE ));
        assertEquals(Key.NINE, overEngineeredKeypad.nextKey( Instruction.R, Key.NINE ));

        assertEquals(Key.SIX, overEngineeredKeypad.nextKey( Instruction.U, Key.A ));
        assertEquals(Key.A, overEngineeredKeypad.nextKey( Instruction.D, Key.A ));
        assertEquals(Key.A, overEngineeredKeypad.nextKey( Instruction.L, Key.A ));
        assertEquals(Key.B, overEngineeredKeypad.nextKey( Instruction.R, Key.A ));

        assertEquals(Key.SEVEN, overEngineeredKeypad.nextKey( Instruction.U, Key.B ));
        assertEquals(Key.D, overEngineeredKeypad.nextKey( Instruction.D, Key.B ));
        assertEquals(Key.A, overEngineeredKeypad.nextKey( Instruction.L, Key.B ));
        assertEquals(Key.C, overEngineeredKeypad.nextKey( Instruction.R, Key.B ));

        assertEquals(Key.EIGHT, overEngineeredKeypad.nextKey( Instruction.U, Key.C ));
        assertEquals(Key.C, overEngineeredKeypad.nextKey( Instruction.D, Key.C ));
        assertEquals(Key.B, overEngineeredKeypad.nextKey( Instruction.L, Key.C ));
        assertEquals(Key.C, overEngineeredKeypad.nextKey( Instruction.R, Key.C ));

        assertEquals(Key.B, overEngineeredKeypad.nextKey( Instruction.U, Key.D ));
        assertEquals(Key.D, overEngineeredKeypad.nextKey( Instruction.D, Key.D ));
        assertEquals(Key.D, overEngineeredKeypad.nextKey( Instruction.L, Key.D ));
        assertEquals(Key.D, overEngineeredKeypad.nextKey( Instruction.R, Key.D ));
    }

    @Test
    public void solverTest() {
        Instruction[] problem1 = {  Instruction.U,
                                    Instruction.L,
                                    Instruction.L};

        Instruction[] problem2 = {  Instruction.R,
                                    Instruction.R,
                                    Instruction.D,
                                    Instruction.D,
                                    Instruction.D};

        Instruction[] problem3 = {  Instruction.L,
                                    Instruction.U,
                                    Instruction.R,
                                    Instruction.D,
                                    Instruction.L};

        Instruction[] problem4 = {  Instruction.U,
                                    Instruction.U,
                                    Instruction.U,
                                    Instruction.U,
                                    Instruction.D};

        Key result = Functions.solve( problem1, Key.FIVE, false);
        assertEquals(Key.ONE, result);

        result = Functions.solve( problem2, Key.ONE, false);
        assertEquals(Key.NINE, result);

        result = Functions.solve( problem3, Key.NINE, false);
        assertEquals(Key.EIGHT, result);

        result = Functions.solve( problem4, Key.EIGHT, false);
        assertEquals(Key.FIVE, result);


        result = Functions.solve( problem1, Key.FIVE, true);
        assertEquals(Key.FIVE, result);

        result = Functions.solve( problem2, Key.FIVE, true);
        assertEquals(Key.D, result);

        result = Functions.solve( problem3, Key.D, true);
        assertEquals(Key.B, result);

        result = Functions.solve( problem4, Key.B, true);
        assertEquals(Key.THREE, result);

    }
}
