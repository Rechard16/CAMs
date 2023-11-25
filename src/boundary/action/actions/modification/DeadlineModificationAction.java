package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.DeadlineChange;
/*
 * DeadlineModificationAction is a class that is used to modify the deadline.
 */

public class DeadlineModificationAction extends ModificationAction {
    /*
     * Constructor for DeadlineModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public DeadlineModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     * 
     * @return "Change Registration Deadline".
     */
    public String getDescription() {
        return "Change Registration Deadline";
    }

    @Override
    /*
     * Perform the action.
     * 
     * @throws Exception
     */
    public void performAction() throws Exception {
        DeadlineChange change = DeadlineChange.create(context);
        modifier.add(change);
    }
}
