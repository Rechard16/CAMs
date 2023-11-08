package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import database.SuggestionDatabase;

public class Suggestion extends Model {
    private User user;
    private int campID;
    private int suggestionID;
    private String description;
    public List<Change> changes = new ArrayList<>(); // 初始化changes列表
    private SuggestionDatabase suggestionDatabase;

    public Suggestion(User user, int campID, String description, SuggestionDatabase suggestionDatabase) {
        this.user = user;
        this.campID = campID;
        this.description = description;
        this.suggestionDatabase = suggestionDatabase;
        this.suggestionID = suggestionDatabase.generateNewId(); // 假设SuggestionDatabase有generateNewId()方法
    }

    public void view() {
        System.out.println("Suggestion ID: " + this.suggestionID);
        System.out.println("Camp ID: " + this.campID);
        System.out.println("User ID: " + this.user.getId()); // User类需要有getId方法
        System.out.println("Content: " + this.description);
        for (Change change : changes) {
            System.out.println(change.toString()); // Change接口需要有toString方法
        }
    }

    public void edit() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Select option: \n1. Edit Content \n2. Delete Suggestion \n3. Exit");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (option) {
                    case 1:
                        System.out.println("Current content: " + this.description);
                        System.out.println("Enter new description:");
                        this.description = scanner.nextLine();
                        suggestionDatabase.update(this);
                        break;
                    case 2:
                        this.delete();
                        return; // Exit after deletion
                    case 3:
                        return; // Exit editing
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } finally {
            scanner.close(); // 确保Scanner最终被关闭
        }
    }

    public void delete() {
        // 从database清空本对象内容
        suggestionDatabase.remove(this);
    }

    public int getId() {
        return this.suggestionID;
    }
}
