package database;

import model.Staff;

import java.io.IOException;
import java.util.List;

/**
 * This class is a database for staff.
 *
 *
 */
public class StaffDatabase extends Database<Staff>{
    /**
     * The list of staff.
     */
    private List<Staff> staffList;
    /**
     * The filename of the file that the database is saved to.
     */
    private final String filename = "data/staff.txt";

    public StaffDatabase() throws IOException, ClassNotFoundException {
        this.staffList= super.load();
    }


    /**
     * gets the filename of the file that the database is saved to.
     * @return The filename as a String.
     */
    public String getFilename() {
        return this.filename;
    }

    public List<Staff> getAll() throws IOException, ClassNotFoundException {
        return this.staffList;
    }

    public void setAll(List<Staff> objectList)  {
        this.staffList = objectList;
    }

    protected Class<Staff> getContainedClass() {
        return Staff.class;
    }
}
