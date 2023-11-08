package database;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public abstract class Database<T extends Serializable>{
    public abstract String getFilename();
    public void save() throws IOException {
        List<T> objectList = getAll();
        SerializableCollection.serializeToFile(objectList, getFilename());
    }
    public void load() throws IOException, ClassNotFoundException {
        List<T> objectList=SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        setAll(objectList);
    }


    public void add(T newObject) throws IOException, ClassNotFoundException {
        List<T> objectList = getAll();
        objectList.add(newObject);
        save();
    }

    public void remove(T object) throws IOException, ClassNotFoundException{
        List<T> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.remove(index);
            save();
        }
        else throw new ClassNotFoundException("Object not found");
    }
    public void update(T object,T newObject) throws IOException, ClassNotFoundException{
        List<T> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.set(index, newObject);
            save();
        }
        else throw new ClassNotFoundException("Object not found");
    }
    public abstract List<T> getAll();
    public abstract void setAll(List<T> objectList);

    protected abstract Class<T> getContainedClass();
}
