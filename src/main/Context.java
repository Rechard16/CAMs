package main;

import java.io.IOException;
import java.util.Scanner;

import boundary.PermissionManager;
import boundary.action.ViewHandler;
import boundary.login.AuthenticationManager;
import manager.CampManager;
import manager.UserManager;

public class Context {
	
	private final UserManager userManager;
	private final CampManager campManager;
	private final AuthenticationManager authenticationManager;
	private final PermissionManager permissionManager;
	private final Scanner scanner = new Scanner(System.in);
	
	private Context(UserManager userManager, PermissionManager permissionManager, CampManager campManager) {
		this.userManager = userManager;
		this.permissionManager = permissionManager;
		this.authenticationManager = new AuthenticationManager(userManager);
		this.campManager = campManager;
	}
	
	@Override
	protected void finalize() {
		this.scanner.close();
	}

	public CampManager getCampManager() {
		return this.campManager;
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
	
	public void print(Object s) {
		System.out.println(s);
	}
	
	public void print(String s, Object... args) {
		System.out.printf(s, args);
	}
	
	static Context createDefaultContext() throws ClassNotFoundException, IOException {
		return new Context(new UserManager(), new PermissionManager(), new CampManager());
	}
	
	static Context createContext(UserManager userManager, PermissionManager permissionManager, CampManager campManager) {
		return new Context(userManager, permissionManager, campManager);
	}
}
