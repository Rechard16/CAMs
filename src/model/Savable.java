package model;

import model.Model;
import model.Serializable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static model.Serializable.serialize;

public abstract class Savable<ModelObj extends Serializable> {
    protected abstract List<Serializable> getAll();

    protected abstract void setAll(List<String> ListOfModel);

    protected abstract List<String> getFilePath();

    protected void save() throws IllegalAccessException, IOException {
        // save the serialized string to the goal file
        String filePath = getFilePath().get(0);
        List<Serializable> ListOfModel = (List<Serializable>) getAll();
        String serializedString = ModelObj.serialize(ListOfModel);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(serializedString);
        }
    }

    protected void load() throws IOException, IllegalAccessException, InstantiationException {
        // load the serialized string from the goal file
        String filePath = getFilePath().get(0);
        String serializedString = new String(Files.readAllBytes(Paths.get(filePath)));
        List<String> ListOfModel = new ArrayList<>();
        ListOfModel.add(serializedString);
        setAll(ListOfModel);
    }

}
