package model;

public class Staff extends User {

    public Camp createCamp(CampInfo campInfo) {
        // Implement the method
        return null;
    }
    
    @Override
    public UserType getType() { return UserType.STAFF; }

    public void editCamp(int campID, CampInfo campInfo) {
        // Implement the method
    }

    public void deleteCamp(int campID) {
        // Implement the method
    }

    public void toggleVisibility(int campID) {
        // Implement the method
    }

    public void viewSuggestion(int suggestionID) {
        // Implement the method
    }

    public void approveSuggestion(int suggestionID) {
        // Implement the method
    }

    public void generateReport() {
        // Implement the method
    }

	@Override
	protected void viewQuery() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void viewCamps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void generateStudentList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void filterCamps() {
		// TODO Auto-generated method stub
		
	}
}