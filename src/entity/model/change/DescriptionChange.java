package entity.model.change;

import boundary.reader.LineReader;
import entity.model.CampInfo;
import entity.model.Model;
import main.Context;

/**
 * The DescriptionChange class is used to represent a change to the description
 * of a camp.
 * It is used in the CampInfoModifier class.
 */
public class DescriptionChange extends Model implements Change {

    /**
     * The new description of the camp.
     */
    private String newDescription;

    /**
     * Constructs a DescriptionChange with the specified new description.
     *
     * @param newDescription The new description of the camp.
     */
    private DescriptionChange(String newDescription) {
        this.newDescription = newDescription;
    }

    /**
     * Returns the new description of the camp.
     *
     * @return The new description of the camp.
     */
    public static DescriptionChange create(Context context) {
        context.print("Enter the new description for your camp:");
        String newDescription = new LineReader(context).readLine();
        return new DescriptionChange(newDescription);
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     */
    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDescription(newDescription);
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
        return String.format("Change description to: %s", newDescription);
    }

}
