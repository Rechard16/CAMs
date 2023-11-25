package boundary.display;

import boundary.IO;
import main.Context;
/*
 * Displayer is a class that is used to display objects.
 */

public abstract class Displayer {
	protected final IO io;
	protected final Context context;
	/*
	 * Constructor for Displayer.
	 * 
	 * @param io The IO to be used.
	 * 
	 * @param context The context to be used.
	 */

	public Displayer(IO io, Context context) {
		this.io = io;
		this.context = context;
	}
	/*
	 * Constructor for Displayer.
	 * 
	 * @param context The context to be used.
	 */

	public Displayer(Context context) {
		this.context = context;
		this.io = context;
	}
	/*
	 * Displays the object.
	 * 
	 * @throws Exception
	 */

	abstract void display() throws Exception;
}
