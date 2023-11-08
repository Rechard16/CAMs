package database;
import java.io.*;
import java.util.List;

public abstract class SerializableCollection{


    public static void serializeToFile(Object object, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(object);
        }
    }
    public static Object deserializeFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return in.readObject();
        }
    }

}
