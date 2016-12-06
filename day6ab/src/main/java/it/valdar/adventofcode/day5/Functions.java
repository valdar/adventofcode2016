package it.valdar.adventofcode.day5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static Map<Character, Integer>[] countOccurrency(String input){

        String trimInput = input.trim();

        if (trimInput.length() != 8 ){
            throw new RuntimeException( "Unsupported format!" );
        }

        Map<Character, Integer>[] result = new Map[8];

        IntStream.rangeClosed(0,7).forEach( i -> {
            result[i] = new HashMap<>();
            result[i].put( input.charAt(i), 1 );
        } );

        return result;
    }

    public static Map<Character, Integer>[] merge(Map<Character, Integer>[] m1, Map<Character, Integer>[] m2){
        Map<Character, Integer>[] result = new Map[8];
        IntStream.rangeClosed(0,7).forEach( i -> {
            result[i] = new HashMap<>();

            Set<Character> allKeys = new HashSet<>();
            allKeys.addAll(m1[i].keySet());
            allKeys.addAll(m2[i].keySet());

            allKeys.stream().forEach( k -> result[i].put( k, m1[i].getOrDefault(k,0)+m2[i].getOrDefault(k,0) ) );
        } );
        return result;
    }
}