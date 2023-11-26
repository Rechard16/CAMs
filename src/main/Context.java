package main;

import java.io.IOException;
import java.util.Scanner;

import boundary.IO;
import boundary.manager.AuthenticationManager;
import boundary.manager.PermissionManager;
import control.manager.CampManager;
import control.manager.QueryManager;
import control.manager.SuggestionManager;
import control.manager.UserManager;

/**
 * Context class is a singleton class that holds all the managers and the
 * scanner.
 * It is used to pass the managers and the scanner to the controllers.
 * It is also used to print to the console.
 */

public class Context implements IO {
	private final UserManager userManager;
	private final CampManager campManager;
	private final SuggestionManager suggestionManager;
	private final QueryManager querymanager;
	private final AuthenticationManager authenticationManager;
	private final PermissionManager permissionManager;
	private final Scanner scanner = new Scanner(System.in);

	/**
	 * Constructor for the Context class.
	 * 
	 * @param userManager       The UserManager object.
	 * @param permissionManager The PermissionManager object.
	 * @param campManager       The CampManager object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	private Context(UserManager userManager, PermissionManager permissionManager, CampManager campManager)
			throws ClassNotFoundException, IOException {
		this.userManager = userManager;
		this.permissionManager = permissionManager;
		this.suggestionManager = new SuggestionManager();
		this.querymanager = new QueryManager();
		this.authenticationManager = new AuthenticationManager(userManager);
		this.campManager = campManager;
	}

	/**
	 * Finalize method for the Context class.
	 * 
	 * @throws Throwable
	 */

	@Override
	protected void finalize() {
		this.scanner.close();
	}

	/**
	 * Getter for the SuggestionManager object.
	 * 
	 * @return The SuggestionManager object.
	 */

	public SuggestionManager getSuggestionManager() {
		return this.suggestionManager;
	}

	/**
	 * Getter for the QueryManager object.
	 * 
	 * @return The QueryManager object.
	 */

	public QueryManager getQueryManager() {
		return this.querymanager;
	}

	/**
	 * Getter for the CampManager object.
	 * 
	 * @return The CampManager object.
	 */

	public CampManager getCampManager() {
		return this.campManager;
	}

	/**
	 * Getter for the AuthenticationManager object.
	 * 
	 * @return The AuthenticationManager object.
	 */

	public AuthenticationManager getAuthenticationManager() {
		return this.authenticationManager;
	}

	/**
	 * Getter for the PermissionManager object.
	 * 
	 * @return The PermissionManager object.
	 */

	public PermissionManager getPermissionManager() {
		return this.permissionManager;
	}

	/**
	 * Getter for the UserManager object.
	 * 
	 * @return The UserManager object.
	 */

	public UserManager getUserManager() {
		return this.userManager;
	}

	/**
	 * Getter for the Scanner object.
	 * 
	 * @return The Scanner object.
	 */

	public Scanner getScanner() {
		return this.scanner;
	}

	/**
	 * Prints to the console.
	 * 
	 * @param s The string to be printed.
	 */

	public void print(Object s) {
		System.out.println(s);
	}

	/**
	 * Prints to the console.
	 * 
	 * @param s    The string to be printed.
	 * @param args The arguments to be formatted.
	 */

	public void print(String s, Object... args) {
		System.out.printf(s, args);
	}

	/**
	 * Prints a line break to the console.
	 */

	public void lineBreak() {
		print("-----------------------------------------------------------");
	}

	/**
	 * Prints a line break to the console.
	 * 
	 * @param s The string to be printed.
	 */

	@Override
	public void flush() throws IOException {
		System.out.flush();
	}

	/**
	 * Creates a default Context object.
	 * 
	 * @return The Context object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	static Context createDefaultContext() throws ClassNotFoundException, IOException {
		return new Context(new UserManager(), new PermissionManager(), new CampManager());
	}

	/**
	 * Creates a Context object.
	 * 
	 * @param userManager       The UserManager object.
	 * @param permissionManager The PermissionManager object.
	 * @param campManager       The CampManager object.
	 * @return The Context object.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	static Context createContext(UserManager userManager, PermissionManager permissionManager, CampManager campManager)
			throws ClassNotFoundException, IOException {
		return new Context(userManager, permissionManager, campManager);
	}

}
