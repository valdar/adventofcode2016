package it.valdar.adventofcode.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
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
            Map<Character, Integer>[] identity = new Map[8];
            IntStream.rangeClosed(0,7).forEach( i -> identity[i] = new HashMap<>() );

            System.out.print("The bathroom code is: ");
            Map<Character, Integer>[] accumulated = stream.map( s -> Functions.countOccurrency(s) ).reduce( identity, (m1,m2) -> Functions.merge( m1, m2 ) );
            IntStream.rangeClosed(0,7).forEach( i -> {
                if (useSecondSolver) {
                    System.out.print(Collections.min(accumulated[i].entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey());
                } else {
                    System.out.print(Collections.max(accumulated[i].entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey());
                }
            });
            System.out.print("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



