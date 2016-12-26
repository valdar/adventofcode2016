package it.valdar.adventofcode.day11;

import it.valdar.adventofcode.day11.model.Item;
import it.valdar.adventofcode.day11.model.State;
import it.valdar.adventofcode.day11.model.Type;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        if ( args.length == 0 ) {
            parseAndSolve(false);
        } else {
            parseAndSolve(Boolean.parseBoolean(args[0]));
        }
    }

    private static void parseAndSolve( Boolean useSecondSolver ) throws NoSuchAlgorithmException {
        System.out.println(useSecondSolver ? "Second Part solver" : "First Part Solver");

        Item GS = new Item(Type.GENERATOR, "S" );
        Item CS = new Item(Type.CHIP, "S" );
        Item GP = new Item(Type.GENERATOR, "P" );
        Item CP = new Item(Type.CHIP, "P" );

        Item GT = new Item(Type.GENERATOR, "T" );
        Item CT = new Item(Type.CHIP, "T" );

        Item GR = new Item(Type.GENERATOR, "R" );
        Item CR = new Item(Type.CHIP, "R" );
        Item GC = new Item(Type.GENERATOR, "C" );
        Item CC = new Item(Type.CHIP, "C" );

        if(useSecondSolver){
            Item GH = new Item(Type.GENERATOR, "H" );
            Item CH = new Item(Type.CHIP, "H" );
            Item GD = new Item(Type.GENERATOR, "D" );
            Item CD = new Item(Type.CHIP, "D" );

            Map<Item, Integer> startPosition = new HashMap(){{
                put( GS, 1 );
                put( CS, 1 );
                put( GP, 1 );
                put( CP, 1 );

                put( GT, 2 );
                put( GR, 2 );
                put( CR, 2 );
                put( GC, 2 );
                put( CC, 2 );

                put( CT, 3 );

                put( GH, 1 );
                put( CH, 1 );
                put( GD, 1 );
                put( CD, 1 );
            }};

            Map<Item, Integer> targetPosition = new HashMap(){{
                put( GS, 4 );
                put( CS, 4 );
                put( GP, 4 );
                put( CP, 4 );

                put( GT, 4 );
                put( GR, 4 );
                put( CR, 4 );
                put( GC, 4 );
                put( CC, 4 );

                put( CT, 4 );

                put( GH, 4 );
                put( CH, 4 );
                put( GD, 4 );
                put( CD, 4 );
            }};


            System.out.format(  "The number of moves to bring everything to floor 4 is: %d\n",
                    Functions.solver( new State( startPosition, 1, 4 ), new State( targetPosition, 4, 4 ))
            );
        } else {


                Map<Item, Integer> startPosition = new HashMap(){{
                    put( GS, 1 );
                    put( CS, 1 );
                    put( GP, 1 );
                    put( CP, 1 );

                    put( GT, 2 );
                    put( GR, 2 );
                    put( CR, 2 );
                    put( GC, 2 );
                    put( CC, 2 );

                    put( CT, 3 );
                }};

                Map<Item, Integer> targetPosition = new HashMap(){{
                    put( GS, 4 );
                    put( CS, 4 );
                    put( GP, 4 );
                    put( CP, 4 );

                    put( GT, 4 );
                    put( GR, 4 );
                    put( CR, 4 );
                    put( GC, 4 );
                    put( CC, 4 );

                    put( CT, 4 );
                }};

                System.out.format(  "The number of moves to bring everything to floor 4 is: %d\n",
                        Functions.solver( new State( startPosition, 1, 4 ), new State( targetPosition, 4, 4 ))
                );
            }
    }

}



