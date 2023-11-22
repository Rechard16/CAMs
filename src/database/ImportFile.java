package database;

import model.Faculty;
import model.Staff;
import model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ImportFile class is used to import the data from the file.
 * It is used to import the data from the file and store it in the database.
 * @author Zeng Ruixiao
 * @version 1.0
 * @since 2023-11-22
 */

public class ImportFile {

    public void importFile() throws IOException, ClassNotFoundException {
        StaffDatabase staffDatabase = new StaffDatabase();
        Staff staffs[] = new Staff[5];
        staffs[0].setId(0);
        staffs[0].setFaculty(Faculty.SCSE);
        staffs[0].setUserId("HUKUMAR");
        staffs[0].setPassword("password");
        staffs[1].setId(1);
        staffs[1].setFaculty(Faculty.ADM);
        staffs[1].setUserId("OURIN");
        staffs[1].setPassword("password");
        staffs[2].setId(2);
        staffs[2].setFaculty(Faculty.EEE);
        staffs[2].setUserId("UPAM");
        staffs[2].setPassword("password");
        staffs[3].setId(3);
        staffs[3].setFaculty(Faculty.SCSE);
        staffs[3].setUserId("ANWIT");
        staffs[3].setPassword("password");
        staffs[4].setId(4);
        staffs[4].setFaculty(Faculty.NBS);
        staffs[4].setUserId("ARVI");
        staffs[4].setPassword("password");
        for (int i = 0; i < 5; i++) {
            staffDatabase.add(staffs[i]);
        }
        staffDatabase.save();
        StudentDatabase studentDatabase = new StudentDatabase();

        Student students[] = new Student[11];
        students[0].setId(5);
        students[0].setFaculty(Faculty.SCSE);
        students[0].setUserId("YCHERN");
        students[0].setPassword("password");
        students[1].setId(6);
        students[1].setFaculty(Faculty.ADM);
        students[1].setUserId("KOH1");
        students[1].setPassword("password");
        students[2].setId(7);
        students[2].setFaculty(Faculty.EEE);
        students[2].setUserId("BR015");
        students[2].setPassword("password");
        students[3].setId(8);
        students[3].setFaculty(Faculty.SCSE);
        students[3].setUserId("CT113");
        students[3].setPassword("password");
        students[4].setId(9);
        students[4].setFaculty(Faculty.NBS);
        students[4].setUserId("YCN019");
        students[4].setPassword("password");
        students[5].setId(10);
        students[5].setFaculty(Faculty.SCSE);
        students[5].setUserId("DL007");
        students[5].setPassword("password");
        students[6].setId(11);
        students[6].setFaculty(Faculty.ADM);
        students[6].setUserId("DON84");
        students[6].setPassword("password");
        students[7].setId(12);
        students[7].setFaculty(Faculty.EEE);
        students[7].setUserId("ELI34");
        students[7].setPassword("password");
        students[8].setId(13);
        students[8].setFaculty(Faculty.SCSE);
        students[8].setUserId("LE51");
        students[8].setPassword("password");
        students[9].setId(14);
        students[9].setFaculty(Faculty.NBS);
        students[9].setUserId("SL22");
        students[9].setPassword("password");
        students[10].setId(15);
        students[10].setFaculty(Faculty.SSS);
        students[10].setUserId("AKY013");
        students[10].setPassword("password");
        for (int i = 0; i < 11; i++) {
            studentDatabase.add(students[i]);
        }
        studentDatabase.save();
    }
}
