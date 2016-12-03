package it.valdar.adventofcode.day1.model;

/**
 * Created by valdar on 03/12/16.
 */
public class LocationCoordinate {
    private final Integer nortSouth;
    private final Integer westEst;

    public LocationCoordinate(Integer nortSouth, Integer westEst) {
        this.nortSouth = nortSouth;
        this.westEst = westEst;
    }

    public Integer getNortSouth() {
        return nortSouth;
    }

    public Integer getWestEst() {
        return westEst;
    }

    public LocationCoordinate move( Direction dir, Integer numberOfBlocks ){
        switch ( dir ) {
            case NORTH: return new LocationCoordinate(nortSouth+numberOfBlocks, westEst);
            case SOUTH: return new LocationCoordinate(nortSouth-numberOfBlocks, westEst);
            case WEST: return new LocationCoordinate(nortSouth, westEst+numberOfBlocks);
            case EST: return new LocationCoordinate(nortSouth, westEst-numberOfBlocks);
            default: throw new UnsupportedOperationException( "Unrecognized Direction" );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationCoordinate that = (LocationCoordinate) o;

        if (getNortSouth() != null ? !getNortSouth().equals(that.getNortSouth()) : that.getNortSouth() != null)
            return false;
        return getWestEst() != null ? getWestEst().equals(that.getWestEst()) : that.getWestEst() == null;

    }

    @Override
    public int hashCode() {
        int result = getNortSouth() != null ? getNortSouth().hashCode() : 0;
        result = 31 * result + (getWestEst() != null ? getWestEst().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LocationCoordinate{" +
                "nortSouth=" + nortSouth +
                ", westEst=" + westEst +
                '}';
    }
}
