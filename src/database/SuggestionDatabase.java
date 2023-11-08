package database;

import model.Suggestion;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SuggestionDatabase extends Database<Suggestion> {
    private final String filename = "../data/suggestions";
    private List<Suggestion> suggestions;

    private AtomicInteger idGenerator = new AtomicInteger();

    public int generateNewId() {
        return idGenerator.incrementAndGet();
    }

    public void update(Suggestion suggestion) {

        List<Suggestion> suggestions = getAll();
        for (int i = 0; i < suggestions.size(); i++) {
            if (suggestions.get(i).getId() == suggestion.getId()) {
                suggestions.set(i, suggestion);
                save(suggestions);
                break;
            }
        }
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Suggestion> getAll() {
        File file = new File(getFilename());
        if (file.exists()) {
            suggestions = MapperCollection.load(getFilename(), new TypeReference<List<Suggestion>>() {
            });
        }
        return suggestions;
    }

    @Override
    public void setAll(List<Suggestion> objectList) {
        this.suggestions = objectList;
        MapperCollection.save(suggestions, getFilename());
    }
}
