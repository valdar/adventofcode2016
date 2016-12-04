package it.valdar.adventofcode.day3;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by valdar on 02/12/16.
 */
public class Day3Tests {

    @Test
    public void solverTest() {
        String[] input = {  "  5    5    5\n",
                            "  3  4  5\n",
                            "  5   10   25\n",
                            "  5    5    5\n",
                            "  3  4  5\n",
                            "  5   10   25\n"};

        assertEquals( 4, Functions.countPossibleTrianglesByRow( Arrays.stream(input) ) );
        assertEquals( 2, Functions.countPossibleTrianglesByColumn( Arrays.stream(input) ) );
    }

}
