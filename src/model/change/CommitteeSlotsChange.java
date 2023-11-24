package model.change;

import boundary.reader.IntegerReader;
import main.Context;
import model.CampInfo;
import model.Model;

public class CommitteeSlotsChange extends Model implements Change {
    private int newCommitteeSlots;

    private CommitteeSlotsChange(int newCommitteeSlots) {
        this.newCommitteeSlots = newCommitteeSlots;
    }

    public static CommitteeSlotsChange create(Context context) {
        context.print("Enter the new number of committee slots for your camp:");
        int newCommitteeSlots = new IntegerReader(context).readInt();
        return new CommitteeSlotsChange(newCommitteeSlots);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setCommitteeSlots(newCommitteeSlots);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getDescription() {
        return String.format("Change number of committee slots to %d", newCommitteeSlots);
    }
}
