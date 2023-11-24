package boundary.action.actions;

import java.util.List;

import boundary.action.Action;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CreateQueryAction extends Action {
	private final Camp camp;

	public CreateQueryAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		return "Create enquiry";
	}

	@Override
	public void performAction() throws Exception {
		context.print("Describe your question:");
		String query = context.getScanner().nextLine();
		
		context.getQueryManager().createQuery(session.getUser().getID(), 
				camp.getID(), query);

		context.print("Query was created!");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.ENQUIRY);
	}

}
