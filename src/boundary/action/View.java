package boundary.action;

public interface View {
	public void displayView() throws Exception;
	public View getNextView() throws Exception;
}
