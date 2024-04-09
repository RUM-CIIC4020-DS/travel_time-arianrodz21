package data_structures;

import java.util.NoSuchElementException;

import interfaces.List;
import interfaces.Stack;
/**
 * A Stack implementation that uses an ArrayList internally to store the data of the Stack.
 * We take advantage of the List behaviour to implent the neccesary methods
 * @author Gretchen Bonilla
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {


	// Will hold the data of the Stack
	// We use a SinglyLinkedLIst
	private List<E> theData;

	public LinkedListStack() {
		this.theData = new SinglyLinkedList<E>();
	}

	/**
	 * Checks whether the internal LinkedList is empty to determine of the Stack is empty.
	 * @return Whether Stack is empty
	 */
	@Override
	public boolean isEmpty() {

		return this.theData.isEmpty();
	}

	/**
	 * Checks the size of the internal LinkedList to determine the Stacks size
	 * @return size of Stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.theData.size();
	}

	/**
	 * Returns the top value in the Stack. This is represented by the position 0 
	 * in the LinkedList. This is the most efficient position.
	 */
	@Override
	public E top() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		return this.theData.get(0);
	}

	/**
	 * Removes and returns the top value i the Stack. This is the value
	 * at position 0 in the LinkedList
	 */
	@Override
	public E pop() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		E top = this.theData.get(0);
		this.theData.remove(0);
		return top;
	}

	/**
	 * Adds a value to Stack. This is done by adding at the first position in the LinkedList. 
	 */
	@Override
	public void push(E obj) {
		if(obj == null)
			throw new IllegalArgumentException();
		this.theData.add(0, obj);

	}

	/**
	 * Remove everything from the Stack. This is done by calling the ArrayLists clear method.
	 * This is more efficient than in the ArrayListStack implementation. Why?
	 */
	@Override
	public void clear() {
		this.theData.clear();

	}
}
