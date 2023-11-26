package boundary.display;

import java.io.IOException;

import boundary.IO;
import main.Context;
import model.Query;
/*
 * Displayer is a class that is used to display objects.
 */

public class QueryDisplayer extends Displayer {
	private final Query query;
	/*
	 * Constructor for QueryDisplayer.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param query The query to be used.
	 */

	public QueryDisplayer(Context context, Query query) {
		super(context);
		this.query = query;
	}
	/*
	 * Constructor for QueryDisplayer.
	 * 
	 * @param io The IO to be used.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param query The query to be used.
	 */

	public QueryDisplayer(IO io, Context context, Query query) {
		super(io, context);
		this.query = query;
	}
	/*
	 * Displays the query.
	 * 
	 * @throws Exception
	 */

	public void display() throws IOException {
		io.print("Title:");
		io.print(query.getTitle());
		io.print("Description:");
		io.print(query.getDescription());
		io.print("Reply:");
		io.print(query.getReply());
	}
}
