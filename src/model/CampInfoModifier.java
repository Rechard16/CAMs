package model;

import java.util.ArrayList;
import java.util.List;

public class CampInfoModifier {
	private final List<Change> changes;
	
	public CampInfoModifier() {
		changes = new ArrayList<>();
	}
	
	public CampInfoModifier(List<Change> changes) {
		this.changes = changes;
	}
	
	public void add(Change c) {
		for (int i=0;i<changes.size();i++)
			if (c.getClass().equals(changes.get(i).getClass())) {
				changes.set(i, c);
				return;
			}
		changes.add(c);
	}
	
	public Camp modify(Camp camp) {
		Camp modified = new Camp(camp);
		for (Change change: changes)
			change.modify(modified.getInformation());
		return modified;
	}
}
