package boundary.filter;

import java.io.IOException;

import main.Context;
import model.Camp;
import model.User;

public class StaffParameter extends FilterParameter<Camp> {
	private String staffID;
	
	public StaffParameter() {}
	
	@Override
	public boolean isValid(Context context, Camp obj) throws ClassNotFoundException, IOException {
		int id = obj.getInformation().getStaffID();
		User user = context.getUserManager().getUserByID(id);
		return user.getName().toUpperCase().contains(staffID.toUpperCase());
	}
	@Override
	public void build(Context context) throws Exception {
		context.print("What is the name of the staff you are searching for?");
		staffID = context.getScanner().nextLine();
	}
	@Override
	public String getName() {
		return "Staff";
	}
}
