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

public class ApplyChangesAction extends Action {
	private final CampInfoModifier modifier;
	private final Suggestion suggestion;
	private final Camp camp;
	private final boolean isNew;

	public ApplyChangesAction(Context context, UserSession session, Camp camp, 
			CampInfoModifier modifier, boolean isNew) {
		super(context, session);
		this.camp = camp;
		this.modifier = modifier;
		this.isNew = isNew;
		this.suggestion = null;
	}
	
	public ApplyChangesAction(Context context, UserSession session, Camp camp, 
			Suggestion suggestion) {
		super(context, session);
		this.camp = camp;
		this.modifier = suggestion.getModifier();
		this.isNew = false;
		this.suggestion = suggestion;
	}

	@Override
	public String getDescription() {
		if (isNew) return "Update camp with changes";
		return "Approve current changes";
	}

	@Override
	public void performAction() throws Exception {
		Camp modified = modifier.modify(camp);
		try {
			context.getCampManager().updateCamp(camp, modified);
			if (suggestion != null) {
				Suggestion suggestion = context.getSuggestionManager()
						.getSuggestion(modifier.getID());
				suggestion.approve();
				context.getSuggestionManager().save();
			}

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
