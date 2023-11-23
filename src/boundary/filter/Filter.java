package boundary.filter;

import java.util.Collection;
import java.util.List;

public class Filter<T> {
	
	private List<FilterParameter<T>> parameters;
	
	public void addFilter(FilterParameter<T> parameter) {
		parameters.add(parameter);
	}
	
	public List<T> isValid(Collection<T> items) {
		return items.stream().filter(item -> isValid(item)).toList();
	}
	
	public boolean isValid(T obj) {
		for (FilterParameter<T> parameter: parameters)
			if (!parameter.isValid(obj)) return false;
		return true;
	}
}
