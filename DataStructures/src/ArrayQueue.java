/**
 * 
 * @author Harmanvir
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	private E data[];
	private int f = 0;
	private int size = 0;
	
	//Returns the size of the Queue
	public int size() {
		return size;
	}
	
	//Returns boolean true if queue is empty.
	public boolean isEmpty() {
		if(size() != 0) {
			return false;
		}
		return true;
	}
	
	//Returns the first element of the queue.
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return data[f];
	}
	
	//Adds element to the end of the list.
	public void enqueue(E e) throws IllegalStateException {
		if(size() == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int available = (f+size)%data.length;
		data[available] = e;
		size++;
	}
	
	//Returns the first element in the queue.
	public E dequeue() {
		if(isEmpty()) {
			return null;
		}
		E result = data[f];
		f = (f+1)%data.length;
		size--;
		return result;
	}
	
	
}
