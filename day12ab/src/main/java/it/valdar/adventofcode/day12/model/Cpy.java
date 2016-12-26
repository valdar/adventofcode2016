package it.valdar.adventofcode.day12.model;

import java.util.Map;

/**
 * Created by valdar on 26/12/16.
 */
public class Cpy implements Instruction{
    String registryA = null;
    String registryB = null;
    Integer valueA = null;
    Integer valueB = null;

    public Cpy(String a, String b) {
        try{
            valueA = Integer.parseInt(a);
        } catch (Exception e){
            registryA = a;
        }
        try{
            valueB = Integer.parseInt(b);
        } catch (Exception e){
            registryB = b;
        }
    }

    @Override
    public int apply(Map<String, Integer> registries) {
        if( registryA != null && registryB != null ){
            registries.put( registryB, registries.get(registryA) );
        } else if ( valueA != null && registryB != null ){
            registries.put( registryB, valueA );
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Cpy{" +
                "registryA='" + registryA + '\'' +
                ", registryB='" + registryB + '\'' +
                ", valueA=" + valueA +
                ", valueB=" + valueB +
                '}';
    }
}
