package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;
import model.Suggestion;
/*
 * UpdateSuggestionAction is a class that is used to update a suggestion.
 */

public class UpdateSuggestionAction extends Action {
	private final CampInfoModifier modifier;
	private final Suggestion suggestion;
	private final Camp camp;
	/*
	 * Constructor for UpdateSuggestionAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param modifier The modifier to be used.
	 * 
	 * @param suggestion The suggestion to be used.
	 */

	public UpdateSuggestionAction(Context context, UserSession session,
			Camp camp, CampInfoModifier modifier, Suggestion suggestion) {
		super(context, session);
		this.modifier = modifier;
		this.suggestion = suggestion;
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Update suggestion".
	 */
	public String getDescription() {
		return "Update suggestion";
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
		suggestion.setModifier(modifier);
		suggestion.setDescription(description);

		context.getSuggestionManager().save();
		context.print("Your suggestion has successfully updated!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return session.getViewStack().pop(2);
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
