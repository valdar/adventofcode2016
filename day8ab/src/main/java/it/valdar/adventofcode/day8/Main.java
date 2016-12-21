package it.valdar.adventofcode.day8;

import it.valdar.adventofcode.day8.model.Display;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
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
                Display display = new Display( 50, 6 );
                stream.map( s -> Functions.parse( s.trim() ) ).forEach( c -> c.apply( display ) );
                System.out.println( "The print out of the display is:");
                display.print( System.out );
            } else {
                Display display = new Display( 50, 6 );
                stream.map( s -> Functions.parse( s.trim() ) ).forEach( c -> c.apply( display ) );
                System.out.format( "The number of ON pixels is: %d\n", display.getSwitchedOnPixels() );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



