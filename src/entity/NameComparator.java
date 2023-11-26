package entity;

import java.util.Comparator;

/**
 * The NameComparator class is used to compare two Nameable objects.
 * It is used in the Suggestion class.
 */
public class NameComparator implements Comparator<Nameable> {
	@Override
	public int compare(Nameable o1, Nameable o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
