package it.valdar.adventofcode.day12.model;

import java.util.Map;

/**
 * Created by valdar on 26/12/16.
 */
public class Dec implements Instruction {

    String registry = null;

    public Dec(String registry) {
        this.registry = registry;
    }

    @Override
    public int apply(Map<String, Integer> registries) {
        registries.compute( registry, (k,v) -> v-1 );
        return 1;
    }

    @Override
    public String toString() {
        return "Dec{" +
                "registry='" + registry + '\'' +
                '}';
    }
}
