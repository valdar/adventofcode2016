package it.valdar.adventofcode.day5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static String decode1( String input ) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String[] result =
        IntStream.range(0, Integer.MAX_VALUE)
                .mapToObj(i -> {
                    try {
                        return toHex( md.digest( (input + String.valueOf(i)).getBytes("UTF-8") ) );
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Can not parse int! ");
                    }
                } ).filter( s -> s.startsWith("00000") ).map( s -> s.substring(5,6) ).limit(8).toArray( size -> new String[size] );

        return Arrays.stream(result).collect(Collectors.joining());
    }

    public static String decode2( String input ) throws NoSuchAlgorithmException {
        String[] result =
        IntStream.rangeClosed(0, 7).mapToObj(i -> {
            try {
                return getDigit(String.valueOf(i), input);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                throw new RuntimeException("Can not parse int! ");
            }
        }).toArray( size -> new String[size] );

        return Arrays.stream(result).collect(Collectors.joining());
    }

    private static String getDigit(String digitNumber, String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return
        IntStream.range(0, Integer.MAX_VALUE)
                .mapToObj(i -> {
                    try {
                        return toHex( md.digest( (input + String.valueOf(i)).getBytes("UTF-8") ) );
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Can not parse int! ");
                    }
                } ).filter( s -> s.startsWith("00000"+digitNumber) ).map( s -> s.substring(6,7) ).limit(1).toArray( size -> new String[size] )[0];

    }

    private static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "x", bi);
    }
}