package model.change;

import main.Context;
import model.CampInfo;
import model.Model;

/**
 * The NameChange class is used to represent a change to the name of a
 * camp.
 * It is used in the CampInfoModifier class.
 */
public class NameChange extends Model implements Change {
	/**
	 * The new name of the camp.
	 */
	private String newName;

	/**
	 * Constructs a NameChange with the specified new name.
	 *
	 * @param newName The new name of the camp.
	 */
	private NameChange(String newName) {
		this.newName = newName;
	}

	/**
	 * Returns the new name of the camp.
	 *
	 * @return The new name of the camp.
	 */
	public static NameChange create(Context context) {
		context.print("What will be the new name of your camp?");
		String newName = context.getScanner().nextLine();
		return new NameChange(newName);
	}

	/**
	 * Modifies the camp information.
	 *
	 * @param campInfo The camp information to be modified.
	 */
	@Override
	public void modify(CampInfo campInfo) {
		campInfo.setName(newName);
	}

	/**
	 * Returns the description of the change.
	 *
	 * @return The description of the change.
	 */

	@Override
	public int getID() {
		return 0;
	}

	/**
	 * Returns the description of the change.
	 *
	 * @return The description of the change.
	 */

	@Override
	public String getDescription() {
		return String.format("Change name of camp to %s", newName);
	}

}
