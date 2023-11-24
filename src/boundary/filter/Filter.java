package boundary.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.Context;
import model.interfaces.NameComparator;
import model.interfaces.Nameable;

public class Filter<T extends Nameable> {
	
	private List<FilterParameter<?>> parameters = new ArrayList<>();
	
	public void addFilter(FilterParameter<?> parameter) {
		for (int i=0;i<parameters.size();i++)
			if (parameters.get(i).getClass().equals(parameter.getClass())) {
				parameters.set(i, parameter);
				return;
			}
		parameters.add(parameter);
	}
	
	public boolean removeFilter(Class<FilterParameter<?>> c) {
		for (int i=0;i<parameters.size();i++)
			if (parameters.get(i).getClass().equals(c)) {
				parameters.remove(i);
				return true;
			}
		return false;
	}
	
	public List<T> getValid(Context context, Collection<T> items) throws ClassNotFoundException, IOException {
		List<T> res = new ArrayList<>();
		for (T i: items) if (isValid(context, i))
			res.add(i);
		res.sort(new NameComparator());
		return res;
	}
	
	public List<FilterParameter<?>> getParameters() {
		return parameters;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isValid(Context context, T obj) throws ClassNotFoundException, IOException {
		for (FilterParameter<?> parameter: parameters)
			if (!((FilterParameter<T>) parameter).isValid(context, obj)) return false;
		return true;
	}
}
