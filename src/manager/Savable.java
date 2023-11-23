package manager;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Savable {
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException;
}
