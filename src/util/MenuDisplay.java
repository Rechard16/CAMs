package util;

public class MenuDisplay {

    public void showMainMenu() {
        System.out.println("========== Main Menu ==========");
        System.out.println("1. Login");
        System.out.println("2. View Camps");
        System.out.println("3. Register for Camp");
        System.out.println("4. Submit Query");
        System.out.println("5. Submit Suggestion");
        System.out.println("6. Logout");
        System.out.println("0. Exit");
        System.out.println("================================");
        System.out.println("Please enter your choice:");
    }

    public void showStudentMenu() {
        System.out.println("========== Student Menu ==========");
        System.out.println("1. View Available Camps");
        System.out.println("2. Register for Camp");
        System.out.println("3. View Registered Camps");
        System.out.println("4. Withdraw from Camp");
        System.out.println("5. Submit Query");
        System.out.println("6. Submit Suggestion");
        System.out.println("7. Logout");
        System.out.println("0. Exit");
        System.out.println("==================================");
        System.out.println("Please enter your choice:");
    }

    public void showStaffMenu() {
        System.out.println("========== Staff Menu ===========");
        System.out.println("1. Create Camp");
        System.out.println("2. Edit Camp");
        System.out.println("3. Delete Camp");
        System.out.println("4. View Queries");
        System.out.println("5. Reply to Query");
        System.out.println("6. View Suggestions");
        System.out.println("7. Approve Suggestion");
        System.out.println("8. Logout");
        System.out.println("0. Exit");
        System.out.println("=================================");
        System.out.println("Please enter your choice:");
    }

    public void showErrorMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
