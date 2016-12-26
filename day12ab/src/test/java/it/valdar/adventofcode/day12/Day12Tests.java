package it.valdar.adventofcode.day12;

import it.valdar.adventofcode.day12.model.Computer;
import it.valdar.adventofcode.day12.model.Instruction;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day12Tests {

    @Test
    public void parserTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        assertNotNull( Functions.parse( "cpy a 34" ) );
        assertNotNull( Functions.parse( "inc a" ) );
        assertNotNull( Functions.parse( "dec a" ) );
        assertNotNull( Functions.parse( "jnz a -78" ) );
    }

    @Test
    public void parser2Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Instruction[] program = {   Functions.parse("cpy 41 a"),
                                    Functions.parse("inc a"),
                                    Functions.parse("inc a"),
                                    Functions.parse("dec a"),
                                    Functions.parse("jnz a 2"),
                                    Functions.parse("dec a") };

        Map<String, Integer> registries = new HashMap(){{
            put( "a", 0 );
            put( "b", 0 );
            put( "c", 0 );
            put( "d", 0 );
        }};

        Computer pc = new Computer( registries, 0);
        pc.runProgram( program );
        assertEquals( new Integer(41),  pc.getRegisrtyValue("a") );
    }

}
