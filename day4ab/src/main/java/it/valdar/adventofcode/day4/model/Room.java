package it.valdar.adventofcode.day4.model;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by valdar on 04/12/16.
 */
public class Room {
    private Integer code;
    private Character[] checksum;
    private Map<Character, Integer> charOccurenceInName;
    private String[] roomNameWords;

    private final static List<Character> alphabet = Arrays.asList( new Character[] {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u','v', 'w', 'x', 'y', 'z' });

    public Room(Integer code, Character[] checksum, Map<Character, Integer> charOccurenceInName, String[] roomNameWords) {
        this.code = code;
        this.checksum = checksum;
        this.charOccurenceInName = charOccurenceInName;
        this.roomNameWords = roomNameWords;
    }

    public Boolean isValidRoom() {

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>( charOccurenceInName.entrySet() );
        Character[] roomFingerprint =
        entries.stream()
                .sorted( (e1, e2) -> {
                    if( e1.getValue() == e2.getValue() ){
                        return Character.compare( e2.getKey(), e1.getKey() );
                    } else {
                        return  -Integer.compare( e2.getValue(), e1.getValue() );
                    }
                } ).map( e -> e.getKey() ).toArray(size -> new Character[size]) ;

        List<Character> list = Arrays.asList(roomFingerprint);
        Collections.reverse(list);

        return Arrays.equals( list.subList(0,5).toArray(), checksum );
    }

    public String decodeRoomName(){
        return
        Arrays.stream( roomNameWords ).map( s ->

            s.chars().map(
                    c -> alphabet.get( ( alphabet.indexOf( new Character((char)c))+code ) % alphabet.size() ) )
                    .mapToObj(i -> (char)i).collect(
                    StringWriter::new,
                    StringWriter::write,
                    (swl, swr) -> swl.write(swr.toString())).toString()
         ).collect(Collectors.joining(" "));
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (getCode() != null ? !getCode().equals(room.getCode()) : room.getCode() != null) return false;
        if (!Arrays.equals(checksum, room.checksum)) return false;
        if (charOccurenceInName != null ? !charOccurenceInName.equals(room.charOccurenceInName) : room.charOccurenceInName != null)
            return false;
        return Arrays.equals(roomNameWords, room.roomNameWords);

    }

    @Override
    public int hashCode() {
        int result = getCode() != null ? getCode().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(checksum);
        result = 31 * result + (charOccurenceInName != null ? charOccurenceInName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(roomNameWords);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "code=" + code +
                ", checksum=" + Arrays.toString(checksum) +
                ", charOccurenceInName=" + charOccurenceInName +
                ", roomNameWords=" + Arrays.toString(roomNameWords) +
                '}';
    }
}
