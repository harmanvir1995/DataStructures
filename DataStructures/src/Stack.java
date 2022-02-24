
public interface Stack<E> {
	//Size of the Stack
	int size();
	
	//Tells whether the Stack is empty or not
	boolean isEmpty();
	
	//Returns the element at the top of the Stack.
	//Recently added element in the stack.
	E top();
	
	//Removes the element on the top or recently added 
	//element in the stock.
	E pop();
	
	//Adds element in the stock.
	void push(E e);
}
