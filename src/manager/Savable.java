package manager;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Savable is an interface that is used to save the data.
 */
public interface Savable {
	public void save() throws IOException, FileNotFoundException, ClassNotFoundException;
}
