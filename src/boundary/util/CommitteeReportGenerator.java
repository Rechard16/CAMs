package boundary.util;

import java.util.List;

import boundary.IO;
import boundary.display.CampDisplayer;
import boundary.filter.Filter;
import main.Context;
import model.Camp;
import model.Permission;
import model.Student;
import model.Suggestion;
import model.User;

/**
 * This class is used to generate a committee report.
 */
public class CommitteeReportGenerator implements ReportGenerator {
	/**
	 * Generates a report.
	 * 
	 * @param context The context to be used.
	 * @param camp    The camp to be used.
	 * @param filter  The filter to be used.
	 * @throws Exception
	 */
	public void generateReport(Context context, Camp camp, Filter<User> filter) throws Exception {

		IO io = new FileWriter("committee_report.txt");

		CampDisplayer campDisplayer = new CampDisplayer(io, context, camp);
		campDisplayer.display();

		io.lineBreak();
		io.print("Committe Members:");
		io.lineBreak();

		for (int id : camp.getCommitteeMembers()) {
			Student student = (Student) context.getUserManager().getUserByID(id);
			if (filter.isValid(context, student)) {
				io.print(student.getName());
				io.print("Points earned: %d\n", student.getPoints());

				io.print("Suggestions submitted:");
				List<Suggestion> suggestions = context.getSuggestionManager()
						.getSuggestionsByCamp(camp.getID(), id);
				for (Suggestion suggestion : suggestions)
					io.print("%s - (%s)\n", suggestion.getDescription(), suggestion.getStatus().name());
				io.lineBreak();
			}
		}

		io.flush();

	}

	@Override
	/**
	 * Gets the permissions required to generate this report.
	 * 
	 * @return The permissions required to generate this report.
	 */
	public List<Permission> getPermissions() {
		return List.of(Permission.GENERATE_REPORT, Permission.VIEW_PERFORMANCE);
	}
	/*
	 * Gets the name of the report.
	 * 
	 * @return "Committee Performance Report".
	 */

	@Override
	public String getName() {
		return "Committee Performance Report";
	}
}
