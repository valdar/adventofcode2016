package it.valdar.adventofcode.day10;

import it.valdar.adventofcode.day10.model.Bot;
import it.valdar.adventofcode.day10.model.Output;
import it.valdar.adventofcode.day10.model.ValueExchange;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        if( args.length ==0 ){
            throw new UnsupportedOperationException( "You must specify at least the path of the input file!" );
        } else if ( args.length == 1 ) {
            parseAndSolve(args[0], false);
        } else {
            parseAndSolve(args[0], Boolean.parseBoolean(args[1]));
        }
    }

    private static void parseAndSolve(String fileName, Boolean useSecondSolver ) throws NoSuchAlgorithmException {
        System.out.println(useSecondSolver ? "Second Part solver" : "First Part Solver");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            if(useSecondSolver){
                Map<Integer, Bot> bots = new HashMap<>();
                Map<Integer, Output> outputs = new HashMap<>();
                stream.forEach( s -> Functions.parse(s, bots, outputs) );

                Integer value0 = null;
                Integer value1 = null;
                Integer value2 = null;

                List<ValueExchange> valuesChanged = Functions.runStep( bots, outputs );
                while( !valuesChanged.isEmpty() && (value0 == null || value1 == null || value2 ==null ) ){
                    if( value0 == null && !outputs.get( 0 ).getValues().isEmpty() ){
                        value0 = outputs.get( 0 ).getValues().get(0);
                    }
                    if( value1 == null && !outputs.get( 1 ).getValues().isEmpty() ){
                        value1 = outputs.get( 1 ).getValues().get(0);
                    }
                    if( value2 == null && !outputs.get( 2 ).getValues().isEmpty() ){
                        value2 = outputs.get( 2 ).getValues().get(0);
                    }
                    valuesChanged = Functions.runStep( bots, outputs );
                }

                System.out.format(  "The (chip vale in output 0) x (chip vale in output 1) x (chip vale in output 2) is: Bot #[%d]\n", value0*value1*value2);

            } else {
                Map<Integer, Bot> bots = new HashMap<>();
                Map<Integer, Output> outputs = new HashMap<>();
                stream.forEach( s -> Functions.parse(s, bots, outputs) );

                Integer botId = null;
                boolean resultNotFound = true;
                List<ValueExchange> valuesChanged = Functions.runStep( bots, outputs );
                while( !valuesChanged.isEmpty() && resultNotFound ){
                    for( ValueExchange v :  valuesChanged) {
                        if( ( v.getComparedValueLeft().equals( new Integer(61) ) && v.getComparedValueRight().equals( new Integer(17) ) )
                                || ( v.getComparedValueLeft().equals( new Integer(17) ) && v.getComparedValueRight().equals( new Integer(61) ) ) ){
                            botId = v.getComparingBotId();
                            resultNotFound = false;
                        }
                    }
                    valuesChanged = Functions.runStep( bots, outputs );
                }

                System.out.format(  "The Bot that compared chip 61 and 17 is: Bot #[%d]\n", botId);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



