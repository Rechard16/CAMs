package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ExitAction;
import boundary.login.LoginSession;
import main.Context;
import model.Permission;

public class EntryView extends ViewHandler {

	public EntryView(Context context, LoginSession session) {
		super(context, session);
	}

	@Override
	protected String getPrompt() { return "What do you want to do?"; }

	@Override
	protected List<Action> generateActions() {
		return List.of(new ExitAction());
	}

	@Override
	protected List<Permission> getPermissions() {
		return this.context.getPermissionManager()
				.getPermissions(this.session.getUser());
	}

}
