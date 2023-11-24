package boundary.util;

import java.util.List;

import boundary.filter.Filter;
import main.Context;
import model.Camp;
import model.Permission;
import model.User;
import model.interfaces.Nameable;

public interface ReportGenerator extends Nameable {
	public void generateReport(Context context, Camp camp, Filter<User> user) throws Exception;
	public List<Permission> getPermissions();
}
