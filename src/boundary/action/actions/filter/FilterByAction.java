package boundary.action.actions.filter;

import java.util.List;

import boundary.action.Action;
import boundary.action.View;
import boundary.login.UserSession;
import main.Context;

public abstract class FilterByAction<T> extends Action {
	private final List<T> items;

	public FilterByAction(Context context, UserSession session, List<T> items) {
		super(context, session);
		this.items = items;
	}
	
	protected List<T> getItems() {
		return this.items;
	}

	@Override
	public String getDescription() { return "Filter by..."; }

	@Override
	public void performAction() throws Exception {}
	
	@Override
	public abstract View getNextView();
}