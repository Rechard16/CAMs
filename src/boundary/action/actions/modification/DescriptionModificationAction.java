package boundary.action.actions.modification;

import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.change.DescriptionChange;
import main.Context;

public class DescriptionModificationAction extends ModificationAction {
    /*
     * Constructor for DescriptionModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public DescriptionModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     * 
     * @return "Change Description".
     */
    public String getDescription() {
        return "Change Description";
    }

    @Override
    /*
     * Perform the action.
     * 
     * @throws Exception
     */
    public void performAction() throws Exception {
        DescriptionChange change = DescriptionChange.create(context);
        modifier.add(change);
    }
}
