package it.valdar.adventofcode.day5;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        if( args.length ==0 ){
            throw new UnsupportedOperationException( "You must specify at least the string to decode!" );
        } else if ( args.length == 1 ) {
            parseAndSolve(args[0], false);
        } else {
            parseAndSolve(args[0], Boolean.parseBoolean(args[1]));
        }
    }

    private static void parseAndSolve(String stringToDecode, Boolean useSecondSolver ) throws NoSuchAlgorithmException {
        System.out.println(useSecondSolver ? "Second Part solver" : "First Part Solver");
        if(useSecondSolver){
            System.out.format( "Decoded string is: %s \n", Functions.decode2( stringToDecode ) );
        }else {
            System.out.format( "Decoded string is: %s \n", Functions.decode1( stringToDecode ) );
        }

    }

}



