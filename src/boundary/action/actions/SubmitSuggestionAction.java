package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;
/*
 * SubmitSuggestionAction is a class that is used to submit a suggestion.
 */

public class SubmitSuggestionAction extends Action {
	private final CampInfoModifier modifier;
	private final Camp camp;
	/*
	 * Constructor for SubmitSuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param modifier The modifier to be used.
	 */

	public SubmitSuggestionAction(Context context, UserSession session,
			Camp camp, CampInfoModifier modifier) {
		super(context, session);
		this.modifier = modifier;
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Submit as Suggestion".
	 */
	public String getDescription() {
		return "Submit as Suggestion";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Enter a description for your suggestion:");
		String description = context.getScanner().nextLine();
		context.getSuggestionManager()
				.createSuggestion(session.getUser().getID(), camp.getID(), description, modifier);
		context.print("Your suggestion has been created and submitted!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().pop();
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.SUGGEST_CAMP, Permission.MODIFY_CAMP);
	}
}
