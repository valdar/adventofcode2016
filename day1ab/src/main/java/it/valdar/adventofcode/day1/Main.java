package it.valdar.adventofcode.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        if( args.length ==0 ){
            throw new UnsupportedOperationException( "You must specify at least the path of the input file!" );
        } else if ( args.length == 1 ) {
            parseAndSolve(args[0], false);
        } else {
            parseAndSolve(args[0], Boolean.parseBoolean(args[1]));
        }
    }

    private static void parseAndSolve(String fileName, Boolean stopAtFirstVisitedTwice ) {
        System.out.println(stopAtFirstVisitedTwice ? "Second Part solver" : "First Part Solver");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(s -> System.out.format("You are, %d blocks away \n", Functions.solve(Functions.parseInput(s), stopAtFirstVisitedTwice)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



