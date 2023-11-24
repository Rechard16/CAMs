package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.login.UserSession;
import main.Context;
import model.Permission;
import model.Query;

public class UpdateQueryAction extends Action {
	
	private final Query query;

	public UpdateQueryAction(Context context, UserSession session, Query query) {
		super(context, session);
		this.query = query;
	}

	@Override
	public String getDescription() {
		return "Modify enquiry";
	}

	@Override
	public void performAction() throws Exception {
		context.print("Describe your question:");
		String description = context.getScanner().nextLine();

		context.print("Give a title for your query:");
		String title = context.getScanner().nextLine();
		
		context.getQueryManager().updateQuery(query, title, description);

		context.print("Query was updated!");
	}

	@Override
	public ViewHandler getNextView() {
		return session.getViewStack().pop(2);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.ENQUIRY);
	}

}
