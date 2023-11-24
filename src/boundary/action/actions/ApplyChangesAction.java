package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.CampInfoModifier;
import model.Permission;

public class ApplyChangesAction extends Action {
	private final CampInfoModifier modifier;
	private final Camp camp;

	public ApplyChangesAction(Context context, UserSession session, Camp camp, 
			CampInfoModifier modifier) {
		super(context, session);
		this.camp = camp;
		this.modifier = modifier;
	}

	@Override
	public String getDescription() {
		return "Approve current changes";
	}

	@Override
	public void performAction() throws Exception {
		Camp modified = modifier.modify(camp);
		try {
			context.getCampManager().updateCamp(camp, modified);
			context.getSuggestionManager().deleteSuggestion(modifier.getID());
		} catch (Exception e) {
			context.print("I/O error. Unable to save your changes!");
		}
		context.print("Your changes have been applied to your camp.");
	}
	
	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().reset();
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.MODIFY_CAMP, Permission.APPROVE_SUGGEST);
	}

}
