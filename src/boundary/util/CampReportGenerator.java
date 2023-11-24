package boundary.util;

import java.util.List;

import boundary.IO;
import boundary.display.CampDisplayer;
import boundary.display.UserDisplayer;
import boundary.filter.Filter;
import main.Context;
import model.Camp;
import model.Permission;
import model.Role;
import model.User;

public class CampReportGenerator implements ReportGenerator {
    public void generateReport(Context context, Camp camp, Filter<User> filter) throws Exception {

    	IO io = new FileWriter("camp_report.txt");

    	CampDisplayer campDisplayer = new CampDisplayer(io, context, camp);
    	campDisplayer.display();
    	io.lineBreak();
    	
    	io.print("Committe Members:");
    	for (int id: camp.getCommitteeMembers()) {
            User student = context.getUserManager().getUserByID(id);
            if (filter.isValid(context, student))
            	new UserDisplayer(io, context, student).display();
    	}
    	io.lineBreak();
    	
    	io.print("Participants:");
		List<Integer> students = camp.getStudents();
        for(int id: students) {
            User student = context.getUserManager().getUserByID(id);
            if (student.getRole(camp) == Role.COMMITTEE_MEMBER) continue;
            if (filter.isValid(context, student))
            	new UserDisplayer(io, context, student).display();
        }
        io.flush();

    }

	@Override
	public List<Permission> getPermissions() {
		return List.of(Permission.GENERATE_REPORT);
	}

	@Override
	public String getName() {
		return "General Camp Report";
	}
}
