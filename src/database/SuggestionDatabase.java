package database;

import model.Suggestion;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SuggestionDatabase extends Database<Suggestion> {
    private final String filename = "../data/suggestions";
    private List<Suggestion> suggestions;

    private AtomicInteger idGenerator = new AtomicInteger();

    public int generateNewId() {
        return idGenerator.incrementAndGet();
    }

   /* public void update(Suggestion suggestion) {

        List<Suggestion> suggestions = getAll();
        for (int i = 0; i < suggestions.size(); i++) {
            if (suggestions.get(i).getId() == suggestion.getId()) {
                suggestions.set(i, suggestion);
                save();
                break;
            }
        }
    }*/

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Suggestion> getAll() throws IOException, ClassNotFoundException {
        File file = new File(getFilename());
        if (file.exists()) {
            suggestions = SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        }
        return suggestions;
    }

    @Override
    public void setAll(List<Suggestion> objectList) throws IOException {
        this.suggestions = objectList;
        SerializableCollection.serializeToFile(suggestions, getFilename());
    }

    protected Class<Suggestion> getContainedClass() {
        return Suggestion.class;
    }
}
