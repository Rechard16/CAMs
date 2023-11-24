package model;

public interface Registrable {
	public boolean isRegistered(Camp camp);
	public Role getRole(Camp camp);
}
