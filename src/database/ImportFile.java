package database;

import java.io.IOException;

import model.Faculty;
import model.Staff;
import model.Student;

/**
 * ImportFile class is used to import the data from the file.
 * It is used to import the data from the file and store it in the database.
 */

public class ImportFile {

    /**
     * This method is used to import the data from the file and store it in the database.
     * @throws IOException if I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public void importFile() throws IOException, ClassNotFoundException {
    	CampDatabase campDatabase = new CampDatabase();
    	campDatabase.clear();
    	SuggestionDatabase suggestionDatabase = new SuggestionDatabase();
    	suggestionDatabase.clear();
        StaffDatabase staffDatabase = new StaffDatabase();
        staffDatabase.clear();
        Staff staffs[] = new Staff[5];
        staffs[0] = new Staff(0, 
        		"HUKUMAR", 
        		Faculty.SCSE, 
        		"password");
        staffs[1] = new Staff(1, 
        		"OURIN", 
        		Faculty.ADM, 
        		"password");
        staffs[2] = new Staff(2, 
        		"UPAM", 
        		Faculty.EEE, 
        		"password");
        staffs[3] = new Staff(3, 
        		"ANWIT", 
        		Faculty.SCSE, 
        		"password");
        staffs[4] = new Staff(4, 
        		"ARVI", 
        		Faculty.NBS, 
        		"password");
        for (Staff staff: staffs) staffDatabase.add(staff);
        staffDatabase.save();

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.clear();

        Student students[] = new Student[11];
        students[0] = new Student(
				5,
				"YCHERN",
				Faculty.SCSE,
				"password",
				-1);
        students[1] = new Student(
        		6,
        		"KOH1",
        		Faculty.ADM,
        		"password",
        		-1);
        /*(6);
        culty(Faculty.ADM);
        erID("KOH1");
        ssword("password");
        (7);
        culty(Faculty.EEE);
        erID("BR015");
        ssword("password");
        (8);
        culty(Faculty.SCSE);
        erID("CT113");
        ssword("password");
        (9);
        culty(Faculty.NBS);
        erID("YCN019");
        ssword("password");
        (10);
        culty(Faculty.SCSE);
        erID("DL007");
        ssword("password");
        (11);
        culty(Faculty.ADM);
        erID("DON84");
        ssword("password");
        (12);
        culty(Faculty.EEE);
        erID("ELI34");
        ssword("password");
        (13);
        culty(Faculty.SCSE);
        erID("LE51");
        ssword("password");
        (14);
        culty(Faculty.NBS);
        erID("SL22");
        ssword("password");
        D(15);
        aculty(Faculty.SSS);
        serID("AKY013");
        assword("password");
        */
        for (int i = 0; i < 2; i++) {
            studentDatabase.add(students[i]);
        }
        studentDatabase.save();
    }
}
