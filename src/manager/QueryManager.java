package manager;

import java.io.FileNotFoundException;
import java.io.IOException;

import database.QueryDatabase;
import model.Query;

public class QueryManager implements Savable{
    private QueryDatabase queryDatabase;

    public QueryManager() throws IOException, ClassNotFoundException {
        this.queryDatabase = new QueryDatabase();
    }

    public Query createQuery(int userID, int campID, String description) throws IOException, ClassNotFoundException {
        int newQueryId = queryDatabase.suggestID();
        Query query = new Query(userID, campID, newQueryId, description); // 使用新ID创建Query对象
		queryDatabase.add(query); // 添加到数据库
        return query;
    }

    public Query getQueryByID(int queryID) throws IOException, ClassNotFoundException {
    	return queryDatabase.findByID(queryID);
    }

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		this.queryDatabase.save();
	}
}
