package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.action.views.CampFilterView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampFilterByAction extends Action {
	private List<Camp> items;

	public CampFilterByAction(Context context, UserSession session, List<Camp> items) {
		super(context, session);
		this.items = items;
	}

	@Override
	public String getDescription() { return "Filter by..."; }

	@Override
	public void performAction() throws Exception {
		context.print("Creating filter!");
	}
	
	@Override
	public View getNextView() {
		return new CampFilterView(context, session, items);
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS);
	}
}
