package boundary.action.actions.modification;

import boundary.login.UserSession;
import main.Context;
import model.CampInfoModifier;
import model.change.NameChange;
/*
 * NameModificationAction is a class that is used to modify names.
 */

public class NameModificationAction extends ModificationAction {
	/*
	 * Constructor for NameModificationAction.
	 *
	 * @param context The context to be used.
	 *
	 * @param session The session to be used.
	 *
	 * @param modifier The modifier to be used.
	 */

	public NameModificationAction(Context context, UserSession session, CampInfoModifier modifier) {
		super(context, session, modifier);
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Change Name".
	 */
	public String getDescription() {
		return "Change Name";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		NameChange change = NameChange.create(context);
		modifier.add(change);
	}
}
