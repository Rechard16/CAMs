package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.Suggestion;

public class SuggestionDatabase extends Database<Suggestion> {
    private final String filename = "data/suggestions.txt";
    private List<Suggestion> suggestions = new ArrayList<>();

    private AtomicInteger idGenerator = new AtomicInteger();
    public SuggestionDatabase() throws IOException, ClassNotFoundException {
        this.suggestions=super.load();
    }

    public int generateNewId() {
        return idGenerator.incrementAndGet();
    }


    public String getFilename() {
        return filename;
    }
    public List<Suggestion> getAll() throws IOException, ClassNotFoundException {
        return this.suggestions;
    }
    public void setAll(List<Suggestion> objectList)  {
        this.suggestions = objectList;
    }


    protected Class<Suggestion> getContainedClass() {
        return Suggestion.class;
    }
}
