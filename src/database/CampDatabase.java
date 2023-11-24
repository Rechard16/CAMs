package database;

import java.io.IOException;
import java.util.List;

import model.Camp;

/**
 *This class is a database for camps.
 * It extends the abstract class Database.
 */
public class CampDatabase extends Database<Camp> {
    /**
     * The filename of the file that the database is saved to.
     */
    private final String filename = "data/camps.txt";
    /**
     * The list of camps.
     */
    private List<Camp> camps;

    /**
     * The constructor of the class.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public CampDatabase() throws IOException, ClassNotFoundException {
        this.camps=super.load();
    }

    /**
     * Gets the filename of the file that the database is saved to.
     * @return The filename as a String.
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * gets the list of camps.
     * @return a list of camps
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public List<Camp> getAll() throws IOException, ClassNotFoundException {
        return this.camps;
    }

    /**
     * Sets the list of camps.
     * @param objectList The list of objects to be set.
     */
    public void setAll(List<Camp> objectList)  {
        this.camps = objectList;
    }

    /**
     * Gets the class of the contained object.
     * @return The class of the contained object.
     */
    protected Class<Camp> getContainedClass() {
        return Camp.class;
    }

	@Override
	public void clear() throws ClassNotFoundException, IOException {
		this.camps.clear();
		save();
	}

}
