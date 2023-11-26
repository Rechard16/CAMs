package entity.model;

import java.util.ArrayList;
import java.util.List;

import entity.model.change.Change;

/**
 * The CampInfoModifier class is used to modify the information of a camp.
 * It is used in the Suggestion class.
 */

public class CampInfoModifier extends Model {
	/**
	 * The list of changes to be made to the camp information.
	 */
	private final List<Change> changes;
	/**
	 * The unique identifier of the modifier.
	 */
	private int id;

	/**
	 * Constructs a CampInfoModifier with no changes.
	 */
	public CampInfoModifier() {
		changes = new ArrayList<>();
	}

	/**
	 * Constructs a CampInfoModifier with the specified changes.
	 * 
	 * @param changes The list of changes to be made to the camp information.
	 */
	public CampInfoModifier(CampInfoModifier modifier) {
		changes = new ArrayList<>(modifier.getChanges());
		id = modifier.getID();
	}

	/**
	 * Constructs a CampInfoModifier with the specified changes.
	 * 
	 * @param changes The list of changes to be made to the camp information.
	 */
	public CampInfoModifier(List<Change> changes) {
		this.changes = changes;
	}

	/**
	 * Adds a change to the list of changes.
	 * 
	 * @param c The change to be added.
	 */

	public void add(Change c) {
		for (int i = 0; i < changes.size(); i++)
			if (c.getClass().equals(changes.get(i).getClass())) {
				changes.set(i, c);
				return;
			}
		changes.add(c);
	}

	/**
	 * Removes a change from the list of changes.
	 * 
	 * @param c The change to be removed.
	 */

	public Camp modify(Camp camp) {
		Camp modified = new Camp(camp);
		for (Change change : changes)
			change.modify(modified.getInformation());
		return modified;
	}

	/**
	 * Retrieves the list of changes.
	 * 
	 * @return The list of changes.
	 */

	public List<Change> getChanges() {
		return this.changes;
	}

	/**
	 * Retrieves the unique identifier of the modifier.
	 * 
	 * @return The unique identifier of the modifier.
	 */

	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Retrieves the unique identifier of the modifier.
	 * 
	 * @return The unique identifier of the modifier.
	 */

	@Override
	public int getID() {
		return this.id;
	}
}
