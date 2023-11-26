package entity.model.change;

import boundary.reader.IntegerReader;
import entity.model.CampInfo;
import entity.model.Model;
import main.Context;

/**
 * The CommitteeSlotsChange class is used to represent a change to the number of
 * committee slots of a camp.
 * It is used in the CampInfoModifier class.
 */
public class CommitteeSlotsChange extends Model implements Change {

    /**
     * The new number of committee slots of the camp.
     */

    private int newCommitteeSlots;

    /**
     * Constructs a CommitteeSlotsChange with the specified new number of committee
     * slots.
     *
     * @param newCommitteeSlots The new number of committee slots of the camp.
     */

    private CommitteeSlotsChange(int newCommitteeSlots) {
        this.newCommitteeSlots = newCommitteeSlots;
    }

    /**
     * Returns the new number of committee slots of the camp.
     *
     * @return The new number of committee slots of the camp.
     */

    public static CommitteeSlotsChange create(Context context) {
        context.print("Enter the new number of committee slots for your camp:");
        int newCommitteeSlots = new IntegerReader(context).readInt();
        return new CommitteeSlotsChange(newCommitteeSlots);
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     */

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setCommitteeSlots(newCommitteeSlots);
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
        return String.format("Change number of committee slots to %d", newCommitteeSlots);
    }
}
