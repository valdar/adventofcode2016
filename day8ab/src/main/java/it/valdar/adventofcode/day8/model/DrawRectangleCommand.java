package it.valdar.adventofcode.day8.model;

import java.util.stream.IntStream;

/**
 * Created by valdar on 20/12/16.
 */
public class DrawRectangleCommand implements Command {

    private int wide;
    private int tall;

    public DrawRectangleCommand(int wide, int tall) {
        this.wide = wide;
        this.tall = tall;
    }

    @Override
    public Display apply(Display display) {
        IntStream.range(0, tall).forEach( row -> IntStream.range(0, wide).forEach( col -> display.switchPixelOn( col, row ) ) );
        return display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrawRectangleCommand that = (DrawRectangleCommand) o;

        if (wide != that.wide) return false;
        return tall == that.tall;

    }

    @Override
    public int hashCode() {
        int result = wide;
        result = 31 * result + tall;
        return result;
    }

    @Override
    public String toString() {
        return "DrawRectangleCommand{" +
                "wide=" + wide +
                ", tall=" + tall +
                '}';
    }
}
