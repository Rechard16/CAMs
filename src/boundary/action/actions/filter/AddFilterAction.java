package boundary.action.actions.filter;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.filter.Filter;
import boundary.filter.FilterParameter;
import boundary.login.UserSession;
import main.Context;
import model.Permission;

public class AddFilterAction<T> extends Action {
	private final Filter<? extends T> filter;
	private final FilterParameter<T> parameter;

	public AddFilterAction(Context context, UserSession session, 
			FilterParameter<T> parameter, Filter<? extends T> filter) {
		super(context, session);
		this.parameter = parameter;
		this.filter = filter;
	}

	@Override
	public String getDescription() {
		return String.format("Filter by %s", parameter.getName());
	}

	@Override
	public void performAction() throws Exception {
		parameter.build(context);
		filter.addFilter(parameter);
		context.print("Successfully added filter");
	}

	@Override
	public List<Permission> getRequiredPermissions() {
		return Collections.emptyList();
	}
}
