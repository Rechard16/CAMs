package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Query;
import model.Student;
import model.User;
import model.UserType;
/*
 * ReplyQueryAction is a class that is used to reply to a query.
 */

public class ReplyQueryAction extends Action {
	private Query query;
	/*
	 * Constructor for ReplyQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param query The query to be used.
	 */

	public ReplyQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Answer Query".
	 */
	public String getDescription() {
		return "Answer Query";
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		context.print("Your answer to the query:");
		String reply = context.getScanner().nextLine();

		context.lineBreak();
		query.answer(reply);
		context.getQueryManager().save();
		context.print("Your answer was saved!");

		User user = session.getUser();
		if (user.getType() == UserType.STUDENT) {
			((Student) user).addPoint();
			context.getUserManager().save();
			context.print("You earned a point! Congratulations!");
		}
		context.lineBreak();
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
		return List.of(Permission.RESOLVE_ENQUIRY);
	}

}
