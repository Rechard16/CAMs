package boundary;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import main.Context;

public class OptionDisplayer {
	private final List<Action> options = new ArrayList<Action>();
	private final Context context;
	private int optionCount = 0;
	
	public final int MAX_SELECTION_TRIES=3;

	public OptionDisplayer(Context context, String prompt) {
		this.context = context;
		context.lineBreak();
		context.print(prompt);
	}
	
	public OptionDisplayer(Context context, String prompt, Action... options) {
		this(context, prompt);
		for (Action option: options) displayOption(option);
	}
	
	public void displayOption(Action option) {
		context.print("[%d]: %s\n", ++optionCount, option.getDescription());
		options.add(option);
	}
	
	public Action getResponse() {
		while (true) {
			try {
				int selection = Integer.parseInt(context.getScanner().nextLine());
				selection = Math.min(selection, options.size());
				if (selection>0) {
					context.lineBreak();
					return options.get(selection-1);
				}
			} catch (Exception e) {}
			context.print("Please enter a valid option! [1-%d]", options.size());
		}
	}
}
