package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.CommitteeSlotsChange;
/*
 * CommitteeSlotsModificationAction is a class that is used to modify committee slots.
 */

public class CommitteeSlotsModificationAction extends ModificationAction {
    /*
     * Constructor for CommitteeSlotsModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public CommitteeSlotsModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     *
     * @return "Change Committee Slots".
     */
    public String getDescription() {
        return "Change Committee Slots";
    }

    @Override
    /*
     * Perform the action.
     *
     * @throws Exception
     */
    public void performAction() throws Exception {
        CommitteeSlotsChange change = CommitteeSlotsChange.create(context);
        modifier.add(change);
    }
}
