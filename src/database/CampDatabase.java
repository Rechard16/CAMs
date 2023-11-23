package database;

import java.io.IOException;
import java.util.List;

import model.Camp;

/**
 *
 * @author Zeng Ruixiao
 * @version 1.0
 * @since 2023-11-22
 */
public class CampDatabase extends Database<Camp> {

    private final String filename = "data/camps.txt";
    private List<Camp> camps;

    public CampDatabase() throws IOException, ClassNotFoundException {
        this.camps=super.load();
    }
    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public List<Camp> getAll() throws IOException, ClassNotFoundException {
        return this.camps;
    }

    @Override
    public void setAll(List<Camp> objectList)  {
        this.camps = objectList;
    }

    protected Class<Camp> getContainedClass() {
        return Camp.class;
    }

}
