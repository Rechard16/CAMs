package control.database;

import java.io.IOException;
import java.util.List;

import entity.model.Staff;

/**
 * This class is a database for staff.
 * It extends the abstract class Database.
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
    /**
     * The constructor of the class.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */

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

    /**
     * gets the list of staff.
     * @return a list of staff
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public List<Staff> getAll() throws IOException, ClassNotFoundException {
        return this.staffList;
    }

    /**
     * Sets the list of staff.
     * @param objectList The list of objects to be set.
     */
    public void setAll(List<Staff> objectList)  {
        this.staffList = objectList;
    }

    /**
     * Gets the class of the contained object.
     * @return The class of the contained object.
     */
    protected Class<Staff> getContainedClass() {
        return Staff.class;
    }


	@Override
	public void clear() throws ClassNotFoundException, IOException {
		this.staffList.clear();
		save();
	}
}
