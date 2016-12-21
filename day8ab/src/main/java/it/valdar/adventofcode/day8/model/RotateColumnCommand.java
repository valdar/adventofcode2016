package it.valdar.adventofcode.day8.model;

/**
 * Created by valdar on 21/12/16.
 */
public class RotateColumnCommand extends RotateCommand {

    public RotateColumnCommand(int index, int shift) {
        super(index, shift);
    }

    @Override
    public Display apply(Display display) {
        display.setColumn( index, rotate( display.getColumn( index ), shift ) );
        return display;
    }
}
