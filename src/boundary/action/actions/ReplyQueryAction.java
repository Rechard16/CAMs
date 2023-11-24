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

public class ReplyQueryAction extends Action {
	private Query query;

	public ReplyQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	public String getDescription() {
		return "Answer Query";
	}

	@Override
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
	public View getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.RESOLVE_ENQUIRY);
	}

}
