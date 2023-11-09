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

    public CampDatabase() throws IOException, ClassNotFoundException {
        this.camps=load();
    }
    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public List<Camp> getAll() throws IOException, ClassNotFoundException {
        return camps;
    }

    @Override
    public void setAll(List<Camp> objectList) throws IOException {
        this.camps = objectList;
    }

    protected Class<Camp> getContainedClass() {
        return Camp.class;
    }

}
