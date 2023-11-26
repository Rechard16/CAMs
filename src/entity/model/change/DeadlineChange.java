package entity.model.change;

import java.util.Date;

import boundary.reader.DateReader;
import entity.exception.IllegalModificationException;
import entity.model.CampInfo;
import entity.model.Model;
import main.Context;

/**
 * The DeadlineChange class is used to represent a change to the registration
 * deadline of a camp.
 * It is used in the CampInfoModifier class.
 */
public class DeadlineChange extends Model implements Change {

    /**
     * The new registration deadline of the camp.
     */
    private Date newDeadline;

    /**
     * Constructs a DeadlineChange with the specified new registration deadline.
     *
     * @param newDeadline The new registration deadline of the camp.
     */
    private DeadlineChange(Date newDeadline) {
        this.newDeadline = newDeadline;
    }

    /**
     * Returns the new registration deadline of the camp.
     *
     * @return The new registration deadline of the camp.
     */

    public static DeadlineChange create(Context context) {
        context.print("Enter the new registration deadline for your camp:");
        Date newDeadline = new DateReader(context).readDate(null, null);
        return new DeadlineChange(newDeadline);
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     * @throws IllegalModificationException 
     */

    @Override
    public void modify(CampInfo campInfo) throws IllegalModificationException {
    	if (campInfo.getDates().get(0).before(newDeadline))
    		throw new IllegalModificationException("Cannot set a deadline after the camp has already started!");
        campInfo.setDeadline(newDeadline);
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
        return String.format("Change deadline to: %s", newDeadline.toString());
    }

}
