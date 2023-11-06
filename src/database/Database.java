package database;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;


public abstract class Database<T>{
    public abstract String getFilename();
    public void save(List<T> objectList) {
        MapperCollection.save(objectList, getFilename());
    }
    public List<T> load() {
        File file = new File(getFilename());
        if (file.exists()) {
            return MapperCollection.load(getFilename(), new TypeReference<List<T>>() {
            });
        }
        return null;
    }
    public void add(T newObject){
        List<T> objectList = getAll();
        objectList.add(newObject);
        save(objectList);
        load();
        setAll(objectList);
    }

    public void remove(T object){
        List<T> objectList = getAll();
        objectList.remove(object);
        save(objectList);
        load();
        setAll(objectList);
    }
    public void update(T object){
        List<T> objectList = getAll();
        int index = objectList.indexOf(object);
        objectList.set(index, object);
        save(objectList);
        load();
        setAll(objectList);
    }
    public abstract List<T> getAll();
    public abstract void setAll(List<T> objectList);

}
