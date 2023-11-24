package model.change;

import main.Context;
import model.CampInfo;
import model.Change;

public class TotalSlotsChange implements Change {
    private int newTotalSlots;

    private TotalSlotsChange(int newTotalSlots) {
        this.newTotalSlots = newTotalSlots;
    }

    public static TotalSlotsChange create(Context context) {
        context.print("Enter the new total slots for your camp:");
        int newTotalSlots = context.getScanner().nextInt();
        return new TotalSlotsChange(newTotalSlots);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setTotalSlots(newTotalSlots);
    }
}