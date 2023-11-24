package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.NameChange;

public class NameModificationAction extends ModificationAction {
	
	public NameModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
		super(context, session, modifier);
	}

	@Override
	public String getDescription() { return "Change Name"; }

	@Override
	public void performAction() throws Exception {
		NameChange change = NameChange.create(context);
		modifier.add(change);
	}
}
