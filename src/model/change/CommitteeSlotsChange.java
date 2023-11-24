package model.change;

import main.Context;
import model.CampInfo;
import model.Change;

public class CommitteeSlotsChange implements Change {
    private int newCommitteeSlots;

    private CommitteeSlotsChange(int newCommitteeSlots) {
        this.newCommitteeSlots = newCommitteeSlots;
    }

    public static CommitteeSlotsChange create(Context context) {
        context.print("Enter the new number of committee slots for your camp:");
        int newCommitteeSlots = context.getScanner().nextInt();
        return new CommitteeSlotsChange(newCommitteeSlots);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setCommitteeSlots(newCommitteeSlots);
    }
}
