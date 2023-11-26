package entity.filter;

import java.io.IOException;

import boundary.reader.EnumReader;
import entity.FacultyMember;
import entity.model.Faculty;
import main.Context;

/**
 * FacultyParameter is a class that is used to filter faculty members by
 * faculty.
 */

public class FacultyParameter extends FilterParameter<FacultyMember> {
	private Faculty faculty;

	@Override
	/**
	 * Builds the filter parameter.
	 * 
	 * @param context The context to be used.
	 */
	public void build(Context context) throws Exception {
		context.print("What faculty are you searching for?");
		this.faculty = new EnumReader<Faculty>(context, Faculty.class).readEnum();
	}

	@Override
	/**
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Faculty"
	 */
	public String getName() {
		return "Faculty";
	}

	@Override
	/**
	 * Checks if the faculty member is valid.
	 * 
	 * @param context The context to be used.
	 * @param obj     The faculty member to be used.
	 * @return True if the faculty member is valid, false otherwise.
	 */
	public boolean isValid(Context context, FacultyMember obj) throws ClassNotFoundException, IOException {
		return obj.getFaculty() == faculty;
	}
}
