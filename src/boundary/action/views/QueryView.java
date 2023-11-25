package boundary.action.views;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.ReplyQueryAction;
import boundary.display.QueryDisplayer;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Query;
/*
 * QueryView is a class that is used to handle a query.
 */

public class QueryView extends ViewHandler {
	private final Camp camp;
	private final Query query;
	/*
	 * Constructor for QueryView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param query The query to be used.
	 */

	public QueryView(Context context, UserSession session, Camp camp, Query query) {
		super(context, session);
		this.camp = camp;
		this.query = query;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "How will you handle this suggestion?:".
	 */
	protected String getPrompt() {
		return "How will you handle this suggestion?:";
	}

	@Override
	/*
	 * Displays the view.
	 * 
	 * @throws Exception
	 */
	public void displayView() throws Exception {
		new QueryDisplayer(context, query).display();
		super.displayView();

	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() throws Exception {
		return List.of(
				new ReplyQueryAction(context, session, query),
				new PreviousViewAction(context, session));
	}

	@Override
	/*
	 * Get the permissions.
	 * 
	 * @return The permissions.
	 */
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}

}
