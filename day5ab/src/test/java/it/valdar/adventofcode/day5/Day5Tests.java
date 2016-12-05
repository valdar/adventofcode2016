package it.valdar.adventofcode.day5;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by valdar on 02/12/16.
 */
public class Day5Tests {

    @Test
    public void solver1Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        assertEquals( "18f47a30", Functions.decode1("abc") );

    }

    @Test
    public void solver2Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        assertEquals( "05ace8e3", Functions.decode2("abc") );

    }

}
