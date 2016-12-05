package it.valdar.adventofcode.day4;

import it.valdar.adventofcode.day4.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static Room parseInput(String input ){
        String[] chuncks = input.trim().split("-");
        Map<Character, Integer> charOccurenceInName = new HashMap<>();
        ArrayList<String> roomNameWords = new ArrayList<>();
        Integer code = 0;
        Character[] checksum = new Character[0];
        for(int i =0; i < chuncks.length; i++){
            if( i != chuncks.length-1 ) {
                roomNameWords.add(chuncks[i]);
                Arrays.stream( chuncks[i].split("") ).forEach(
                        c -> charOccurenceInName.compute(c.toCharArray()[0], (key, count) -> count == null ? 1 : count+1) );
            } else {
                String[] lastChunks = chuncks[i].replace("]", "").split("\\[");
                if( lastChunks.length != 2 ) {
                    throw new RuntimeException("Unrecognised room code format!");
                }
                code = Integer.parseInt( lastChunks[0] );
                checksum = lastChunks[1] .chars().mapToObj(ch -> (char)ch).toArray( size -> new Character[size] );
            }
        }

        return new Room( code, checksum, charOccurenceInName, roomNameWords.toArray(new String[roomNameWords.size()]) );
    }

}