package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for serializing and deserializing a list of objects to and from a file.
 */
public abstract class SerializableCollection {


    /**
     * Serializes a list of objects to a file.
     *
     * @param list the list of objects to serialize
     * @param filename the name of the file to serialize to
     * @throws IOException if an I/O error occurs
     */
    public static <T extends Serializable> void serializeToFile(List<T> list, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(list);
        }
    }

    /**
     * Deserializes a list of objects from a file.
     *
     * @param filename the name of the file to deserialize from
     * @param clazz the class of the objects in the list
     * @return the list of objects
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of the serialized object cannot be found
     */
    public static <T> List<T> deserializeListFromFile(String filename, Class<T> clazz) throws IOException, ClassNotFoundException {
        try {
        	ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Object object = in.readObject();
            if (object instanceof List<?>) {
                List<?> list = (List<?>) object;
                for (Object listObject : list) {
                    if (!clazz.isInstance(listObject)) {
                        throw new ClassNotFoundException("List contains an object of type " + listObject.getClass() + ", expected " + clazz.getCanonicalName());
                    }
                }

                List<T> result = (List<T>) list;
                return result;
            } else {
                throw new ClassNotFoundException("Expected a List but found a " + object.getClass().getCanonicalName());
            }
        } catch (Exception e) {
        	// e.printStackTrace();
        }
        return new ArrayList<T>();
    }
}
