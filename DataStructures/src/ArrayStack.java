
public class ArrayStack<E> implements Stack<E>{
	private static final int CAPACITY = 100;
	//As this Stack implements the array based stack.
	private E data[];
	//tail to keep track of the last placed filled
	private int tail = -1;
	
	//Constructor with default capacity of 100
	public ArrayStack() {
		 data = (E[]) new Object[CAPACITY];
	}
	
	//Constructor with the desired capacity.
	public ArrayStack(int capacity) {
		data = (E[])new Object[capacity];
	}
	
	//Returns boolean if the array is empty.
	public boolean isEmpty() {
		if(tail==-1) {
			return true;
		}
		return false;
	}
	
	//Returns the last element added to the stack.
	public E top() {
		if(isEmpty()) {
			System.out.println("Stack is Empty.");
			return null;
		}
		return data[tail];
	}
	
	//Returns the Size of the Stack
	public int size() {
		if(isEmpty()) {
			return -1;
		}
		return tail+1;
	}
	
	//Adds element to the Stack
	public void push(E newEntry) {
		if(size()==CAPACITY) {
			System.out.println("Element cannot be added, as stack is full...");
			return;
		}
		data[++tail] = newEntry;
	}
	
	//Deletes last added element from the Stack.
	public E pop() {
		if(size()==0) {
			System.out.println("Stack already empty.");
			return null;
		}
		E popValue = data[tail];
		data[tail] = null;
		tail--;
		return popValue;
	}
	
	//Reversing the array using stack
		public static <E> void reverseArray(E data[]) {
			Stack<E> newArray = new ArrayStack<>(data.length);
			for(int i=0; i<data.length ;i++) {
				newArray.push(data[i]);
			}
			for(int i=0; i<data.length ;i++) {
				data[i] = newArray.pop();
			}
		}
}













