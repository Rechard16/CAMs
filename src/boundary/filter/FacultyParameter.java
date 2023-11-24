package boundary.filter;

import java.io.IOException;

import boundary.reader.EnumReader;
import main.Context;
import model.Faculty;
import model.interfaces.FacultyMember;

public class FacultyParameter extends FilterParameter<FacultyMember>{
	private Faculty faculty;

	@Override
	public void build(Context context) throws Exception {
		context.print("What faculty are you searching for?");
		this.faculty = new EnumReader<Faculty>(context, Faculty.class).readEnum();
	}

	@Override
	public String getName() {
		return "Faculty";
	}

	@Override
	public boolean isValid(Context context, FacultyMember obj) throws ClassNotFoundException, IOException {
		return obj.getFaculty() == faculty;
	}
}
