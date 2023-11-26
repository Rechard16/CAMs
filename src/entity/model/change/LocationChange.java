package entity.model.change;

import boundary.reader.LineReader;
import entity.model.CampInfo;
import entity.model.Model;
import main.Context;

/**
 * The LocationChange class is used to represent a change to the location of a
 * camp.
 * It is used in the CampInfoModifier class.
 */
public class LocationChange extends Model implements Change {
    /**
     * The new location of the camp.
     */
    private String newLocation;

    /**
     * Constructs a LocationChange with the specified new location.
     *
     * @param newLocation The new location of the camp.
     */
    private LocationChange(String newLocation) {
        this.newLocation = newLocation;
    }

    /**
     * Returns the new location of the camp.
     *
     * @return The new location of the camp.
     */

    public static LocationChange create(Context context) {
        context.print("Enter the new location for your camp:");
        String newLocation = new LineReader(context).readLine();
        return new LocationChange(newLocation);
    }

    /**
     * Modifies the camp information.
     *
     * @param campInfo The camp information to be modified.
     */

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setLocation(newLocation);
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
        return String.format("Change location to %s", newLocation);
    }
}
