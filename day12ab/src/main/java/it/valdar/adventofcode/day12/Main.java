package it.valdar.adventofcode.day12;

import it.valdar.adventofcode.day12.model.Computer;
import it.valdar.adventofcode.day12.model.Instruction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
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
                Instruction[] program = stream.map( s -> Functions.parse( s ) ).toArray(size -> new Instruction[size]);
                Map<String, Integer> registries = new HashMap(){{
                    put( "a", 0 );
                    put( "b", 0 );
                    put( "c", 1 );
                    put( "d", 0 );
                }};

                Computer pc = new Computer( registries, 0);

                pc.runProgram( program );

                System.out.format(  "The content of registry \"a\" after running the program is: %d\n", pc.getRegisrtyValue("a") );
            } else {
                Instruction[] program = stream.map( s -> Functions.parse( s ) ).toArray(size -> new Instruction[size]);
                Map<String, Integer> registries = new HashMap(){{
                    put( "a", 0 );
                    put( "b", 0 );
                    put( "c", 0 );
                    put( "d", 0 );
                }};

                Computer pc = new Computer( registries, 0);

                pc.runProgram( program );

                System.out.format(  "The content of registry \"a\" after running the program is: %d\n", pc.getRegisrtyValue("a") );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



