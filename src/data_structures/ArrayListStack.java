package data_structures;

import java.util.NoSuchElementException;

import interfaces.Stack;

/**
 * A Stack implementation that uses an ArrayList internally to store the data of the Stack.
 * We take advantage of the List behaviour to implent the neccesary methods
 * @author Gretchen Bonilla
 *
 * @param <E>
 */
public class ArrayListStack<E> implements Stack<E>{
	
	// Will hold the data of the Stack
	private ArrayList<E> theData;

	public ArrayListStack() {
		this.theData = new ArrayList<E>();
	}

	public ArrayListStack(int initialCapacity) {
		this.theData = new ArrayList<>(initialCapacity);
	}
	/**
	 * Checks whether the internal ArrayList is empty to determine of the Stack is empty.
	 * @return Whether Stack is empty
	 */
	@Override
	public boolean isEmpty() {
		
		return this.theData.isEmpty();
	}

	/**
	 * Checks the size of the internal ArrayList to determine the Stacks size
	 * @return size of Stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.theData.size();
	}

	/**
	 * Returns the top value in the Stack. This is represented by the position (size-1) 
	 * in the ArrayList. This is the most efficient position.
	 */
	@Override
	public E top() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		return this.theData.get(this.size() - 1);
	}

	/**
	 * Removes and returns the top value i the Stack. This is the value
	 * at position (size-1) in the ArrayList
	 */
	@Override
	public E pop() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		E top = this.theData.get(this.size()-1);
		this.theData.remove(this.size()-1);
		return top;
	}

	/**
	 * Adds a value to Stack. This is done by appending the value at the end of the ArrayList. 
	 */
	@Override
	public void push(E obj) {
		if(obj == null)
			throw new IllegalArgumentException();
		this.theData.add(obj);
		
	}

	/**
	 * Remove everything from the Stack. This is done by calling the ArrayLists clear method.
	 */
	@Override
	public void clear() {
		this.theData.clear();
		
	}
}
