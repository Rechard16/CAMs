package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.QueryView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Query;
import model.User;

public class ViewQueryAction extends Action {
	private final Query query;
	private final User user;
	private final Camp camp;

	public ViewQueryAction(Context context, UserSession session, Camp camp, Query query) throws ClassNotFoundException, IOException {
		super(context, session);
		this.query = query;
		this.camp = camp;
		this.user = context.getUserManager().getUserByID(query.getUserID());
	}

	@Override
	public String getDescription() {
		return String.format("%s - %s", user.getUserID(), query.getTitle());
	}

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public ViewHandler getNextView() {
		return new QueryView(context, session, camp, query);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_ENQUIRIES, Permission.RESOLVE_ENQUIRY);
	}
}
