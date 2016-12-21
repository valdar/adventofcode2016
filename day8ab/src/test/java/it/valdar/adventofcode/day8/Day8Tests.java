package it.valdar.adventofcode.day8;

import it.valdar.adventofcode.day8.model.Command;
import it.valdar.adventofcode.day8.model.Display;
import it.valdar.adventofcode.day8.model.DrawRectangleCommand;
import it.valdar.adventofcode.day8.model.RotateColumnCommand;
import it.valdar.adventofcode.day8.model.RotateRowCommand;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by valdar on 02/12/16.
 */
public class Day8Tests {

    @Test
    public void displayTest() {
        int[] expectedRow = { 1, 0, 0, 0, 0 };
        int[] expectedColumn = { 1, 0, 0 };

        Display testDisplay = new Display( 5, 3 );
        testDisplay.switchPixelOn(0,0);
        assertArrayEquals( expectedRow, testDisplay.getRow( 0 ) );
        assertArrayEquals( expectedColumn, testDisplay.getColumn( 0 ) );
        assertEquals( 1, testDisplay.getSwitchedOnPixels() );

        int[] modifiedRow = { 0, 1, 0, 1, 0 };
        testDisplay.setRow( 1, modifiedRow );
        assertArrayEquals( modifiedRow, testDisplay.getRow(1) );

        int[] modifiedColumn = { 1, 1, 1 };
        testDisplay.setColumn( 2, modifiedColumn );
        assertArrayEquals( modifiedColumn, testDisplay.getColumn(2) );

        int[] expectedNewColumn = {0, 1, 0 };
        assertArrayEquals( expectedNewColumn, testDisplay.getColumn(1) );

        testDisplay.switchPixelOff(1,1);
        assertEquals( 5, testDisplay.getSwitchedOnPixels() );
    }

    @Test
    public void drawRectangleTest() {
        Display testDisplay = new Display( 5, 3 );
        Command drawRect = Functions.parse("rect 3x2\n");
        drawRect.apply( testDisplay );

        int[] expectedRow = { 1, 1, 1, 0, 0 };
        int[] expectedColumn = { 1, 1, 0 };
        assertArrayEquals( expectedColumn, testDisplay.getColumn(0) );
        assertArrayEquals( expectedColumn, testDisplay.getColumn(1) );
        assertArrayEquals( expectedColumn, testDisplay.getColumn(2) );
        assertArrayEquals( expectedRow, testDisplay.getRow(0) );
        assertArrayEquals( expectedRow, testDisplay.getRow(1) );
        assertEquals( 6, testDisplay.getSwitchedOnPixels() );
    }

    @Test
    public void rotateRowTest() {
        Display testDisplay = new Display( 5, 3 );
        int[] row = { 1, 1, 1, 0, 0 };
        testDisplay.setRow( 1, row );
        Command rotateRow = Functions.parse("rotate row y=1 by 3\n");
        rotateRow.apply( testDisplay );

        int[] expectedRow = { 1, 0, 0, 1, 1 };
        assertArrayEquals( expectedRow, testDisplay.getRow(1) );
    }

    @Test
    public void rotateColumnTest() {
        Display testDisplay = new Display( 5, 3 );
        int[] column = { 1, 0, 1 };
        testDisplay.setColumn( 1, column );
        Command rotateRow = Functions.parse("rotate column x=1 by 1\n");
        rotateRow.apply( testDisplay );

        int[] expectedColumn = { 1, 1, 0};
        assertArrayEquals( expectedColumn, testDisplay.getColumn(1) );
    }

}
