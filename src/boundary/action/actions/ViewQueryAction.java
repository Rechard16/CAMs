package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.QueryView;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Query;
import entity.model.User;
import main.Context;

/*
 * ViewQueryAction is a class that is used to view a query.
 */
public class ViewQueryAction extends Action {
	private final Query query;
	private final User user;
	private final Camp camp;
	/*
	 * Constructor for ViewQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param query The query to be used.
	 */

	public ViewQueryAction(Context context, UserSession session, Camp camp, Query query)
			throws ClassNotFoundException, IOException {
		super(context, session);
		this.query = query;
		this.camp = camp;
		this.user = context.getUserManager().getUserByID(query.getUserID());
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		return String.format("%s - %s", user.getName(), query.getTitle());
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
	}

	@Override
	/*
	 * Get the next view.
	 * 
	 * @return The next view.
	 */
	public ViewHandler getNextView() {
		return new QueryView(context, session, camp, query);
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return The required permissions.
	 */
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_ENQUIRIES, Permission.RESOLVE_ENQUIRY);
	}
}
