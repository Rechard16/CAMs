package boundary.action.actions.modification;

import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.change.CommitteeSlotsChange;
import main.Context;

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
