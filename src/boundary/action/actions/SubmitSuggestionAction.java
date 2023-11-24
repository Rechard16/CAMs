package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;

public class SubmitSuggestionAction extends Action {
	private final CampInfoModifier modifier;
	private final Camp camp;

	public SubmitSuggestionAction(Context context, UserSession session, 
			Camp camp, CampInfoModifier modifier) {
		super(context, session);
		this.modifier = modifier;
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Submit as Suggestion";
	}

	@Override
	public void performAction() throws Exception {
		context.print("Enter a description for your suggestion:");
		String description = context.getScanner().nextLine();
		context.getSuggestionManager()
			.createSuggestion(session.getUser().getID(), camp.getID() , description, modifier);
		context.print("Your suggestion has been created and submitted!");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.SUGGEST_CAMP, Permission.MODIFY_CAMP);
	}

}
