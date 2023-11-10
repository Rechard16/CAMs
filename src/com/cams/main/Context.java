package main;

import java.util.Scanner;

import boundary.PermissionManager;
import boundary.login.AuthenticationManager;
import manager.UserManager;

public class Context {
	
	private final UserManager userManager;
	private final AuthenticationManager authenticationManager;
	private final PermissionManager permissionManager;
	private final Scanner scanner = new Scanner(System.in);
	
	public Context(UserManager userManager, PermissionManager permissionManager) {
		this.userManager = userManager;
		this.permissionManager = permissionManager;
		this.authenticationManager = new AuthenticationManager(userManager);
	}
	
	@Override
	protected void finalize() {
		this.scanner.close();
	}

	public AuthenticationManager getAuthenticationManager() {
		return this.authenticationManager;
	}
	
	public PermissionManager getPermissionManager() {
		return this.permissionManager;
	}
	
	public UserManager getUserManager() {
		return this.userManager;
	}
	
	public Scanner getScanner() {
		return this.scanner;
	}
	
	public void print(String s) {
		System.out.println(s);
	}
	
	public void print(String s, Object... args) {
		System.out.printf(s, args);
	}
	
	static Context createContext() {
		return new Context(new UserManager(), new PermissionManager());
	}
}
