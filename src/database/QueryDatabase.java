package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import model.Query;

public class QueryDatabase extends Database<Query> {
    private final String filename = "data/queries.txt";
    private List<Query> queries = new ArrayList<>();

    private AtomicInteger idGenerator = new AtomicInteger();
    public QueryDatabase() throws IOException, ClassNotFoundException {
        this.queries=super.load();
    }

    public int generateNewId() {
        return idGenerator.incrementAndGet();
    }


    public String getFilename() {
        return filename;
    }

    public List<Query> getAll() throws IOException, ClassNotFoundException {
        return this.queries;
    }

    public void setAll(List<Query> objectList)  {
        this.queries = objectList;
    }


    protected Class<Query> getContainedClass() {
        return Query.class;
    }
}
