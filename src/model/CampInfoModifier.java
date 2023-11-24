package model;

import java.util.ArrayList;
import java.util.List;

import model.change.Change;

public class CampInfoModifier extends Model{
	private final List<Change> changes;
	private int id;
	
	public CampInfoModifier() {
		changes = new ArrayList<>();
	}
	
	public CampInfoModifier(CampInfoModifier modifier) {
		changes = new ArrayList<>(modifier.getChanges());
		id = modifier.getID();
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
	
	public List<Change> getChanges() {
		return this.changes;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	@Override
	public int getID() {
		return this.id;
	}
}
