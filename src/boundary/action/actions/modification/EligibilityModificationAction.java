package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.EligibilityChange;

public class EligibilityModificationAction extends ModificationAction {

    public EligibilityModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Eligibility Criteria";
    }

    @Override
    public void performAction() throws Exception {
        EligibilityChange change = EligibilityChange.create(context, session.getUser());
        modifier.add(change);
    }
}
