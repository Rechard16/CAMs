package boundary.action;

import model.Permission;
import java.util.List;

public interface Action {
	
	public String getDescription();
	public void performAction();
	public ViewHandler getNextView();
	public List<Permission> getRequiredPermissions();
}
