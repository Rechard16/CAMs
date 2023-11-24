package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.DatesChange;

public class DatesModificationAction extends ModificationAction {

    public DatesModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "What is the new start date of your camp?";
    }

    @Override
    public void performAction() throws Exception {
        DatesChange change = DatesChange.create(context);
        modifier.add(change);
    }
}
