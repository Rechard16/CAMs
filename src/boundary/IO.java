package boundary;

import java.io.IOException;

/**
 * IO is an interface that is used to print to the console.
 */
public interface IO {
	/*
	 * Prints a string to the console.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @throws IOException
	 */
	public void print(Object s) throws IOException;

	/*
	 * Prints a string to the console.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @param args The arguments to be formatted.
	 * 
	 * @throws IOException
	 */

	public void print(String s, Object... args) throws IOException;

	/*
	 * Prints a string to the console and adds a line break.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @throws IOException
	 */

	public void lineBreak() throws IOException;

	/*
	 * Prints a string to the console and adds a line break.
	 * 
	 * @param s The string to be printed.
	 * 
	 * @throws IOException
	 */

	public void flush() throws IOException;
}
