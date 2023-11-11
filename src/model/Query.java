package model;

import database.SuggestionDatabase;

import java.util.List;
import java.util.Scanner;

public class Query extends Model {
    private int userId;
    private int campId;
    private int queryId;
    private String description;
    private SuggestionDatabase suggestionDatabase; // 添加对SuggestionDatabase的引用

    public Query() {}

    public Query(int userId, int campId, String description) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = 1;
        this.description = description;
    }

    public Query(int userId, int campId, String description, SuggestionDatabase suggestionDatabase) {
        this.userId = userId;
        this.campId = campId;
        this.queryId = suggestionDatabase.generateNewId(); // 使用suggestionDatabase生成新的ID
        this.description = description;
        this.suggestionDatabase = suggestionDatabase;
    }

    public int getId() {
        return this.queryId;
    }

    public int getCampId() {
        return this.campId;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(int id) {
        this.queryId = id;
    }

    public void setCampId(int id) {
        this.campId = id;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
