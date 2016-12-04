package it.valdar.adventofcode.day2.model;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by valdar on 04/12/16.
 */
public class OverEngineeredKeypad implements Keypad {

    @Override
    public Key nextKey(Instruction inst, Key key) {
        return keyInstructionToKeyLookup.get( new KeyInstruction( key, inst ) );
    }

    private static final Map<KeyInstruction, Key> keyInstructionToKeyLookup = Collections.unmodifiableMap(
            Stream.of(
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.ONE, Instruction.U ), Key.ONE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.ONE, Instruction.D ), Key.THREE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.ONE, Instruction.L ), Key.ONE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.ONE, Instruction.R ), Key.ONE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.TWO, Instruction.U ), Key.TWO),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.TWO, Instruction.D ), Key.SIX),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.TWO, Instruction.L ), Key.TWO),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.TWO, Instruction.R ), Key.THREE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.THREE, Instruction.U ), Key.ONE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.THREE, Instruction.D ), Key.SEVEN),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.THREE, Instruction.L ), Key.TWO),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.THREE, Instruction.R ), Key.FOUR),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FOUR, Instruction.U ), Key.FOUR),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FOUR, Instruction.D ), Key.EIGHT),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FOUR, Instruction.L ), Key.THREE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FOUR, Instruction.R ), Key.FOUR),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FIVE, Instruction.U ), Key.FIVE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FIVE, Instruction.D ), Key.FIVE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FIVE, Instruction.L ), Key.FIVE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.FIVE, Instruction.R ), Key.SIX),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SIX, Instruction.U ), Key.TWO),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SIX, Instruction.D ), Key.A),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SIX, Instruction.L ), Key.FIVE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SIX, Instruction.R ), Key.SEVEN),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SEVEN, Instruction.U ), Key.THREE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SEVEN, Instruction.D ), Key.B),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SEVEN, Instruction.L ), Key.SIX),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.SEVEN, Instruction.R ), Key.EIGHT),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.EIGHT, Instruction.U ), Key.FOUR),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.EIGHT, Instruction.D ), Key.C),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.EIGHT, Instruction.L ), Key.SEVEN),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.EIGHT, Instruction.R ), Key.NINE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.NINE, Instruction.U ), Key.NINE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.NINE, Instruction.D ), Key.NINE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.NINE, Instruction.L ), Key.EIGHT),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.NINE, Instruction.R ), Key.NINE),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.A, Instruction.U ), Key.SIX),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.A, Instruction.D ), Key.A),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.A, Instruction.L ), Key.A),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.A, Instruction.R ), Key.B),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.B, Instruction.U ), Key.SEVEN),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.B, Instruction.D ), Key.D),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.B, Instruction.L ), Key.A),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.B, Instruction.R ), Key.C),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.C, Instruction.U ), Key.EIGHT),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.C, Instruction.D ), Key.C),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.C, Instruction.L ), Key.B),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.C, Instruction.R ), Key.C),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.D, Instruction.U ), Key.B),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.D, Instruction.D ), Key.D),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.D, Instruction.L ), Key.D),
            new AbstractMap.SimpleEntry<>(new KeyInstruction( Key.D, Instruction.R ), Key.D) )
            .collect( Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()) )
    );
}
