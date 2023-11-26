package control.database;

import java.io.IOException;
import java.util.List;

import entity.model.Student;

/**
 * This class is a database for students.
 * It extends the abstract class Database.
 */
public class StudentDatabase extends Database<Student>{

    /**
     * The list of students.
     */
    private List<Student> studentList;

    /**
     * The filename of the file that the database is saved to.
     */
    private final String filename = "data/students.txt";
    /**
     * The constructor of the class.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public StudentDatabase() throws IOException, ClassNotFoundException {
        this.studentList= super.load();
    }

    /**
     * Gets the filename of the file that the database is saved to.
     * @return The filename as a String.
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Gets the list of students.
     * @return The list of students.
     */
    public List<Student> getAll() {
        return this.studentList;
    }

    /**
     * Sets the list of students.
     * @param objectList The list of objects to be set.
     */
    public void setAll(List<Student> objectList) {
        this.studentList = objectList;
    }

    /**
     * Gets the class of the contained object.
     * @return The class of the contained object.
     */
    protected Class<Student> getContainedClass() {
        return Student.class;
    }

	@Override
	public void clear() throws ClassNotFoundException, IOException {
		this.studentList.clear();
		save();
	}
}
