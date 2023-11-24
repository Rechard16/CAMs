package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Query;

public class DeleteQueryAction extends Action {
	private final Query query;

	public DeleteQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	public String getDescription() {
		return "Delete this Query";
	}

	@Override
	public void performAction() throws Exception {
		context.getQueryManager().deleteQuery(query);
		context.print("Your query was deleted!");
	}
	
	@Override
	public View getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.ENQUIRY);
	}
}
