package control.login;

import java.util.ArrayList;
import java.util.List;

import boundary.action.ViewHandler;
/*
 * ViewStack is a class that is used to manage the view stack.
 */

public class ViewStack {
	private final List<ViewHandler> stack;
	/*
	 * Constructor for ViewStack.
	 */

	public ViewStack() {
		stack = new ArrayList<>();
	}
	/*
	 * Adds a view.
	 * 
	 * @param view The view to be added.
	 */

	public void addView(ViewHandler view) {
		stack.add(view);
	}
	/*
	 * Gets the top view.
	 * 
	 * @return The top view.
	 */

	public ViewHandler top() {
		return stack.get(stack.size() - 1);
	}
	/*
	 * Pops the top view.
	 * 
	 * @return The top view.
	 */

	public ViewHandler pop() {
		stack.remove(stack.size() - 1);
		return stack.get(stack.size() - 1);
	}
	/*
	 * Pops the top view.
	 * 
	 * @param i The number of views to be popped.
	 * 
	 * @return The top view.
	 */

	public ViewHandler pop(int i) {
		stack.subList(stack.size() - i, stack.size()).clear();
		return stack.get(stack.size() - 1);
	}
	/*
	 * Resets the view stack.
	 * 
	 * @return The top view.
	 */

	public ViewHandler reset() {
		stack.subList(1, stack.size()).clear();
		return stack.get(0);
	}
}
