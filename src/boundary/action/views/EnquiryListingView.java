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

public class EnquiryListingView extends ViewHandler{
	private final Camp camp;
	private final List<Query> queries;

	public EnquiryListingView(Context context, UserSession session, 
			Camp camp, List<Query> queries) {
		super(context, session);
		this.camp = camp;
		this.queries = queries;
	}

	@Override
	protected String getPrompt() {
		return "Which query do you wish to view?";
	}

	@Override
	protected List<Action> generateActions() throws Exception {
		List<Action> actions = new ArrayList<>();
		for (Query q: queries) {
			actions.add(new ViewQueryAction(context, session, camp, q));
			actions.add(new ModifyQueryAction(context, session, camp, q));
		}
		actions.add(new PreviousViewAction(context, session));
		return actions;
	}

	@Override
	protected List<Permission> getPermissions() {
		return context.getPermissionManager()
				.getCampModificationPermissions(this.session.getUser(), camp);
	}
}
