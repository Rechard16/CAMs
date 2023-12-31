package boundary.action.actions.modification;

import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.change.EligibilityChange;
import main.Context;

public class EligibilityModificationAction extends ModificationAction {
    /*
     * Constructor for EligibilityModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public EligibilityModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     *
     * @return "Change Eligibility Criteria".
     */
    public String getDescription() {
        return "Change Eligibility Criteria";
    }

    @Override
    /*
     * Perform the action.
     *
     * @throws Exception
     */
    public void performAction() throws Exception {
        EligibilityChange change = EligibilityChange.create(context, session.getUser());
        modifier.add(change);
    }
}
