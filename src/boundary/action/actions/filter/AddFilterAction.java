package boundary.action.actions.filter;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import control.login.UserSession;
import entity.filter.Filter;
import entity.filter.FilterParameter;
import entity.model.Permission;
import main.Context;

public class AddFilterAction<T> extends Action {
	private final Filter<? extends T> filter;
	private final FilterParameter<T> parameter;
	/*
	 * Constructor for AddFilterAction.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param session The session to be used.
	 * 
	 * @param parameter The parameter to be used.
	 * 
	 * @param filter The filter to be used.
	 */

	public AddFilterAction(Context context, UserSession session,
			FilterParameter<T> parameter, Filter<? extends T> filter) {
		super(context, session);
		this.parameter = parameter;
		this.filter = filter;
	}

	@Override
	/*
	 * Get the description.
	 * 
	 * @return "Filter by <parameter name>".
	 */
	public String getDescription() {
		return String.format("Filter by %s", parameter.getName());
	}

	@Override
	/*
	 * Perform the action.
	 * 
	 * @throws Exception
	 */
	public void performAction() throws Exception {
		parameter.build(context);
		filter.addFilter(parameter);
		context.print("Successfully added filter");
	}

	@Override
	/*
	 * Get the required permissions.
	 * 
	 * @return An empty list.
	 */
	public List<Permission> getRequiredPermissions() {
		return Collections.emptyList();
	}
}
