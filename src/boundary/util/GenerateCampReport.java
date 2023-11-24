package boundary.util;

import boundary.filter.Filter;
import database.StudentDatabase;
import model.Camp;
import model.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class GenerateCampReport {
    public void generateCampReport(Camp camp, Filter filter) throws IOException, ClassNotFoundException {
        StudentDatabase studentDatabase = new StudentDatabase();
        List<Integer> students = camp.getStudents();
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("camp_report.txt"));
        writer.write("Camp ID: " + camp.getID());
        writer.newLine();
        writer.write("Camp Name: " + camp.getInformation().getName());
        writer.newLine();
        writer.write("Camp Dates: " + camp.getInformation().getDates());
        writer.newLine();
        writer.write("Camp Location: " + camp.getInformation().getLocation());
        writer.newLine();
        writer.write("Camp Total Slots: " + camp.getInformation().getTotalSlots());
        writer.newLine();
        writer.write("Camp Committee Slots: " + camp.getInformation().getCommitteeSlots());
        writer.newLine();
        for(Integer studentID : students) {
            Student student = studentDatabase.findByID(studentID);
            if (filter.isValid(student)) {
                writer.write(student.toString());
            }

            writer.write(",");
            if (camp.getCommitteeMembers().contains(studentID)) {
                writer.write("Camp Committee Member");
            } else {
                writer.write("Camp Attendee");
            }
            writer.newLine();
        }
        writer.close();

    }
}
