package boundary.filter;

public interface FilterParameter <T> {
	public boolean isValid(T obj);
}
