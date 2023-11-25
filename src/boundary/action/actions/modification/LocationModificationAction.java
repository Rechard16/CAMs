package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.LocationChange;

/**
 * LocationModificationAction is a class that is used to modify locations.
 */
public class LocationModificationAction extends ModificationAction {
    /**
     * Constructor for LocationModificationAction.
     *
     * @param context  The context to be used.
     * @param session  The session to be used.
     * @param modifier The modifier to be used.
     */

    public LocationModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /**
     * Get the description.
     *
     * @return "Change Location".
     */
    public String getDescription() {
        return "Change Location";
    }

    @Override
    /**
     * Perform the action.
     *
     * @throws Exception
     */
    public void performAction() throws Exception {
        LocationChange change = LocationChange.create(context);
        modifier.add(change);
    }
}
