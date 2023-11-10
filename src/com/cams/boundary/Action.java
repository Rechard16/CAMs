package boundary;

import java.util.List;

import model.Permission;

public interface Action {
	
	@Override
	public String toString();
	public void performAction();
	public List<Permission> getRequiredPermissions();
}
