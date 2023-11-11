package boundary.action;

import model.Permission;
import java.util.List;

public interface Action {
	
	public String getDescription();
	public void performAction() throws Exception;
	public ViewHandler getNextView();
	public List<Permission> getRequiredPermissions();
}
