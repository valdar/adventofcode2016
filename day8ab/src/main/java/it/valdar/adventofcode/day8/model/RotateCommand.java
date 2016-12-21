package it.valdar.adventofcode.day8.model;

import java.util.stream.IntStream;

/**
 * Created by valdar on 21/12/16.
 */
public abstract class RotateCommand implements Command{

    protected int index;
    protected int shift;

    public RotateCommand(int index, int shift) {
        this.index = index;
        this.shift = shift;
    }

    protected int[] rotate(int[] array, int shift ){
        int[] result = new int[array.length];
        IntStream.range(0, array.length).forEach( i -> {
            int shiftedPosition = (i+shift) % array.length;
            result[shiftedPosition] = array[i];
        } );
        return result;
    }
}
