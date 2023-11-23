package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.Suggestion;

/**
 * This class is a database for suggestions.
 * It extends the abstract class Database.
 */
public class SuggestionDatabase extends Database<Suggestion> {
    /**
     * The filename of the file that the database is saved to.
     */
    private final String filename = "/data/suggestions.txt";
    /**
     * The list of suggestions.
     */
    private List<Suggestion> suggestions = new ArrayList<>();

    /**
     * The constructor of the class.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public SuggestionDatabase() throws IOException, ClassNotFoundException {
        this.suggestions=super.load();
    }

    /**
     * Gets the filename of the file that the database is saved to.
     * @return The filename as a String.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Gets the list of suggestions.
     * @return The list of suggestions.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public List<Suggestion> getAll() throws IOException, ClassNotFoundException {
        return this.suggestions;
    }
    public void setAll(List<Suggestion> objectList)  {
        this.suggestions = objectList;
    }

    /**
     * Gets the class of the contained object.
     * @return The class of the contained object.
     */
    protected Class<Suggestion> getContainedClass() {
        return Suggestion.class;
    }
}
