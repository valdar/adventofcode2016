package it.valdar.adventofcode.day11.model;

/**
 * Created by valdar on 22/12/16.
 */
public class Item {
    private Type type;
    private String elemntName;

    public Item(Type type, String elemntName) {
        this.type = type;
        this.elemntName = elemntName;
    }

    public Type getType() {
        return type;
    }

    public String getElemntName() {
        return elemntName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (getType() != item.getType()) return false;
        return getElemntName().equals(item.getElemntName());

    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getElemntName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        switch ( type ){
            case GENERATOR: return "[G"+elemntName+"]";
            case CHIP: return "[C"+elemntName+"]";
            default: return "["+type+elemntName+"]";
        }

    }
}
