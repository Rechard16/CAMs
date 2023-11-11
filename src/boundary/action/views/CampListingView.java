package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ExitAction;
import boundary.action.actions.ViewCampAction;
import boundary.login.LoginSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampListingView extends ViewHandler{
	
	private List<Camp> camps;

	public CampListingView(Context context, LoginSession session, List<Camp> camps) {
		super(context, session);
		this.camps = camps;
	}

	@Override
	protected String getPrompt() { return "Which camp do you wish to view?"; }

	@Override
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<Action>();
		for (Camp camp : camps) actions.add(new ViewCampAction(context, session, camp));
		actions.add(new ExitAction(context, session));
		return actions;
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
