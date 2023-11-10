<<<<<<< HEAD
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
    
    //added
    public List<Camp> getList() {
    	return this.camps;
    }
    //added
    public List<Camp> load() throws IOException, ClassNotFoundException {
        return SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        //setAll(objectList);
    }
    //added from abstract class Database
    public void remove(Camp object) throws IOException, ClassNotFoundException{
        List<Camp> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.remove(index);
           // save();
        }
        else throw new ClassNotFoundException("Object not found");
    }
    public void update(Camp object,Camp newObject) throws IOException, ClassNotFoundException{
        List<Camp> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.set(index, newObject);
          //  save();
        }
        else throw new ClassNotFoundException("Object not found");
    }

}
=======
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
>>>>>>> main
