package boundary.login;

import java.util.ArrayList;
import java.util.List;

import boundary.action.ViewHandler;

public class ViewStack {
	private final List<ViewHandler> stack;
	
	public ViewStack() {
		stack = new ArrayList<>();
	}
	
	public void addView(ViewHandler view) {
		stack.add(view);
	}
	
	public ViewHandler top() {
		return stack.get(stack.size()-1);
	}
	
	public ViewHandler pop() {
		stack.remove(stack.size()-1);
		return stack.get(stack.size()-1);
	}
}
