package model.change;

import main.Context;
import model.CampInfo;
import model.Change;
import model.Model;

public class NameChange extends Model implements Change {
	private String newName;
	
	private NameChange(String newName) {
		this.newName = newName;
	}
	
	public static NameChange create(Context context) {
		context.print("What will be the new name of your camp?");
		String newName = context.getScanner().nextLine();
		return new NameChange(newName);
	}

	@Override
	public void modify(CampInfo campInfo) {
		campInfo.setName(newName);
	}

	@Override
	public int getID() { return 0; }

	@Override
	public String getDescription() {
		return String.format("Change name of camp to %s", newName);
	}

}
