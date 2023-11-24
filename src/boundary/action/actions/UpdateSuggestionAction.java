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

public class UpdateSuggestionAction extends Action {
	private final CampInfoModifier modifier;
	private final Suggestion suggestion;
	private final Camp camp;

	public UpdateSuggestionAction(Context context, UserSession session, 
			Camp camp, CampInfoModifier modifier, Suggestion suggestion) {
		super(context, session);
		this.modifier = modifier;
		this.suggestion = suggestion;
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Update suggestion";
	}

	@Override
	public void performAction() throws Exception {
		context.print("Enter a description for your suggestion:");
		String description = context.getScanner().nextLine();
		suggestion.setModifier(modifier);
		suggestion.setDescription(description);
		
		context.getSuggestionManager().save();
		context.print("Your suggestion has successfully updated!");
	}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.SUGGEST_CAMP, Permission.MODIFY_CAMP);
	}
}
