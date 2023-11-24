package boundary.util;

import main.Context;
import model.Query;

public class QueryDisplayer {
	private final Query query;
	private final Context context;
	
	public QueryDisplayer(Context context, Query query) {
		this.query = query;
		this.context = context;
	}
	
	public void display() {
		context.print("Title:");
		context.print(query.getTitle());
		context.print("Description:");
		context.print(query.getDescription());
		context.print("Reply:");
		context.print(query.getReply());
	}
}
