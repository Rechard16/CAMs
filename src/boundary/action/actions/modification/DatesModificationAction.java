package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.DatesChange;
/*
 * DatesModificationAction is a class that is used to modify dates.
 */

public class DatesModificationAction extends ModificationAction {
    /*
     * Constructor for DatesModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public DatesModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     * 
     * @return "Change new dates of your camp".
     */
    public String getDescription() {
        return "Change new dates of your camp";
    }

    @Override
    /*
     * Perform the action.
     * 
     * @throws Exception
     */
    public void performAction() throws Exception {
        DatesChange change = DatesChange.create(context);
        modifier.add(change);
    }
}
