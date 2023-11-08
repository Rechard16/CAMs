package database;

import java.io.File;
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
    public List<Camp> getAll() {
        File file = new File(getFilename());
        if (file.exists()) {
            camps = MapperCollection.load(getFilename(), new TypeReference<List<Camp>>() {
            });
        }
        return camps;
    }

    @Override
    public void setAll(List<Camp> objectList) {
        this.camps = objectList;
        MapperCollection.save(camps, getFilename());
    }

}
