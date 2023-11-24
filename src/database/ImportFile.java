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
    	QueryDatabase queryDatabase = new QueryDatabase();
    	queryDatabase.clear();
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
		students[2] = new Student(
				7,
				"BRO15",
				Faculty.EEE,
				"password",
				-1);
		students[3] = new Student(
				8,
				"CT113",
				Faculty.SCSE,
				"password",
				-1);
		students[4] = new Student(
				9,
				"YCN019",
				Faculty.NBS,
				"password",
				-1);
		students[5] = new Student(
				10,
				"DL007",
				Faculty.SCSE,
				"password",
				-1);
		students[6] = new Student(
				11,
				"DON84",
				Faculty.ADM,
				"password",
				-1);
		students[7] = new Student(
				12,
				"ELI34",
				Faculty.EEE,
				"password",
				-1);
		students[8] = new Student(
				13,
				"LE51",
				Faculty.SCSE,
				"password",
				-1);
		students[9] = new Student(
				14,
				"SL22",
				Faculty.NBS,
				"password",
				-1);
		students[10] = new Student(
				15,
				"AKY013",
				Faculty.SSS,
				"password",
				-1);

        for (int i = 0; i < 11; i++) {
            studentDatabase.add(students[i]);
        }
        studentDatabase.save();
    }
}
