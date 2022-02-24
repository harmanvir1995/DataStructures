
public interface Queue <E> {
	//Return the size of the queue.
	int size();
	
	//This return the boolean for the presence of elements in the list.
	boolean isEmpty();
	
	//Returns the first element of the Queue.
	E first();
	
	//Returns and removes the first element of the Queue.
	E dequeue();
	
	//Adds element to the last of the Queue.
	void enqueue(E e);
}

