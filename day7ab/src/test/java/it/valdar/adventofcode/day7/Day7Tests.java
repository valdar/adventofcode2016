package it.valdar.adventofcode.day7;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day7Tests {

    @Test
    public void parserTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        assertTrue( Functions.parse( "abba[mnop]qrst" ) );
        assertFalse( Functions.parse( "abcd[bddb]xyyx" ) );
        assertTrue( Functions.parse( "abcd[bddbxyyx" ) );
        assertFalse( Functions.parse( "aaaa[qwer]tyui" ) );
        assertFalse( Functions.parse( "ssaaaass[qwwwwer]tyui" ) );
        assertTrue( Functions.parse( "ioxxoj[asdfgh]zxcvbn" ) );

        assertFalse( Functions.parse( "iabba[eeefggf[ertyu]]" ) );
        assertFalse( Functions.parse( "ioxxoj[asdfabaabbagh]zxcvbn" ) );

        assertFalse( Functions.parse( "iabb[aeefgf]ggf" ) );

        assertFalse( Functions.parse( "sqtxgdsfkbhljmt[ndqljydrgqwwqjayc]lttwcrsejwxgxkuawgm[nefpbdmgtizfijyt]dcxacpeeyuzkemb[otnbznolvwiervj]hdcjffxyhtqdjmaipj" ) );
    }

    @Test
    public void parser2Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        assertTrue( Functions.parse2( "aba[bab]xyz" ) );
        assertFalse( Functions.parse2( "xyx[xyx]xyx" ) );
        assertTrue( Functions.parse2( "aaa[kek]eke" ) );
        assertTrue( Functions.parse2( "zazbz[bzb]cdb" ) );

        assertTrue( Functions.parse2( "xxxxxzazbz[xaxaxaxbx]cbcbxb" ) );

        assertFalse( Functions.parse2( "sqtxgdsfkbhljmt[ndqljydrgqwwqjayc]lttwcrsejwxgxkuawgm[nefpbdmgtizfijyt]dcxacpeeyuzkemb[otnbznolvwiervj]hdcjffxyhtqdjmaipj" ) );
    }

}
