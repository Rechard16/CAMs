package database;

import java.io.IOException;
import java.util.List;

import model.Model;


public abstract class Database<T extends Model>{
    public abstract String getFilename();
    public void save() throws IOException, ClassNotFoundException {
        List<T> objectList = getAll();
        // SerializableCollection.serializeToFile(objectList, getFilename());
    }
    public List<T> load() throws IOException, ClassNotFoundException {
        return SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        //setAll(objectList);
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
    public T findByID(int id) throws IOException, ClassNotFoundException {
        for(T object : getAll()){
            if(object.getId() == id){
                return object;
            }
        }
        return null;
    }
    public abstract List<T> getAll() throws IOException, ClassNotFoundException;
    public abstract void setAll(List<T> objectList) throws IOException;

    protected abstract Class<T> getContainedClass();
}
