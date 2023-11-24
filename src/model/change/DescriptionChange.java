package model.change;

import main.Context;
import model.CampInfo;
import model.Change;
import model.Model;

public class DescriptionChange extends Model implements Change {
    private String newDescription;

    private DescriptionChange(String newDescription) {
        this.newDescription = newDescription;
    }

    public static DescriptionChange create(Context context) {
        context.print("Enter the new description for your camp:");
        String newDescription = context.getScanner().nextLine();
        return new DescriptionChange(newDescription);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDescription(newDescription);
    }

	@Override
	public int getID() { return 0; }
}
