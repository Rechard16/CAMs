package boundary.display;

import java.io.IOException;

import boundary.IO;
import main.Context;
import model.Query;

public class QueryDisplayer extends Displayer {
	private final Query query;
	
	public QueryDisplayer(Context context, Query query) {
		super(context);
		this.query = query;
	}
	
	public QueryDisplayer(IO io, Context context, Query query) {
		super(io, context);
		this.query = query;
	}

	public void display() throws IOException {
		io.print("Title:");
		io.print(query.getTitle());
		io.print("Description:");
		io.print(query.getDescription());
		io.print("Reply:");
		io.print(query.getReply());
	}
}
