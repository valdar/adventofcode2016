package it.valdar.adventofcode.day10;

import it.valdar.adventofcode.day10.model.Bot;
import it.valdar.adventofcode.day10.model.Output;
import it.valdar.adventofcode.day10.model.ValueExchange;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by valdar on 02/12/16.
 */
public class Day10Tests {

    @Test
    public void day10Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Map<Integer, Bot> bots = new HashMap<>();
        Map<Integer, Output> outputs = new HashMap<>();

        Functions.parse("value 5 goes to bot 2", bots, outputs);
        Functions.parse("bot 2 gives low to bot 1 and high to bot 0", bots, outputs);
        Functions.parse("value 3 goes to bot 1", bots, outputs);
        Functions.parse("bot 1 gives low to output 1 and high to bot 0", bots, outputs);
        Functions.parse("bot 0 gives low to output 2 and high to output 0", bots, outputs);
        Functions.parse("value 2 goes to bot 2", bots, outputs);

        assertTrue( !bots.isEmpty() );
        assertTrue( !outputs.isEmpty() );

        List<ValueExchange> result = new ArrayList<>();
        List<ValueExchange> valuesChanged = Functions.runStep( bots, outputs );
        while( !valuesChanged.isEmpty() ){
            result.addAll( valuesChanged );
            valuesChanged = Functions.runStep( bots, outputs );
        }

        assertTrue( !result.isEmpty() );
        assertTrue( outputs.get( 0 ).getValues().contains( new Integer(5) ) );
        assertTrue( outputs.get( 1 ).getValues().contains( 2 ) );
        assertTrue( outputs.get( 2 ).getValues().contains( 3 ) );

        Integer comparingFiveWithTwoBotId = null;
        for( ValueExchange v :  result) {
            if( ( v.getComparedValueLeft().equals( new Integer(5) ) && v.getComparedValueRight().equals( new Integer(2) ) )
                    || ( v.getComparedValueLeft().equals( new Integer(2) ) && v.getComparedValueRight().equals( new Integer(5) ) ) ){
                comparingFiveWithTwoBotId = v.getComparingBotId();
            }
        }
        assertEquals( new Integer(2), comparingFiveWithTwoBotId );
    }

}
