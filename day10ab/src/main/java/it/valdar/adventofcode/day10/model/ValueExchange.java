package it.valdar.adventofcode.day10.model;

/**
 * Created by valdar on 21/12/16.
 */
public class ValueExchange {
    private Integer comparingBotId;
    private Integer comparedValueLeft;
    private Integer comparedValueRight;

    public ValueExchange(Integer comparingBotId,
                         Integer comparedValueLeft,
                         Integer comparedValueRight) {
        this.comparingBotId = comparingBotId;
        this.comparedValueLeft = comparedValueLeft;
        this.comparedValueRight = comparedValueRight;
    }

    public Integer getComparingBotId() {
        return comparingBotId;
    }

    public Integer getComparedValueLeft() {
        return comparedValueLeft;
    }

    public Integer getComparedValueRight() {
        return comparedValueRight;
    }

    @Override
    public String toString() {
        return "ValueExchange{" +
                "comparingBotId=" + comparingBotId +
                ", comparedValueLeft=" + comparedValueLeft +
                ", comparedValueRight=" + comparedValueRight +
                '}';
    }
}
