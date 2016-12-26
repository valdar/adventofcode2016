package it.valdar.adventofcode.day12;

import it.valdar.adventofcode.day12.model.Cpy;
import it.valdar.adventofcode.day12.model.Dec;
import it.valdar.adventofcode.day12.model.Inc;
import it.valdar.adventofcode.day12.model.Instruction;
import it.valdar.adventofcode.day12.model.Jnz;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static Instruction parse(String input) {
        String[] chuncks = input.trim().split(" ");
        switch( chuncks[0] ){
            case "cpy": return new Cpy( chuncks[1], chuncks[2] );
            case "jnz": return new Jnz( chuncks[1], Integer.parseInt( chuncks[2] ) );
            case "inc": return new Inc( chuncks[1] );
            case "dec": return new Dec( chuncks[1] );
            default: throw new RuntimeException( "Instruction not recognised!" );
        }
    }

}