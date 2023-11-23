package model.change;

import main.Context;
import model.CampInfo;
import model.Change;

public class NameChange implements Change {
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

}
