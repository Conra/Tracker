package comparator;

import java.util.Comparator;

import model.dto.Coordinate;

public class CoordinateComparator implements Comparator<Coordinate>{

	@Override
	public int compare(Coordinate arg0, Coordinate arg1) {
        if (arg0.getLon() < arg1.getLon()) return -1;
        if (arg0.getLon() > arg1.getLon()) return +1;
        if (arg0.getLat() < arg1.getLat()) return -1;
        if (arg0.getLat() > arg1.getLat()) return +1;
        return 0;
	}

}
