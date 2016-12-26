package it.valdar.adventofcode.day12.model;

import java.util.Map;

/**
 * Created by valdar on 26/12/16.
 */
public interface Instruction {

    int apply( Map<String, Integer> registries );
}
