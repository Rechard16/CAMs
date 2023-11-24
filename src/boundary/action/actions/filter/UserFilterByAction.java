package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.UserFilterView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class UserFilterByAction extends Action {
	private final Camp camp;

	public UserFilterByAction(Context context, UserSession session, Camp camp) {
		super(context, session);
		this.camp = camp;
	}
	
	@Override
	public String getDescription() { return "Create Report"; }
	
	@Override
	public void performAction() throws Exception {}

	@Override
	public View getNextView() {
		return new UserFilterView(context, session, camp);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMP, Permission.GENERATE_REPORT);
	}

}
