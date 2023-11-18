package manager;

import database.QueryDatabase;
import model.Query;
import java.io.IOException;

public class QueryManager {
    private QueryDatabase queryDatabase;

    public QueryManager() {
        this.queryDatabase = new QueryDatabase();
    }

    public Query createQuery(int userId, int campId, String description) throws IOException, ClassNotFoundException {
        int newQueryId = queryDatabase.generateNewId(); // 生成新的ID
        Query query = new Query(userId, campId, newQueryId, description); // 使用新ID创建Query对象
        queryDatabase.add(query); // 添加到数据库
        return query;
    }

    public boolean deleteQuery(int queryID) throws IOException, ClassNotFoundException {
        for (Query query : queryDatabase.getAll()) {
            if (query.getId() == queryID) {
                queryDatabase.remove(query);
                return true;
            }
        }
        return false;
    }

    public boolean editQuery(int queryID, String newDescription) throws IOException, ClassNotFoundException {
        for (Query query : queryDatabase.getAll()) {
            if (query.getId() == queryID) {
                query.setDescription(newDescription);
                queryDatabase.save();
                return true;
            }
        }
        return false;
    }

    public Query getQueryByID(int queryID) throws IOException, ClassNotFoundException {
        for (Query query : queryDatabase.getAll()) {
            if (query.getId() == queryID) {
                return query;
            }
        }
        return null;
    }

    public boolean replyToQuery(int queryID, String response) throws IOException, ClassNotFoundException {
        for (Query query : queryDatabase.getAll()) {
            if (query.getId() == queryID) {
                query.setReply(response);
                queryDatabase.save();
                return true;
            }
        }
        return false;
    }
}
