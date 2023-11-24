package model.change;

import main.Context;
import model.CampInfo;
import model.Change;

public class DescriptionChange implements Change {
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
}
