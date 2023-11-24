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

public class CommitteeReportGenerator implements ReportGenerator{
    public void generateReport(Context context, Camp camp, Filter<User> filter) throws Exception {

    	IO io = new FileWriter("committee_report.txt");

    	CampDisplayer campDisplayer = new CampDisplayer(io, context, camp);
    	campDisplayer.display();

    	io.lineBreak();
    	io.print("Committe Members:");
    	io.lineBreak();

    	for (int id: camp.getCommitteeMembers()) {
            Student student = (Student) context.getUserManager().getUserByID(id);
            if (filter.isValid(context, student)) {
            	io.print(student.getName());
            	io.print("Points earned:", student.getPoints());
            	
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
	public List<Permission> getPermissions() {
		return List.of(Permission.GENERATE_REPORT, Permission.VIEW_PERFORMANCE);
	}

	@Override
	public String getName() {
		return "Committee Performance Report";
	}
}
