package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Query;

/*
 * UpdateQueryAction is a class that is used to update a query.
 */
public class UpdateQueryAction extends Action {

	private final Query query;
	/*
	 * Constructor for UpdateQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param query The query to be used.
	 */

	public UpdateQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Modify enquiry".
	 */
	public String getDescription() {
		return "Modify enquiry";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Describe your question:");
		String description = context.getScanner().nextLine();

		context.print("Give a title for your query:");
		String title = context.getScanner().nextLine();

		context.getQueryManager().updateQuery(query, title, description);

		context.print("Query was updated!");
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
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
