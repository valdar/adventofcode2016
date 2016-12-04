package it.valdar.adventofcode.day2.model;

/**
 * Created by valdar on 04/12/16.
 */
public class KeyInstruction {
    private final Key key;
    private final Instruction inst;

    public KeyInstruction(Key key, Instruction inst) {
        this.key = key;
        this.inst = inst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyInstruction that = (KeyInstruction) o;

        if (key != that.key) return false;
        return inst == that.inst;

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (inst != null ? inst.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KeyInstruction{" +
                "key=" + key +
                ", inst=" + inst +
                '}';
    }
}
