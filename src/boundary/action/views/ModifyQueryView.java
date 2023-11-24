package boundary.action.views;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import boundary.action.actions.PreviousViewAction;
import boundary.action.actions.UpdateQueryAction;
import boundary.login.UserSession;
import boundary.util.QueryDisplayer;
import main.Context;
import model.Camp;
import model.EnquiryStatus;
import model.Permission;
import model.Query;

public class ModifyQueryView extends ViewHandler {
	private final Camp camp;
	private final Query query;

	public ModifyQueryView(Context context, UserSession session, 
		Camp camp, Query query) {
		super(context, session);
		this.camp = camp;
		this.query = query;
	}

	@Override
	protected String getPrompt() {
		return "How will you handle this suggestion?:";
	}

	@Override
	public void displayView() throws Exception {
		new QueryDisplayer(context, query).display();;
		super.displayView();
	}

	@Override
	protected List<Action> generateActions() {
		List<Action> actions = new ArrayList<>();
		if (query.getStatus() == EnquiryStatus.UNANSWERED) {
			actions.add(new UpdateQueryAction(context, session, query));
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