package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.DescriptionChange;

public class DescriptionModificationAction extends ModificationAction {

    public DescriptionModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Description";
    }

    @Override
    public void performAction() throws Exception {
        DescriptionChange change = DescriptionChange.create(context);
        modifier.add(change);
    }
}
