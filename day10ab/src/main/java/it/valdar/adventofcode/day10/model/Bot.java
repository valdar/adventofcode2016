package it.valdar.adventofcode.day10.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valdar on 21/12/16.
 */
public class Bot implements Destination{
    private Integer botId = null;
    private Integer leftValue = null;
    private Integer rightValue = null;
    private List<Integer> incomingValues = new ArrayList<>();
    private List<ValueExchange> valuesExchanged = new ArrayList<>();

    private Destination highDestination = null;
    private Destination lowDestination = null;

    public Bot(Integer botId) {
        this.botId = botId;
    }

    @Override
    public void give(Integer value) {
        incomingValues.add( value );
    }

    @Override
    public void prepareStep() {
        if(leftValue != null && rightValue != null  ){
            if( leftValue >= rightValue){
                highDestination.give(leftValue);
                lowDestination.give(rightValue);
            } else {
                highDestination.give(rightValue);
                lowDestination.give(leftValue);
            }

            valuesExchanged.add( new ValueExchange( botId, leftValue, rightValue ) );

            leftValue = null;
            rightValue =null;
        }
    }

    @Override
    public List<ValueExchange> commitStep() {
        List<ValueExchange> result = valuesExchanged;
        for( Integer currValue : incomingValues ){
            if( leftValue == null ){
                leftValue = currValue;
            } else if( rightValue == null ) {
                rightValue = currValue;
            } else {
                throw new RuntimeException( "Bot ["+botId+"] has booth hands full, while trying to handle value: "+currValue );
            }
        }
        incomingValues = new ArrayList<>();
        valuesExchanged = new ArrayList<>();
        return result;
    }

    @Override
    public boolean isCommittable() {
        int freeHands = 0;
        freeHands = leftValue == null ? freeHands+1 : freeHands;
        freeHands = rightValue == null ? freeHands+1 : freeHands;
        return freeHands >= incomingValues.size();
    }

    public Integer getBotId() {
        return botId;
    }

    public void setBotId(Integer botId) {
        this.botId = botId;
    }

    public Integer getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(Integer leftValue) {
        this.leftValue = leftValue;
    }

    public Integer getRightValue() {
        return rightValue;
    }

    public void setRightValue(Integer rightValue) {
        this.rightValue = rightValue;
    }

    public Destination getHighDestination() {
        return highDestination;
    }

    public void setHighDestination(Destination highDestination) {
        this.highDestination = highDestination;
    }

    public Destination getLowDestination() {
        return lowDestination;
    }

    public void setLowDestination(Destination lowDestination) {
        this.lowDestination = lowDestination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bot bot = (Bot) o;

        return botId.equals(bot.botId);

    }

    @Override
    public int hashCode() {
        return botId.hashCode();
    }
}
