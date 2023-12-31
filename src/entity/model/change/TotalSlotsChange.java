package entity.model.change;

import boundary.reader.IntegerReader;
import entity.exception.IllegalModificationException;
import entity.model.CampInfo;
import entity.model.Model;
import main.Context;

/**
 * The TotalSlotsChange class is used to represent a change to the number of
 * total slots of a camp.
 * It is used in the CampInfoModifier class.
 */
public class TotalSlotsChange extends Model implements Change {
    /**
     * The new number of total slots of the camp.
     */
    private int newTotalSlots;

    /**
     * Constructs a TotalSlotsChange with the specified new number of total slots.
     *
     * @param newTotalSlots The new number of total slots of the camp.
     */

    private TotalSlotsChange(int newTotalSlots) {
        this.newTotalSlots = newTotalSlots;
    }

    /**
     * Returns the new number of total slots of the camp.
     *
     * @return The new number of total slots of the camp.
     */

    public static TotalSlotsChange create(Context context) {
        context.print("Enter the new total slots for your camp:");
        int newTotalSlots = new IntegerReader(context).readInt(1);
        return new TotalSlotsChange(newTotalSlots);
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     * @throws IllegalModificationException 
     */

    @Override
    public void modify(CampInfo campInfo) throws IllegalModificationException {
    	if (campInfo.getTotalSlots() > newTotalSlots)
    		throw new IllegalModificationException("Cannot decrease number of slots! (Only increase)");
        campInfo.setTotalSlots(newTotalSlots);
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
        return String.format("Change total slots to %d", newTotalSlots);
    }

}
