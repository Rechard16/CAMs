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
        for (Query query : queryDatabase.getAll())
            if (query.getID() == queryID) return query;
        return null;
    }

    public boolean replyToQuery(int queryID, String response) throws IOException, ClassNotFoundException {
        for (Query query : queryDatabase.getAll()) {
            if (query.getID() == queryID) {
                query.setReply(response);
                queryDatabase.save();
                return true;
            }
        }
        return false;
    }

	@Override
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
}
