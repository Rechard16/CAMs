package database;

import java.io.IOException;
import java.util.List;

import manager.Savable;
import model.Model;

/**
 * The Database class is an abstract class that represents a database of objects of type T.
 * It contains methods for adding, removing, updating, and finding objects in the database.
 * It also contains methods for saving and loading the database to and from a file.
 * This class T extends the Model class.
 *
 * @param <T> The type of object stored in the database, must extend {@link model.Model}.
 */

public abstract class Database<T extends Model> implements Savable {
    /**
     * Gets the filename of the file that the database is saved to.
     * @return The filename as a String.
     */
    public abstract String getFilename();

    /**
     * Saves the database to a file.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public void save() throws IOException, ClassNotFoundException {
        List<T> objectList = getAll();
        SerializableCollection.serializeToFile(objectList, getFilename());
    }

    /**
     * Loads the database from a file.
     * @return A list of objects of type T.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public List<T> load() throws IOException, ClassNotFoundException {
        return SerializableCollection.deserializeListFromFile(getFilename(), getContainedClass());
        //setAll(objectList);
    }

    /**
     * Adds an object to the database.
     * @param newObject The object to be added.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public void add(T newObject) throws IOException, ClassNotFoundException {
        List<T> objectList = getAll();
        objectList.add(newObject);

        save();
    }

    /**
     * Removes an object from the database.
     * @param object The object to be removed.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public void remove(T object) throws IOException, ClassNotFoundException{
        List<T> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.remove(index);
            save();
        }
        else throw new ClassNotFoundException("Object not found");
    }

    /**
     * Updates an object in the database.
     * @param object The object to be updated.
     * @param newObject The new object to replace the old object.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public void update(T object,T newObject) throws IOException, ClassNotFoundException{
        List<T> objectList = getAll();
        int index = objectList.indexOf(object);
        if(index != -1){
            objectList.set(index, newObject);
            save();
        }
        else throw new ClassNotFoundException("Object not found");
    }

    /**
     * Finds an object in the database by its ID.
     * @param id The ID of the object to be found.
     * @return The object with the specified ID.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public T findByID(int id) throws IOException, ClassNotFoundException {
        for(T object : getAll()){
            if(object.getID() == id){
                return object;
            }
        }
        return null;
    }

    /**
     * Gets all objects in the database.
     * @return A list of all objects in the database.
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
    public abstract List<T> getAll() throws IOException, ClassNotFoundException;

    /**
     * Sets all objects in the database.
     * @param objectList The list of objects to be set.
     * @throws IOException if an I/O error occurs
     */
    public abstract void setAll(List<T> objectList) ;

    /**
     * Gets the class of the objects stored in the database.
     * @return The class of the objects stored in the database.
     */
    protected abstract Class<T> getContainedClass();
}
