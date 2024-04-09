package interfaces;

public interface Set<E> extends Iterable<E> {
	public boolean add(E obj);
	public boolean isMember(E obj);	
	public boolean remove(E obj);
	public boolean isEmpty();
	public int size();
	public void clear();
	public Set<E> union(Set<E> S2);
	public Set<E> difference(Set<E> S2);
	public Set<E> intersection(Set<E> S2);
	public boolean isSubset(Set<E> S2);
}