package boundary.display.report;

import java.util.List;

import entity.Nameable;
import entity.filter.Filter;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.User;
import main.Context;

/**
 * ReportGenerator is an interface that is used to generate reports.
 */
public interface ReportGenerator extends Nameable {
	/**
	 * Generates a report.
	 * 
	 * @param context The context to be used.
	 * @param camp    The camp to be used.
	 * @param filter  The filter to be used.
	 * @throws Exception
	 */
	public void generateReport(Context context, Camp camp, Filter<User> user) throws Exception;

	/*
	 * Gets the permissions required to generate this report.
	 */
	public List<Permission> getPermissions();
}
