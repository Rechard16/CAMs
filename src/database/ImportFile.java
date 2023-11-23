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
        StaffDatabase staffDatabase = new StaffDatabase();
        Staff staffs[] = new Staff[5];
        staffs[0].setID(0);
        staffs[0].setFaculty(Faculty.SCSE);
        staffs[0].setUserID("HUKUMAR");
        staffs[0].setPassword("password");
        staffs[1].setID(1);
        staffs[1].setFaculty(Faculty.ADM);
        staffs[1].setUserID("OURIN");
        staffs[1].setPassword("password");
        staffs[2].setID(2);
        staffs[2].setFaculty(Faculty.EEE);
        staffs[2].setUserID("UPAM");
        staffs[2].setPassword("password");
        staffs[3].setID(3);
        staffs[3].setFaculty(Faculty.SCSE);
        staffs[3].setUserID("ANWIT");
        staffs[3].setPassword("password");
        staffs[4].setID(4);
        staffs[4].setFaculty(Faculty.NBS);
        staffs[4].setUserID("ARVI");
        staffs[4].setPassword("password");
        for (int i = 0; i < 5; i++) {
            staffDatabase.add(staffs[i]);
        }
        staffDatabase.save();
        StudentDatabase studentDatabase = new StudentDatabase();

        Student students[] = new Student[11];
        students[0].setID(5);
        students[0].setFaculty(Faculty.SCSE);
        students[0].setUserID("YCHERN");
        students[0].setPassword("password");
        students[1].setID(6);
        students[1].setFaculty(Faculty.ADM);
        students[1].setUserID("KOH1");
        students[1].setPassword("password");
        students[2].setID(7);
        students[2].setFaculty(Faculty.EEE);
        students[2].setUserID("BR015");
        students[2].setPassword("password");
        students[3].setID(8);
        students[3].setFaculty(Faculty.SCSE);
        students[3].setUserID("CT113");
        students[3].setPassword("password");
        students[4].setID(9);
        students[4].setFaculty(Faculty.NBS);
        students[4].setUserID("YCN019");
        students[4].setPassword("password");
        students[5].setID(10);
        students[5].setFaculty(Faculty.SCSE);
        students[5].setUserID("DL007");
        students[5].setPassword("password");
        students[6].setID(11);
        students[6].setFaculty(Faculty.ADM);
        students[6].setUserID("DON84");
        students[6].setPassword("password");
        students[7].setID(12);
        students[7].setFaculty(Faculty.EEE);
        students[7].setUserID("ELI34");
        students[7].setPassword("password");
        students[8].setID(13);
        students[8].setFaculty(Faculty.SCSE);
        students[8].setUserID("LE51");
        students[8].setPassword("password");
        students[9].setID(14);
        students[9].setFaculty(Faculty.NBS);
        students[9].setUserID("SL22");
        students[9].setPassword("password");
        students[10].setID(15);
        students[10].setFaculty(Faculty.SSS);
        students[10].setUserID("AKY013");
        students[10].setPassword("password");
        for (int i = 0; i < 11; i++) {
            studentDatabase.add(students[i]);
        }
        studentDatabase.save();
    }
}
