package database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import model.Camp;
//本地测试用
public class CampDatabase extends Database<Camp> {

    private final String filename = "../data/camps"; 
    private List<Camp> camps;

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Camp> getAll() throws IOException, ClassNotFoundException {
        File file = new File(getFilename());
        if (file.exists()) {
            camps = SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        }
        return camps;
    }

    @Override
    public void setAll(List<Camp> objectList) throws IOException {
        this.camps = objectList;
        SerializableCollection.serializeToFile(camps, getFilename());
    }

    protected Class<Camp> getContainedClass() {
        return Camp.class;
    }

}
