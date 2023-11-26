package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Query;

/**
 * This class is a database for queries.
 * It extends the abstract class Database.
 *
 */
public class QueryDatabase extends Database<Query> {
    /**
     * The filename of the file that the database is saved to.
     */
    private final String filename = "data/queries.txt";

    /**
     * The list of queries.
     */
    private List<Query> queries = new ArrayList<>();

    /**
     * The constructor of the class.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class is not found
     */
    public QueryDatabase() throws IOException, ClassNotFoundException {
        this.queries=super.load();
    }

    public String getFilename() {
        return filename;
    }

    /**
     * Gets the list of queries.
     * @return The list of queries.
     */
    public List<Query> getAll() throws IOException, ClassNotFoundException {
        return this.queries;
    }

    /**
     * Sets the list of queries.
     * @param objectList The list of objects to be set.
     */
    public void setAll(List<Query> objectList)  {
        this.queries = objectList;
    }

    /**
     * Gets the class of the contained object.
     * @return The class of the contained object.
     */
    protected Class<Query> getContainedClass() {
        return Query.class;
    }

	@Override
	public void clear() throws ClassNotFoundException, IOException {
		this.queries.clear();
		save();
	}
}
