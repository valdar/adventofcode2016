package it.valdar.adventofcode.day7;

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
            if(useSecondSolver){
                System.out.format(  "The number of IPs that support TLS is: %d\n",
                        stream.filter( s -> Functions.parse2( s.replace("\n", "") ) ).count()
                );
            } else {
                System.out.format(  "The number of IPs that support TLS is: %d\n",
                        stream.filter( s -> Functions.parse( s.replace("\n", "") ) ).count()
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



