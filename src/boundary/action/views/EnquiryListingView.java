package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.ModifyQueryAction;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.ViewQueryAction;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;
import model.Query;

/*
 * EnquiryListingView is a class that is used to list enquiries.
 */
public class EnquiryListingView extends ViewHandler {
	private final Camp camp;
	private final List<Query> queries;
	/*
	 * Constructor for EnquiryListingView.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param queries The queries to be used.
	 */

	public EnquiryListingView(Context context, UserSession session,
			Camp camp, List<Query> queries) {
		super(context, session);
		this.camp = camp;
		this.queries = queries;
	}

	@Override
	/*
	 * Get the prompt.
	 * 
	 * @return "Which query do you wish to view?".
	 */
	protected String getPrompt() {
		return "Which query do you wish to view?";
	}

	@Override
	/*
	 * Generates the actions.
	 * 
	 * @return The actions.
	 */
	protected List<Action> generateActions() throws Exception {
		List<Action> actions = new ArrayList<>();
		for (Query q : queries) {
			actions.add(new ViewQueryAction(context, session, camp, q));
			actions.add(new ModifyQueryAction(context, session, camp, q));
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
