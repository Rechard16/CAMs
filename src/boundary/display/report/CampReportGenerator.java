package boundary.display.report;

import java.util.List;

import boundary.IO;
import boundary.display.CampDisplayer;
import boundary.display.UserDisplayer;
import boundary.util.FileWriter;
import entity.filter.Filter;
import entity.model.Camp;
import entity.model.Permission;
import entity.model.Role;
import entity.model.User;
import main.Context;

/**
 * CampReportGenerator is a class that is used to generate a camp report.
 */
public class CampReportGenerator implements ReportGenerator {

	/*
	 * Generates a report.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param filter The filter to be used.
	 * 
	 * @throws Exception
	 */
	public void generateReport(Context context, Camp camp, Filter<User> filter) throws Exception {

		IO io = new FileWriter("camp_report.txt");

		CampDisplayer campDisplayer = new CampDisplayer(io, context, camp);
		campDisplayer.display();
		io.lineBreak();

		io.print("Committe Members:");
		for (int id : camp.getCommitteeMembers()) {
			User student = context.getUserManager().getUserByID(id);
			if (filter.isValid(context, student))
				new UserDisplayer(io, context, student).display();
		}
		io.lineBreak();

		io.print("Participants:");
		List<Integer> students = camp.getStudents();
		for (int id : students) {
			User student = context.getUserManager().getUserByID(id);
			if (student.getRole(camp) == Role.COMMITTEE_MEMBER)
				continue;
			if (filter.isValid(context, student))
				new UserDisplayer(io, context, student).display();
		}
		io.flush();

	}

	@Override

	/*
	 * Gets the permissions required to generate a report.
	 * 
	 * @return The list of permissions.
	 */

	public List<Permission> getPermissions() {
		return List.of(Permission.GENERATE_REPORT);
	}
	/*
	 * Gets the name of the report.
	 * 
	 * @return "General Camp Report".
	 */

	@Override
	public String getName() {
		return "General Camp Report";
	}
}
