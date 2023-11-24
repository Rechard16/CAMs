package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.DeadlineChange;

public class DeadlineModificationAction extends ModificationAction {

    public DeadlineModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Registration Deadline";
    }

    @Override
    public void performAction() throws Exception {
        DeadlineChange change = DeadlineChange.create(context);
        modifier.add(change);
    }
}
