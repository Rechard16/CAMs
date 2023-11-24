package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.ReplyQueryAction;
import boundary.login.UserSession;
import boundary.util.QueryDisplayer;
import main.Context;
import model.Camp;
import model.Permission;
import model.Query;

public class QueryView extends ViewHandler{
	private final Camp camp;
	private final Query query;

	public QueryView(Context context, UserSession session, Camp camp, Query query) {
		super(context, session);
		this.camp = camp;
		this.query = query;
	}

	@Override
	protected String getPrompt() {
		return "How will you handle this suggestion?:";
	}
	
	@Override
	public void displayView() throws Exception {
		new QueryDisplayer(context, query).display();
		super.displayView();

	}

	@Override
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new ReplyQueryAction(context, session, query),
				new PreviousViewAction(context, session)
				);
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}

}
