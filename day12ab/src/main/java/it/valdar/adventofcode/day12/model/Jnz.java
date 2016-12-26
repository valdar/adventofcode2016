package it.valdar.adventofcode.day12.model;

import java.util.Map;

/**
 * Created by valdar on 26/12/16.
 */
public class Jnz implements Instruction{
    String registryA = null;
    Integer valueA = null;
    Integer offset = null;

    public Jnz(String fisrtOperand, Integer offset) {
        try{
            valueA = Integer.parseInt(fisrtOperand);
        } catch (Exception e){
            registryA = fisrtOperand;
        }
        this.offset = offset;
    }

    @Override
    public int apply(Map<String, Integer> registries) {
        if( registryA != null ) {
            return registries.get( registryA ) == 0 ? 1 : offset;
        } else if ( valueA != null ) {
            return valueA == 0 ? 1 : offset;
        } else {
            throw new RuntimeException( "First operand of Jnz not supported!" );
        }
    }

    @Override
    public String toString() {
        return "Jnz{" +
                "registryA='" + registryA + '\'' +
                ", valueA=" + valueA +
                ", offset=" + offset +
                '}';
    }
}
