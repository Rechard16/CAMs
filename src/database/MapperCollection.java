package database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;

public class MapperCollection {

    public static <T> void save(List<T> objectList, String filename) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(filename), objectList);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> load(String filename, TypeReference<List<T>> typeReference) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File(filename), typeReference);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
