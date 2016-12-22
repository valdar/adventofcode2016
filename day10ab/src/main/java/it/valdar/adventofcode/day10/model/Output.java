package it.valdar.adventofcode.day10.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valdar on 21/12/16.
 */
public class Output implements Destination{
    private Integer outputId = null;
    private List<Integer> values = new ArrayList<>();
    private List<Integer> givenvalues = new ArrayList<>();

    public Output( Integer outputId ) {
        this.outputId = outputId;
    }

    public boolean contains(Integer value){
        return values.contains( value );
    }

    @Override
    public void give(Integer value) {
        givenvalues.add(value);
    }

    @Override
    public void prepareStep() {
        //nothing to do
    }

    @Override
    public List<ValueExchange> commitStep() {
        values.addAll( givenvalues );
        givenvalues = new ArrayList<>();
        return new ArrayList<>();
    }

    @Override
    public boolean isCommittable() {
        return true;
    }

    public Integer getOutputId() {
        return outputId;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Output output = (Output) o;

        if (!getOutputId().equals(output.getOutputId())) return false;
        return getValues() != null ? getValues().equals(output.getValues()) : output.getValues() == null;

    }

    @Override
    public int hashCode() {
        return getOutputId().hashCode();
    }

    @Override
    public String toString() {
        return "Output{" +
                "outputId=" + outputId +
                ", values=" + values +
                ", givenvalues=" + givenvalues +
                '}';
    }
}
