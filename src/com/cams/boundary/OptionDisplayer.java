package boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionDisplayer {
	private int optionCount = 0;
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = new ArrayList<String>();
	
	public final int MAX_SELECTION_TRIES=3;

	public OptionDisplayer(String prompt) {
		System.out.println(prompt);
	}
	
	public OptionDisplayer(String prompt, String... options) {
		this(prompt);
		for (String option: options) displayOption(option);
	}
	
	public void displayOption(String option) {
		System.out.printf("[%d]: %s\n", ++optionCount, option);
		options.add(option);
	}
	
	public String getResponse() {
		while (true) {
			try {
				int selection = scanner.nextInt();
				if (selection <= options.size() && selection>1)
					return options.get(selection-1);
			} catch (Exception e) {}
			System.out.printf("Please enter a valid option! [1-%d]", options.size());
		}
	}
	
	@Override
	public void finalize() {
		scanner.close();
	}
}
