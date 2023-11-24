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

public class ModifyQueryAction extends Action {
	private final Query query;
	private final Camp camp;

	public ModifyQueryAction(Context context, UserSession session, Camp camp, Query query) throws ClassNotFoundException, IOException {
		super(context, session);
		this.query = query;
		this.camp = camp;
	}

	@Override
	public String getDescription() {
		String name = query.getTitle();
		if (query.getStatus() != EnquiryStatus.UNANSWERED)
			name += String.format(" (%s)", query.getStatus().name());
		return name;
	}

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public ViewHandler getNextView() {
		return new ModifyQueryView(context, session, camp, query);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.ENQUIRY);
	}
}
