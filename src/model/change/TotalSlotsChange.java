package model.change;

import main.Context;
import model.CampInfo;
import model.Change;
import model.Model;

public class TotalSlotsChange extends Model implements Change {
    private int newTotalSlots;

    private TotalSlotsChange(int newTotalSlots) {
        this.newTotalSlots = newTotalSlots;
    }

    public static TotalSlotsChange create(Context context) {
        context.print("Enter the new total slots for your camp:");
        int newTotalSlots = new IntegerReader(context).readInt();
        return new TotalSlotsChange(newTotalSlots);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setTotalSlots(newTotalSlots);
    }

	@Override
	public int getID() { return 0; }
}
