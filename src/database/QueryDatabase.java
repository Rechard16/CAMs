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

    public int generateNewId() {
        return idGenerator.incrementAndGet();
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Query> getAll() throws IOException, ClassNotFoundException {
        File file = new File(getFilename());
        if (file.exists()) {
            queries = SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        }
        return queries;
    }

    @Override
    public void setAll(List<Query> objectList) throws IOException {
        this.queries = objectList;
        SerializableCollection.serializeToFile(queries, getFilename());
    }

    protected Class<Query> getContainedClass() {
        return Query.class;
    }
}
