package it.valdar.adventofcode.day10;

import it.valdar.adventofcode.day10.model.Bot;
import it.valdar.adventofcode.day10.model.Destination;
import it.valdar.adventofcode.day10.model.Output;
import it.valdar.adventofcode.day10.model.ValueExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    private final static String VALUE = "value";
    private final static String BOT = "bot";
    private final static String OUTPUT = "output";

    public static void parse(String input, Map<Integer,Bot> bots, Map<Integer,Output> outputs) {
        String[] chunks = input.trim().split(" ");
        switch ( chunks[0] ){
            case BOT: {
                Integer botId = Integer.parseInt(chunks[1]);
                Bot bot = getBot( botId, bots );
                bot.setLowDestination( createDestination( chunks[5], Integer.parseInt(chunks[6]), bots, outputs) );
                bot.setHighDestination( createDestination( chunks[10], Integer.parseInt(chunks[11]),bots, outputs ) );
                break;
            }
            case VALUE: {
                Integer value = Integer.parseInt(chunks[1]);
                Integer botId = Integer.parseInt(chunks[5]);
                Bot bot = getBot( botId, bots );
                bot.give( value );
                bot.commitStep();
                break;
            }
            default: throw new RuntimeException( "Unsupported input!!!" );
        }
    }

    private static Bot getBot( Integer botId, Map<Integer, Bot> bots ){
        Bot existingBot = bots.get( botId );
        if (existingBot == null){
            existingBot = new Bot( botId );
            bots.put( botId, existingBot);
        }
        return existingBot;
    }

    private static Destination createDestination(String destinationType, int destinationId, Map<Integer,Bot> bots, Map<Integer,Output> outputs) {
        switch ( destinationType ){
            case BOT: {
                Bot bot = getBot( destinationId, bots);
                return bot;
            }
            case OUTPUT: {
                Output existingOutput = outputs.get( destinationId );
                if (existingOutput == null){
                    existingOutput = new Output( destinationId );
                    outputs.put( destinationId, existingOutput);
                }
                return existingOutput;
            }
            default: throw new RuntimeException( "Unsupported input!!!" );
        }
    }

    public static List<ValueExchange> runStep(Map<Integer, Bot> bots, Map<Integer, Output> outputs) {
        bots.values().forEach( b -> b.prepareStep());

        bots.values().forEach( b -> {
            if( !b.isCommittable() )
                throw new RuntimeException( "Bot ["+b.getBotId()+"] is not committable!!!" );
        }  );

        outputs.values().forEach( o -> {
            if( !o.isCommittable() )
                throw new RuntimeException( "Output bin ["+o.getOutputId()+"] is not committable!!!" );
        }  );
        outputs.values().forEach( o -> o.commitStep() );

        return bots.values().stream().map( b -> b.commitStep() ).flatMap( c -> c.stream() ).collect( Collectors.toList() );
    }


}