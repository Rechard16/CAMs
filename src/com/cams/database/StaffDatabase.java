package database;

<<<<<<< HEAD
public class StaffDatabase {

=======
import model.Staff;

import java.io.IOException;
import java.util.List;

public class StaffDatabase extends Database<Staff>{

    private List<Staff> staffList;
    public String getFilename() {
        return "/data/staff.txt";
    }

    public List<Staff> getAll() throws IOException, ClassNotFoundException {
        return staffList;
    }

    public void setAll(List<Staff> objectList) throws IOException {
        this.staffList = objectList;
    }

    protected Class<Staff> getContainedClass() {
        return Staff.class;
    }
>>>>>>> main
}
