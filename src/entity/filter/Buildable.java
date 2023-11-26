package entity.filter;

import main.Context;
/*
 * Buildable is an interface that is used to build objects.
 */

public interface Buildable {
	public void build(Context context) throws Exception;
}
