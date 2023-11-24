package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.TotalSlotsChange;

public class TotalSlotsModificationAction extends ModificationAction {

    public TotalSlotsModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Total Slots";
    }

    @Override
    public void performAction() throws Exception {
        TotalSlotsChange change = TotalSlotsChange.create(context);
        modifier.add(change);
    }
}
