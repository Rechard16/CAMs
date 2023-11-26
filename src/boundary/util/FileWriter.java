package boundary.util;

import java.io.BufferedWriter;
import java.io.IOException;

import boundary.IO;

/**
 * FileWriter is a class that is used to write to a file.
 */

public class FileWriter implements IO {
	private final BufferedWriter writer;

	/*
	 * Constructor for FileWriter.
	 * 
	 * @param filename The name of the file to be written to.
	 * 
	 * @throws IOException
	 */

	public FileWriter(String filename) throws IOException {
		this.writer = new BufferedWriter(new java.io.FileWriter(filename));
	}

	@Override

	/*
	 * Finalizes the FileWriter.
	 * 
	 * @throws IOException
	 */

	protected void finalize() throws IOException {
		writer.close();
	}

	/*
	 * Prints a string to the file.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @throws IOException
	 */

	@Override
	public void print(Object s) throws IOException {
		writer.write(s.toString());
		writer.newLine();
	}

	@Override
	/*
	 * Prints a string to the file.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @param args The arguments to be formatted.
	 * 
	 * @throws IOException
	 */
	public void print(String s, Object... args) throws IOException {
		String res = String.format(s, args);
		writer.write(res);
	}

	@Override
	/*
	 * Prints a line break to the file.
	 * 
	 * @throws IOException
	 */
	public void lineBreak() throws IOException {
		print("_______________________________");
	}

	@Override
	/*
	 * Flushes the file.
	 * 
	 * @throws IOException
	 */
	public void flush() throws IOException {
		writer.flush();
	}
}
