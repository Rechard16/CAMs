package boundary.action.actions;

import java.io.IOException;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.views.ModifyQueryView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.EnquiryStatus;
import model.Permission;
import model.Query;
/*
 * ModifyQueryAction is a class that is used to modify a query.
 */

public class ModifyQueryAction extends Action {
	private final Query query;
	private final Camp camp;
	/*
	 * Constructor for ModifyQueryAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param query The query to be used.
	 */

	public ModifyQueryAction(Context context, UserSession session, Camp camp, Query query)
			throws ClassNotFoundException, IOException {
		super(context, session);
		this.query = query;
		this.camp = camp;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		String name = query.getTitle();
		if (query.getStatus() != EnquiryStatus.UNANSWERED)
			name += String.format(" (%s)", query.getStatus().name());
		return name;
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
		return new ModifyQueryView(context, session, camp, query);
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
