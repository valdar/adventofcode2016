package it.valdar.adventofcode.day2;

import it.valdar.adventofcode.day2.model.Key;
import it.valdar.adventofcode.day2.model.KeyHolder;

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

    private static void parseAndSolve(String fileName, Boolean useSecondSolver ) {
        System.out.println(useSecondSolver ? "Second Part solver" : "First Part Solver");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            final KeyHolder keyHolder = new KeyHolder( Key.FIVE );
            System.out.print("The bathroom code is: ");
            stream.forEach(s -> {
                keyHolder.setKey( Functions.solve(Functions.parseInput(s), keyHolder.getKey(), useSecondSolver) );
                System.out.print( keyHolder.getKey() + " ");
            });
            System.out.print("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



