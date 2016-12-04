package it.valdar.adventofcode.day2;

import it.valdar.adventofcode.day2.model.Instruction;
import it.valdar.adventofcode.day2.model.Key;
import it.valdar.adventofcode.day2.model.Keypad;
import it.valdar.adventofcode.day2.model.NormalKeypad;
import it.valdar.adventofcode.day2.model.OverEngineeredKeypad;

import java.util.Arrays;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static Instruction[] parseInput(String input ){
        Instruction[] result = Arrays.stream(input.trim().split(""))
                .map( s -> {
                    switch (s) {
                        case "U":
                            return Instruction.U;
                        case "D":
                            return Instruction.D;
                        case "L":
                            return Instruction.L;
                        case "R":
                            return Instruction.R;
                        default: throw new RuntimeException("Not recognised instruction");
                    }
                } ).toArray(Instruction[]::new);
        return result;
    }

    public static Key solve(Instruction[] instructions, Key startingKey, Boolean useSecondSolver) {
        Keypad keypad;

        if(useSecondSolver){
            keypad = new OverEngineeredKeypad();
        } else {
            keypad = new NormalKeypad();
        }

        Key currentKey = startingKey;
        for( Instruction currInst : instructions){
            currentKey = keypad.nextKey( currInst, currentKey );
        }

        return currentKey;
    }

}