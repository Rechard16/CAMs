package entity.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Nameable;
import main.Context;

public abstract class FilterParameter<T> implements Buildable, Nameable {
	public abstract boolean isValid(Context context, T obj) throws ClassNotFoundException, IOException;

	/*
	 * Filters a list.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param list The list to be filtered.
	 * 
	 * @return The filtered list.
	 */

	public List<T> doFilter(Context context, Collection<T> list) throws ClassNotFoundException, IOException {
		List<T> res = new ArrayList<>();
		for (T i : list)
			if (isValid(context, i))
				res.add(i);
		return res;
	}
}
