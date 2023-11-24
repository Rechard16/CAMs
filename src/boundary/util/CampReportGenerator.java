package boundary.util;

import java.util.List;

import boundary.IO;
import boundary.display.CampDisplayer;
import boundary.display.UserDisplayer;
import boundary.filter.Filter;
import main.Context;
import model.Camp;
import model.Student;

public class CampReportGenerator {
    public void generateCampReport(Context context, Camp camp, Filter<Student> filter) throws Exception {

    	IO io = new FileWriter("camp_report.txt");

    	CampDisplayer campDisplayer = new CampDisplayer(io, context, camp);
    	campDisplayer.display();
    	io.lineBreak();

		List<Integer> students = camp.getStudents();
        for(int studentID : students) {
            Student student = (Student) context.getUserManager().getUserByID(studentID);
            if (filter.isValid(context, student)) {
            	UserDisplayer displayer = new UserDisplayer(io, context, student);
            	displayer.setCamp(camp);
            	displayer.display();
            }
        }
        io.flush();

    }
}
