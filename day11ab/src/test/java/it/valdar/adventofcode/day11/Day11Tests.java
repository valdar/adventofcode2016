package it.valdar.adventofcode.day11;

import it.valdar.adventofcode.day11.model.Item;
import it.valdar.adventofcode.day11.model.State;
import it.valdar.adventofcode.day11.model.Type;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day11Tests {

    @Test
    public void stateValidityTest() {
        Item GH = new Item(Type.GENERATOR, "H" );
        Item CH = new Item(Type.CHIP, "H" );
        Item GW = new Item(Type.GENERATOR, "W" );
        Item CW = new Item(Type.CHIP, "W" );

        Map<Item, Integer> itmePositions = new HashMap(){{
           put( GH, 1 );
           put( CH, 1 );
           put( GW, 2 );
           put( CW, 3 );
        }};

        assertTrue( new State( itmePositions, 1, 3 ).isValidState()  );
        assertFalse( new State( itmePositions, 4, 4 ).isValidState()  );

        itmePositions = new HashMap(){{
            put( GH, 1 );
            put( CH, 1 );
            put( GW, 2 );
            put( CW, 1 );
        }};
        assertFalse( new State( itmePositions, 4, 4 ).isValidState()  );
    }

    @Test
    public void nextStatesGenerationTest() {
        Item GS = new Item(Type.GENERATOR, "S" );
        Item CS = new Item(Type.CHIP, "S" );
        Item GP = new Item(Type.GENERATOR, "P" );
        Item CP = new Item(Type.CHIP, "P" );

        Item GT = new Item(Type.GENERATOR, "T" );
        Item CT = new Item(Type.CHIP, "T" );

        Item GR = new Item(Type.GENERATOR, "R" );
        Item CR = new Item(Type.CHIP, "R" );
        Item GC = new Item(Type.GENERATOR, "C" );
        Item CC = new Item(Type.CHIP, "C" );


        Map<Item, Integer> itmePositions = new HashMap(){{
            put( GS, 1 );
            put( CS, 1 );
            put( GP, 1 );
            put( CP, 1 );

            put( GT, 2 );
            put( GR, 2 );
            put( CR, 2 );
            put( GC, 2 );
            put( CC, 2 );

            put( CT, 3 );
        }};

        State startingState = new State( itmePositions, 1, 4 );

        assertTrue( startingState.isValidState() );
        Set<State> nextStates = startingState.produceNextValidStates();
        assertEquals( 3, nextStates.size() );

    }

    @Test
    public void stateEqualityTest() {
        Item GH = new Item(Type.GENERATOR, "H" );
        Item CH = new Item(Type.CHIP, "H" );
        Item GL = new Item(Type.GENERATOR, "L" );
        Item CL = new Item(Type.CHIP, "L" );

        Map<Item, Integer> itmePositions = new HashMap(){{
            put( GH, 2 );
            put( CH, 1 );
            put( CL, 1 );
            put( GL, 3 );
        }};
        State itmePositionsState = new State( itmePositions, 1, 4 );

        Map<Item, Integer> targetItmePositions = new HashMap(){{
            put( GH, 4 );
            put( CH, 4 );
            put( CL, 4 );
            put( GL, 4 );
        }};
        State targetItmePositionsState = new State( targetItmePositions, 1, 4 );

        Map<Item, Integer> targetItmePositions2 = new HashMap(){{
            put( GH, 4 );
            put( CH, 4 );
            put( CL, 4 );
            put( GL, 4 );
        }};
        State targetItmePositions2State = new State( targetItmePositions2, 1, 4 );

        Map<Item, Integer> equivalentItmePositions = new HashMap(){{
            put( GH, 3 );
            put( CH, 1 );
            put( CL, 1 );
            put( GL, 2 );
        }};
        State equivalentItmePositionsState = new State( equivalentItmePositions, 1, 4 );

        assertTrue( targetItmePositionsState.equals(targetItmePositions2State));
        assertFalse( targetItmePositionsState.equals(itmePositionsState));
        assertFalse( itmePositionsState.equals(targetItmePositionsState));
        assertTrue( itmePositionsState.equals(equivalentItmePositionsState));
    }

    @Test
    public void solverTest() {
        Item GH = new Item(Type.GENERATOR, "H" );
        Item CH = new Item(Type.CHIP, "H" );
        Item GL = new Item(Type.GENERATOR, "L" );
        Item CL = new Item(Type.CHIP, "L" );

        Map<Item, Integer> itmePositions = new HashMap(){{
            put( GH, 2 );
            put( CH, 1 );
            put( CL, 1 );
            put( GL, 3 );
        }};

        Map<Item, Integer> targetItmePositions = new HashMap(){{
            put( GH, 4 );
            put( CH, 4 );
            put( CL, 4 );
            put( GL, 4 );
        }};

        State startingState = new State( itmePositions, 1, 4 );
        State targetState = new State( targetItmePositions, 4, 4 );

        assertEquals( new Integer(11), Functions.solver( startingState, targetState ) );

    }
}
