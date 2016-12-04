package it.valdar.adventofcode.day2.model;

/**
 * Created by valdar on 04/12/16.
 */
public interface Keypad {
    Key nextKey(Instruction inst, Key key);
}
