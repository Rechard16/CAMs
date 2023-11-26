package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ConfirmationAction;
import boundary.action.actions.DeleteQueryAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.UpdateQueryAction;
import boundary.display.QueryDisplayer;
import control.login.UserSession;
import entity.model.Camp;
import entity.model.EnquiryStatus;
import entity.model.Permission;
import entity.model.Query;
import main.Context;

public class ModifyQueryView extends ViewHandler {
	private final Camp camp;
	private final Query query;
	/*
	 * Constructor for ModifyQueryView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param query The query to be used.
	 */

	public ModifyQueryView(Context context, UserSession session,
			Camp camp, Query query) {
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
		;
		super.displayView();
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<>();
		if (query.getStatus() == EnquiryStatus.UNANSWERED) {
			actions.add(new UpdateQueryAction(context, session, query));
			actions.add(new DeleteQueryAction(context, session, query));
			new ConfirmationAction(context, session,
					new DeleteQueryAction(context, session, query));
		}
		actions.add(new PreviousViewAction(context, session));
		return actions;
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