package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.Permission;
import main.Context;

public class CreateQueryAction extends Action {
	private final Camp camp;
	/*
	 * Constructor for CreateQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 */

	public CreateQueryAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Create enquiry".
	 */
	public String getDescription() {
		return "Create enquiry";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Describe your question:");
		String query = context.getScanner().nextLine();

		context.print("Give a title for your query:");
		String title = context.getScanner().nextLine();

		context.getQueryManager().createQuery(session.getUser().getID(),
				camp.getID(), title, query);

		context.print("Query was created!");
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
