package it.valdar.adventofcode.day8;

import it.valdar.adventofcode.day8.model.Command;
import it.valdar.adventofcode.day8.model.DrawRectangleCommand;
import it.valdar.adventofcode.day8.model.RotateColumnCommand;
import it.valdar.adventofcode.day8.model.RotateRowCommand;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static Command parse(String input) {
        String[] chunks = input.trim().split(" ");

        switch (chunks[0]){
            case "rect": return new DrawRectangleCommand(   Integer.parseInt(chunks[1].split("x")[0]),
                                                            Integer.parseInt(chunks[1].split("x")[1]) );
            case "rotate": {
                switch (chunks[1]){
                    case "row": return new RotateRowCommand(    Integer.parseInt( chunks[2].substring(2) ),
                                                                Integer.parseInt( chunks[4] ));
                    case "column": return new RotateColumnCommand(  Integer.parseInt( chunks[2].substring(2) ),
                                                                    Integer.parseInt( chunks[4] ));
                    default: return null;
                }
            }

            default: return null;
        }
    }

}