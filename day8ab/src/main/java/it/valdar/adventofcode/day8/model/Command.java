package it.valdar.adventofcode.day8.model;

/**
 * Created by valdar on 20/12/16.
 */
public interface Command {
    Display apply( Display display );
}
