package it.valdar.adventofcode.day4;

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
            if(useSecondSolver) {
                System.out.print("The sector ID of \"northpole object storage\" room is: ");
                stream.map(s -> Functions.parseInput(s))
                        .filter(r -> r.isValidRoom())
                        .filter( vr -> vr.decodeRoomName().equals("northpole object storage") )
                        .forEach( theroom -> System.out.print(  theroom.getCode() ) );
                System.out.print("\n");
            } else {
                System.out.format("The sum of valid room code is %d\n",
                        stream.map(s -> Functions.parseInput(s)).filter(r -> r.isValidRoom()).mapToInt(vr -> vr.getCode()).sum());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



