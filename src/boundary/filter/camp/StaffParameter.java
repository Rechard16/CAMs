package boundary.filter.camp;

import boundary.filter.FilterParameter;
import model.Camp;

public class StaffParameter extends FilterParameter<Camp> {
	private int s;
	
	public StaffParameter(int s) { this.s = s; }
	public StaffParameter() {}
	
	public void setString(int s) { this.s = s; }

	@Override
	public boolean isValid(Camp obj) {
		return obj.getInformation().getStaffID() == s;
	}
}
