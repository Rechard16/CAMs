package control.manager;

import java.io.FileNotFoundException;
import java.io.IOException;

import control.database.Database;
import control.database.StaffDatabase;
import control.database.StudentDatabase;
import entity.model.Staff;
import entity.model.Student;
import entity.model.User;

/**
 * UserManager is a manager class that manages the users.
 * It is used to create, update, delete, and get users.
 * It is also used to get users by ID.
 */
public class UserManager implements Savable {

	private Database<Student> studentDatabase;
	private Database<Staff> staffDatabase;

	/**
	 * Constructor for the UserManager class.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public UserManager() throws ClassNotFoundException, IOException {
		studentDatabase = new StudentDatabase();
		staffDatabase = new StaffDatabase();
	}

	/**
	 * Constructor for the UserManager class.
	 * 
	 * @param studentDatabase The StudentDatabase object.
	 * @param staffdatabase   The StaffDatabase object.
	 */

	public UserManager(StudentDatabase studentDatabase, StaffDatabase staffdatabase) {
		this.studentDatabase = studentDatabase;
		this.staffDatabase = staffdatabase;
	}

	/**
	 * Adds a user to the database.
	 * 
	 * @param user The user to be added.
	 * @return true if the user is added successfully, false otherwise.
	 */

	public boolean addUser(User user) {
		try {
			switch (user.getType()) {
				case STAFF:
					staffDatabase.add((Staff) user);
					return true;
				case STUDENT:
					studentDatabase.add((Student) user);
					return true;
				default:
					throw new IllegalArgumentException(user.getType().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Removes a user from the database.
	 * 
	 * @param user The user to be removed.
	 * @return true if the user is removed successfully, false otherwise.
	 */

	public boolean removeUser(User user) {
		try {
			switch (user.getType()) {
				case STAFF:
					staffDatabase.remove((Staff) user);
					return true;
				case STUDENT:
					studentDatabase.remove((Student) user);
					return true;
				default:
					throw new IllegalArgumentException(user.getType().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Gets a user by ID.
	 * 
	 * @param id The ID of the user.
	 * @return The user with the given ID.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public User getUserByID(int id) throws ClassNotFoundException, IOException {
		for (User u : studentDatabase.getAll())
			if (u.getID() == id)
				return u;
		for (User u : staffDatabase.getAll())
			if (u.getID() == id)
				return u;
		return null;
	}

	/**
	 * Gets a user by ID.
	 * 
	 * @param userID The ID of the user.
	 * @return The user with the given ID.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public User getUserByID(String userID) throws ClassNotFoundException, IOException {

		for (User u : studentDatabase.getAll())
			if (u.getName().equals(userID))
				return u;
		for (User u : staffDatabase.getAll())
			if (u.getName().equals(userID))
				return u;
		return null;
	}

	@Override

	/**
	 * Saves the user database.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */

	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.studentDatabase.save();
		this.staffDatabase.save();
	}

}
