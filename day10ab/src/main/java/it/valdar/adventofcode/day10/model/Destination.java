package it.valdar.adventofcode.day10.model;

import java.util.List;

/**
 * Created by valdar on 21/12/16.
 */
public interface Destination {
    void give(Integer value);
    void prepareStep();
    boolean isCommittable();
    List<ValueExchange> commitStep();
}
