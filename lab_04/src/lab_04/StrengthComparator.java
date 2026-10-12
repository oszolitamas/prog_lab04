package lab_04;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Beer> {
	public int compare(Beer b1, Beer b2) {
		return Double.compare(b1.getStrength(), b2.getStrength());
	}
}
