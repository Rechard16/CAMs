package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.LocationChange;

public class LocationModificationAction extends ModificationAction {

    public LocationModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
        super(context, session, modifier);
    }

    @Override
    public String getDescription() {
        return "Change Location";
    }

    @Override
    public void performAction() throws Exception {
        LocationChange change = LocationChange.create(context);
        modifier.add(change);
    }
}
