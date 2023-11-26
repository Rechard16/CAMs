package boundary.action.actions.modification;

import control.login.UserSession;
import entity.model.CampInfoModifier;
import entity.model.change.TotalSlotsChange;
import main.Context;

public class TotalSlotsModificationAction extends ModificationAction {
    /*
     * Constructor for TotalSlotsModificationAction.
     *
     * @param context The context to be used.
     *
     * @param session The session to be used.
     *
     * @param modifier The modifier to be used.
     */

    public TotalSlotsModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    /*
     * Get the description.
     * 
     * @return "Change Total Slots".
     */
    public String getDescription() {
        return "Change Total Slots";
    }

    @Override
    /*
     * Perform the action.
     * 
     * @throws Exception
     */
    public void performAction() throws Exception {
        TotalSlotsChange change = TotalSlotsChange.create(context);
        modifier.add(change);
    }
}
