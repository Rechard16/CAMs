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
	
	public ViewHandler pop(int i) {
		stack.subList(stack.size()-i, stack.size()).clear();
		return stack.get(stack.size()-1);
	}
	
	public ViewHandler reset() {
		stack.subList(1, stack.size()).clear();
		return stack.get(0);
	}
}
