package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.CommitteeSlotsChange;

public class CommitteeSlotsModificationAction extends ModificationAction {

    public CommitteeSlotsModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Committee Slots";
    }

    @Override
    public void performAction() throws Exception {
        CommitteeSlotsChange change = CommitteeSlotsChange.create(context);
        modifier.add(change);
    }
}
