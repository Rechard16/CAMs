package boundary;

import java.util.ArrayList;
import java.util.List;

import boundary.action.Action;
import main.Context;

/**
 * OptionDisplayer is a class that is used to display options to the user.
 */

public class OptionDisplayer {
	private final List<Action> options = new ArrayList<Action>();
	private final Context context;

	/*
	 * The number of options that have been displayed.
	 */
	private int optionCount = 0;

	/*
	 * The maximum number of times a user can try to select an option.
	 */

	public final int MAX_SELECTION_TRIES = 3;

	/*
	 * Constructor for OptionDisplayer.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param prompt The prompt to be displayed.
	 */

	public OptionDisplayer(Context context, String prompt) {
		this.context = context;
		context.lineBreak();
		context.print(prompt);
	}

	/*
	 * Constructor for OptionDisplayer.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param prompt The prompt to be displayed.
	 * 
	 * @param options The options to be displayed.
	 */

	public OptionDisplayer(Context context, String prompt, Action... options) {
		this(context, prompt);
		for (Action option : options)
			displayOption(option);
	}

	/*
	 * Displays an option.
	 * 
	 * @param option The option to be displayed.
	 */

	public void displayOption(Action option) {
		context.print("[%d]: %s\n", ++optionCount, option.getDescription());
		options.add(option);
	}

	/*
	 * Gets the user's response.
	 * 
	 * @return The user's response.
	 */

	public Action getResponse() {
		while (true) {
			try {
				int selection = Integer.parseInt(context.getScanner().nextLine());
				selection = Math.min(selection, options.size());
				if (selection > 0) {
					context.lineBreak();
					return options.get(selection - 1);
				}
			} catch (Exception e) {
			}
			context.print("Please enter a valid option! [1-%d]", options.size());
		}
	}
}
