package boundary.action.actions.filter;

import java.util.List;

import boundary.action.View;
import boundary.action.views.CampFilterView;
import boundary.login.UserSession;
import main.Context;
import model.Camp;
import model.Permission;

public class CampFilterByAction extends FilterByAction<Camp> {
	public CampFilterByAction(Context context, UserSession session, List<Camp> items) {
		super(context, session, items);
	}

	@Override
	public View getNextView() {
		return new CampFilterView(context, session, getItems());
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return List.of(Permission.VIEW_CAMPS);
	}
}
