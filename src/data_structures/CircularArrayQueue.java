package data_structures;

import java.util.NoSuchElementException;

import interfaces.Queue;
/**
 * Implementation if the Queue using a circular array. This is just an array that we have 2 indexes to and
 * treat as if it we a circular object (position 0 and length-1 are connected). This is simulated by simply going
 * back to 0 after we reach index lenght-1. We can get this behavior using modulo.
 * 
 * The idea here is to use 2 indexes one to keep track of the oldest item in the queue and another to know 
 * where the queue ends, similar to the tail or trailer node.
 * @author Gretchen Bonilla
 *
 * @param <E>
 */
public class CircularArrayQueue<E> implements Queue<E>{

	private E[] theData;
	private int front, rear, size;
	private final int DEFAULT = 15;
	
	public CircularArrayQueue() {
		this.theData = (E[]) new Object[DEFAULT];
		this.front = 0;
		this.rear = DEFAULT-1;
		this.size = 0;
	}
	public CircularArrayQueue(int initialCapacity) {
		this.theData = (E[]) new Object[initialCapacity];
		this.front = 0;
		this.rear = initialCapacity-1;
		this.size = 0;
	}
	/**
	 * Returns the number of elements currently in the Array
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * Expands the size of elements. 
	 * It create an new array twice the length of the current elements array and places all the existing 
	 * elements in it. This new array then replaces the old elements array.
	 */
	private void reallocate() {
		// New array that's double the capacity
		E[] newArray = (E[]) new Object[this.theData.length*2];
		// This will help keep track of where the values go in the new list
		int j = front;
		// Pass all the elements to the new array
		for(int i=0; i < this.theData.length; i++) {
			newArray[i] = this.theData[j];
			j = (j + 1)%this.theData.length;
		}
		this.front = 0;
		this.rear = this.size - 1;
		// Elements is now the new array
		this.theData= newArray;
		
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			dequeue();
	}

	/**
	 * Inserts a new item in the Queue. In this case this is added at the end of the queue
	 * represented by rear+1.
	 */
	@Override
	public void enqueue(E obj) {
		if(obj == null)
			throw new IllegalArgumentException();
		if(this.theData.length == size)
			reallocate();
		/* length of array is the same as capacity
		* This moves rear to the next available position, by using %capacity we are 
		* restricting the index to a value between 0 and length - 1.
		*/ 
		this.rear = (this.rear + 1)% this.theData.length;
		this.theData[rear] = obj;
		size++;
	}

	/**
	 * We remove the oldest item from the Queue.This means that we remove the item at position front.
	 */
	@Override
	public E dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();
		E frontValue = this.theData[front];
		this.theData[front] = null;
		this.front = (this.front + 1)%this.theData.length;
		size--;
		return frontValue;
	}

	@Override
	public E front() {
		if(isEmpty())
			throw new NoSuchElementException();
		return this.theData[this.front];
	}
	
}
