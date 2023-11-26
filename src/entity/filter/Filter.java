package entity.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.NameComparator;
import entity.Nameable;
import main.Context;

public class Filter<T extends Nameable> {

	private List<FilterParameter<?>> parameters = new ArrayList<>();
	/*
	 * Adds a filter parameter.
	 * 
	 * @param parameter The filter parameter to be added.
	 */

	public void addFilter(FilterParameter<?> parameter) {
		for (int i = 0; i < parameters.size(); i++)
			if (parameters.get(i).getClass().equals(parameter.getClass())) {
				parameters.set(i, parameter);
				return;
			}
		parameters.add(parameter);
	}
	/*
	 * Removes a filter parameter.
	 * 
	 * @param c The class of the filter parameter to be removed.
	 * 
	 * @return True if the filter parameter is removed, false otherwise.
	 */

	public boolean removeFilter(Class<FilterParameter<?>> c) {
		for (int i = 0; i < parameters.size(); i++)
			if (parameters.get(i).getClass().equals(c)) {
				parameters.remove(i);
				return true;
			}
		return false;
	}
	/*
	 * Gets the valid objects.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param items The items to be used.
	 * 
	 * @return The valid objects.
	 */

	public List<T> getValid(Context context, Collection<T> items) throws ClassNotFoundException, IOException {
		List<T> res = new ArrayList<>();
		for (T i : items)
			if (isValid(context, i))
				res.add(i);
		res.sort(new NameComparator());
		return res;
	}
	/*
	 * Gets the filter parameters.
	 * 
	 * @return The filter parameters.
	 */

	public List<FilterParameter<?>> getParameters() {
		return parameters;
	}
	/*
	 * Checks if the object is valid.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param obj The object to be used.
	 * 
	 * @return True if the object is valid, false otherwise.
	 */

	@SuppressWarnings("unchecked")
	public boolean isValid(Context context, T obj) throws ClassNotFoundException, IOException {
		for (FilterParameter<?> parameter : parameters)
			if (!((FilterParameter<T>) parameter).isValid(context, obj))
				return false;
		return true;
	}
}
