package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.CreateCampAction;
import boundary.action.actions.ReturnHomeAction;
import boundary.action.actions.ViewCampAction;
import boundary.action.actions.filter.CampFilterByAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampListingView extends ViewHandler{
	
	private List<Camp> camps;

	public CampListingView(Context context, UserSession session, List<Camp> camps) {
		super(context, session);
		this.camps = camps;
	}

	@Override
	protected String getPrompt() { return "Which camp do you wish to view?"; }

	@Override
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<Action>();
		camps.stream().forEach(camp -> actions.add(new ViewCampAction(context, session, camp)));
		actions.add(new CampFilterByAction(context, session, camps));
		actions.add(new CreateCampAction(context, session));
		actions.add(new ReturnHomeAction(context, session));
		return actions;
	}
	
	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}
}
