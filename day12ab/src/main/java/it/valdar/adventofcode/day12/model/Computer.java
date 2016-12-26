package it.valdar.adventofcode.day12.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by valdar on 26/12/16.
 */
public class Computer {
    Map<String, Integer> registries = new HashMap<>();
    int pc = 0;

    public Computer(Map<String, Integer> registries, int pc) {
        this.registries = registries;
        this.pc = pc;
    }

    public void runProgram( Instruction[] program ){
        while( pc < program.length && pc >= 0 ){
            pc = pc + program[pc].apply( registries );
        }
    }

    public Integer getRegisrtyValue(String registry){
        return registries.get( registry );
    }
}
