package boundary.display;

import boundary.IO;
import main.Context;

public abstract class Displayer {
	protected final IO io;
	protected final Context context;
	
	public Displayer(IO io, Context context) {
		this.io = io;
		this.context = context;
	}
	
	public Displayer(Context context) {
		this.context = context;
		this.io = context;
	}
	
	abstract void display() throws Exception;
}
