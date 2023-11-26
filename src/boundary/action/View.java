package boundary.action;
/*
 * View is an interface that is used to display views.
 */

public interface View {
	public void displayView() throws Exception;

	public View getNextView() throws Exception;
}
