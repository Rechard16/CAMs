package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Query;
/*
 * DeleteQueryAction is a class that is used to delete queries.
 */

public class DeleteQueryAction extends Action {
	private final Query query;
	/*
	 * Constructor for DeleteQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param query The query to be used.
	 */

	public DeleteQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Delete this Query".
	 */
	public String getDescription() {
		return "Delete this Query";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.getQueryManager().deleteQuery(query);
		context.print("Your query was deleted!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public View getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.ENQUIRY);
	}
}
