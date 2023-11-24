package boundary.util;

import java.io.BufferedWriter;
import java.io.IOException;

import boundary.IO;

public class FileWriter implements IO {
	private final BufferedWriter writer;
	
	public FileWriter(String filename) throws IOException {
		this.writer = new BufferedWriter(new java.io.FileWriter(filename));
	}
	
	@Override
	protected void finalize() throws IOException {
		writer.close();
	}

	@Override
	public void print(Object s) throws IOException {
		writer.write(s.toString());
		writer.newLine();
	}

	@Override
	public void print(String s, Object... args) throws IOException {
		String res = String.format(s, args);
		writer.write(res);
	}

	@Override
	public void lineBreak() throws IOException {
		print("_______________________________");
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}
}
