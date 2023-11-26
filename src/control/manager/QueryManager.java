package control.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import control.database.QueryDatabase;
import entity.model.EnquiryStatus;
import entity.model.Query;

/*
 * QueryManager is a manager class that manages the queries.
 * It is used to create, update, delete, and get queries.
 * It is also used to get queries by camp.
 */

public class QueryManager implements Savable {
	private QueryDatabase queryDatabase;

	/**
	 * Constructor for the QueryManager class.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public QueryManager() throws IOException, ClassNotFoundException {
		this.queryDatabase = new QueryDatabase();
	}

	/**
	 * Creates a query.
	 * 
	 * @param userID      The user ID.
	 * @param campID      The camp ID.
	 * @param title       The title.
	 * @param description The description.
	 * @return The Query object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public Query createQuery(int userID, int campID, String title, String description)
			throws IOException, ClassNotFoundException {
		int newQueryId = queryDatabase.suggestID();
		Query query = new Query(userID, campID, newQueryId, title, description); // 使用新ID创建Query对象
		queryDatabase.add(query); // 添加到数据库
		return query;
	}

	/**
	 * Updates a query.
	 * 
	 * @param query       The original Query object.
	 * @param title       The title.
	 * @param description The description.
	 * @return The Query object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public Query updateQuery(Query query, String title, String description) throws ClassNotFoundException, IOException {
		Query q = new Query(query.getUserID(), query.getCampID(),
				query.getID(), title, description);
		queryDatabase.update(query, q);
		return q;
	}

	/**
	 * Deletes a query.
	 * 
	 * @param id The query ID.
	 * @return The boolean value of whether the query is deleted.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public boolean deleteQuery(int id) throws ClassNotFoundException, IOException {
		Query q = queryDatabase.findByID(id);
		if (q == null)
			return false;
		queryDatabase.remove(q);
		return true;
	}

	/**
	 * Deletes a query.
	 * 
	 * @param query The Query object.
	 * @return The boolean value of whether the query is deleted.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public boolean deleteQuery(Query query) throws ClassNotFoundException, IOException {
		return queryDatabase.remove(query);
	}

	/**
	 * Gets a query by ID.
	 * 
	 * @param queryID The query ID.
	 * @return The Query object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public Query getQueryByID(int queryID) throws IOException, ClassNotFoundException {
		return queryDatabase.findByID(queryID);
	}

	/**
	 * Gets a query by camp.
	 * 
	 * @param campID The camp ID.
	 * @return The Query object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public List<Query> getQueryByCamp(int campID) throws ClassNotFoundException, IOException {
		return queryDatabase.getAll().stream().filter(i -> i.getCampID() == campID
				&& i.getStatus() != EnquiryStatus.ANSWERED).toList();
	}

	/**
	 * Gets a query by camp and user.
	 * 
	 * @param campID The camp ID.
	 * @param userID The user ID.
	 * @return The Query object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public List<Query> getQueryByCamp(int campID, int userID) throws ClassNotFoundException, IOException {
		return queryDatabase.getAll().stream().filter(i -> i.getUserID() == userID
				&& i.getCampID() == campID).toList();
	}

	/*
	 * save() method is used to save the database.
	 */

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.queryDatabase.save();
	}
}
