package boundary.action.actions.modification;

import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.change.DeadlineChange;
import main.Context;

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
