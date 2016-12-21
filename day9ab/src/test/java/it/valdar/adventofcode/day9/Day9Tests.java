package it.valdar.adventofcode.day9;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day9Tests {

    @Test
    public void parserTest() {
        assertEquals( "ADVENT".length(), Functions.decompress("ADVENT") );
        assertEquals( "ABBBBBC".length(), Functions.decompress("A(1x5)BC") );
        assertEquals( "XYZXYZXYZ".length(), Functions.decompress("(3x3)XYZ") );
        assertEquals( "ABCBCDEFEFG".length(), Functions.decompress("A(2x2)BCD(2x2)EFG") );
        assertEquals( "(1x3)A".length(), Functions.decompress("(6x1)(1x3)A") );
        assertEquals( "X(3x3)ABC(3x3)ABCY".length(), Functions.decompress("X(8x2)(3x3)ABCY") );
    }

    @Test
    public void parser2Test() {
        assertEquals( "XYZXYZXYZ".length(), Functions.decompress2("(3x3)XYZ") );
        assertEquals( "XABCABCABCABCABCABCY".length(), Functions.decompress2("X(8x2)(3x3)ABCY") );
        assertEquals( 241920, Functions.decompress2("(27x12)(20x12)(13x14)(7x10)(1x12)A") );
        assertEquals( 445, Functions.decompress2("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN") );
    }

}
