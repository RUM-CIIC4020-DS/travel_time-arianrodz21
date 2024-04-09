package data_structures;

import java.util.Iterator;

import interfaces.List;
import interfaces.Map;
import interfaces.Set;

public class HashSet<E> implements Set<E> {
	//Private Fields
	private Map<E, Object> hashtable;
	private static final int DEFAULT_SET_SIZE = 10;
	
	/*Constructs an empty HashSet with a given initial capacity*/
	public HashSet(int initialCapacity) {
		hashtable = new HashTableSC<E, Object>(initialCapacity, new SimpleHashFunction<E>());
	}
	
	/*Constructs an empty HashSet with a default initial capacity of ten*/
	public HashSet() {
		hashtable = new HashTableSC<E, Object>(DEFAULT_SET_SIZE, new SimpleHashFunction<E>());
	}
	@Override
	public Iterator<E> iterator() {
		return hashtable.getKeys().iterator();
	}

	/**
	 * Takes a given object that is not already in the set 
	 * and adds it to the HashSet according to the hashCode generated for the object
	 * 
	 * @param obj - Object to be added to set
	 * @return true or false, depending if the object was added to the set
	 */
	@Override
	public boolean add(E obj) {
		if(isMember(obj)) return false;
		hashtable.put(obj, new Object()); //We put as parameter for value a dummy object
		return true;
	}
	
	/**
	 * Returns true if the given object is a member (is included) of the HashSet
	 * @param obj - object to verify if is in set
	 */
	@Override
	public boolean isMember(E obj) {
		return hashtable.containsKey(obj);
	}

	/**
	 * Removes a given object from the set and returns true if the object was actually removed or not
	 * @param obj - object to remove
	 */
	@Override
	public boolean remove(E obj) {
		return hashtable.remove(obj) != null;
 	}

	
	/**
	 * Checks to see if set is empty
	 * @return true or false if the set is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return hashtable.isEmpty();
	}

	/**
	 * @return size of HashSet
	 */
	@Override
	public int size() {
		return hashtable.size();
	}

	/**
	 * Removes everything from HashSet until it is empty
	 */
	@Override
	public void clear() {
		hashtable.clear();
	}

	/**
	 * Returns a set with the all the elements from the target set and a given S2 combined
	 * @param S2 - the second set
	 * @return S3 - The set with the combined elements from the target set and S2
	 */
	@Override
	public Set<E> union(Set<E> S2) {
		Set<E> result = new HashSet<E>(this.size() + S2.size());
		for(E elm : this) result.add(elm);	
		for (E elm : S2) result.add(elm);
		return result;
	}

	/**
	 * Returns a set with the non-common elements from the target set and a given S2
	 * @param S2 - the second set
	 * @return S3 - The set with the non-common elements from the target set and S2
	 */
	@Override
	public Set<E> difference(Set<E> S2) {
		Set<E> result = new HashSet<E>();
		for(E elm : this) {
			if (!S2.isMember(elm)) {
				result.add(elm);
			}
		}
		return result;	
	}

	/**
	 * Returns a set with the common elements from the target set and a given S2
	 * @param S2 - the second set
	 * @return S3 - The set with the common elements from the target set and S2
	 */
	@Override
	public Set<E> intersection(Set<E> S2) {
		Set<E> S3 = new HashSet<>();
		for (E e : this) if(S2.isMember(e)) S3.add(e);
		return S3;
	}

	/**
	 * Returns true if S2 is a subset of the target set, otherwise it returns false
	 * @param S2 - the set to compare with 
	 */
	@Override
	public boolean isSubset(Set<E> S2) {
		List<E> elements = this.hashtable.getKeys();
		for (int i=0; i < this.size(); ++i) {
			if (!S2.isMember(elements.get(i))) {
				return false;
			}
		}
		return true;
	}
	
}
