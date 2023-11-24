package boundary.filter;

import java.util.Collection;
import java.util.List;

public abstract class FilterParameter <T> {
	public abstract boolean isValid(T obj);
	
	public List<T> doFilter(Collection<T> list) {
		return list.stream().filter(i -> isValid(i)).toList();
	}
}
