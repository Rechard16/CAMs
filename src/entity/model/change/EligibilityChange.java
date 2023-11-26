package entity.model.change;

import boundary.reader.BooleanReader;
import entity.model.CampInfo;
import entity.model.Faculty;
import entity.model.Model;
import entity.model.User;
import main.Context;

/**
 * The EligibilityChange class is used to represent a change to the eligibility
 * of a camp.
 * It is used in the CampInfoModifier class.
 */
public class EligibilityChange extends Model implements Change {
    /**
     * The new eligibility of the camp.
     */
    private Faculty newEligibility;

    /**
     * Constructs an EligibilityChange with the specified new eligibility.
     *
     * @param newEligibility The new eligibility of the camp.
     */
    private EligibilityChange(Faculty newEligibility) {
        this.newEligibility = newEligibility;
    }

    /**
     * Returns the new eligibility of the camp.
     *
     * @return The new eligibility of the camp.
     */

    public static EligibilityChange create(Context context, User user) {
        context.print("Will your camp be open to the school?");
        boolean open = new BooleanReader(context).readBool();

        return new EligibilityChange(open ? Faculty.SCHOOL : user.getFaculty());
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     */

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setEligibility(newEligibility);
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
        return String.format("Change eligibility to %s", newEligibility.name());
    }
}
