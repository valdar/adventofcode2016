package it.valdar.adventofcode.day4;

import it.valdar.adventofcode.day4.model.Room;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day4Tests {

    @Test
    public void inputParsingTest() {
        String input = "aaaaa-bbb-z-y-x-123[abxyz]\n";

        Integer roomCode = 123;
        Character[] checksum = {'a', 'b', 'x', 'y', 'z' };
        Map<Character, Integer> charOccurenceInName = new HashMap<Character, Integer>(){{
            put('a', 5);
            put('b', 3);
            put('z', 1);
            put('y', 1);
            put('x', 1);
        }};
        String[] roomNameWords = {"aaaaa", "bbb", "z", "y", "x"};

        Room espectedRoom = new Room( roomCode, checksum, charOccurenceInName, roomNameWords );
        Room room = Functions.parseInput( input );
        assertEquals( espectedRoom, room);
    }

    @Test
    public void solverOneTest() {
        Room room1 = Functions.parseInput("aaaaa-bbb-z-y-x-123[abxyz]\n");
        Room room2 = Functions.parseInput("a-b-c-d-e-f-g-h-987[abcde]\n");
        Room room3 = Functions.parseInput("not-a-real-room-404[oarel]\n");
        Room room4 = Functions.parseInput("totally-real-room-200[decoy]\n");

        assertTrue( room1.isValidRoom() );
        assertTrue( room2.isValidRoom() );
        assertTrue( room3.isValidRoom() );
        assertFalse( room4.isValidRoom() );
    }

    @Test
    public void roomdecodeNameTest() {
        Room room = Functions.parseInput("qzmt-zixmtkozy-ivhz-343[abxyz]\n");

        assertEquals( "very encrypted name", room.decodeRoomName());
    }
}
