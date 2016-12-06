package it.valdar.adventofcode.day5;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day5Tests {

    @Test
    public void countOccurrencyTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = "abcdefgh";
        Map<Character, Integer>[] expecteRresult = new Map[8];

        IntStream.rangeClosed(0,7).forEach( i -> {
            expecteRresult[i] = new HashMap<>();
            expecteRresult[i].put( input.charAt(i), 1 );
        } );

        assertTrue(Arrays.equals( expecteRresult, Functions.countOccurrency(input) ) );
    }

    @Test
    public void mergeTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input1 = "aaaaaaaa";
        String input2 = "baaaaaaa";
        Map<Character, Integer>[] expecteRresult = new Map[8];
        expecteRresult[0] = new HashMap(){{ put('a', 1); put( 'b', 1 ); }};
        expecteRresult[1] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[2] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[3] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[4] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[5] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[6] = new HashMap(){{ put('a', 2);  }};
        expecteRresult[7] = new HashMap(){{ put('a', 2);  }};

        assertTrue(Arrays.equals( expecteRresult, Functions.merge( Functions.countOccurrency(input1), Functions.countOccurrency(input2) ) ) );
    }

}
