package boundary.action.actions;

import java.util.Collections;
import java.util.List;

import boundary.action.Action;
import boundary.action.ViewHandler;
import model.Permission;

public class ExitAction implements Action {
	
	@Override
	public String getDescription() { return "Exit"; }

	@Override
	public void performAction() { return; }

	@Override
	public ViewHandler getNextView() {
		return null;
	}

	@Override
	public List<Permission> getRequiredPermissions() { return Collections.emptyList(); }

}
