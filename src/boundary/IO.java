package boundary;

import java.io.IOException;

public interface IO {
	public void print(Object s) throws IOException;
	public void print(String s, Object... args) throws IOException;
	public void lineBreak() throws IOException;
	public void flush() throws IOException;
}
