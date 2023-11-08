package database;
import java.io.*;
import java.util.List;

public abstract class SerializableCollection {


    public static <T extends Serializable> void serializeToFile(List<T> list, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(list);
        }
    }


    public static <T> List<T> deserializeListFromFile(String filename, Class<T> clazz) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object object = in.readObject();

            if (object instanceof List<?>) {
                List<?> list = (List<?>) object;
                for (Object listObject : list) {
                    if (!clazz.isInstance(listObject)) {
                        throw new ClassNotFoundException("List contains an object of type " + listObject.getClass() + ", expected " + clazz.getCanonicalName());
                    }
                }
                @SuppressWarnings("unchecked")
                List<T> result = (List<T>) list;
                return result;
            } else {
                throw new ClassNotFoundException("Expected a List but found a " + object.getClass().getCanonicalName());
            }
        }
    }
}
