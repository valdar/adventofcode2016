package it.valdar.adventofcode.day8.model;

/**
 * Created by valdar on 21/12/16.
 */
public class RotateRowCommand extends RotateCommand {

    public RotateRowCommand(int index, int shift) {
        super(index, shift);
    }

    @Override
    public Display apply(Display display) {
        display.setRow( index, rotate( display.getRow( index ), shift ) );
        return display;
    }
}
