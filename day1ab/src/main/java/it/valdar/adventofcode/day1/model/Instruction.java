package it.valdar.adventofcode.day1.model;

/**
 * Created by valdar on 02/12/16.
 */
public class Instruction {
    private final Integer blocks;
    private final Turn turn;

    public Instruction(Integer blocks, Turn turn){
        this.blocks = blocks;
        this.turn = turn;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public Turn getTurn() {
        return turn;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "blocks=" + blocks +
                ", turn=" + turn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (getBlocks() != null ? !getBlocks().equals(that.getBlocks()) : that.getBlocks() != null) return false;
        return getTurn() == that.getTurn();

    }

    @Override
    public int hashCode() {
        int result = getBlocks() != null ? getBlocks().hashCode() : 0;
        result = 31 * result + (getTurn() != null ? getTurn().hashCode() : 0);
        return result;
    }

}
