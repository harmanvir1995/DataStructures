

public class SinglyLinkedList {
	private int size;
	private Node head;
	private Node tail;
	
	//Size
	public int size() {
		return size;
	}
	
	//Constructor
	public SinglyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	//Adding element at the front.
	public void addFirst(int newData) {
		Node newNode = new Node(newData);
		if(head == null && tail == null) {
			head = newNode;
			tail = newNode;
			newNode.next = null;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	//Adding element at last
	public void addLast(int newData) {
		Node newNode = new Node(newData);
		if(tail != null) {
			tail.next = newNode;
			tail = newNode;
		}
		else {
			head = newNode;
			tail = newNode;
		}
		size++;
	}
	
	//Insert the element to the list.
	public void add(int index, int newData) {
		Node newNode = new Node(newData);
		if(index == 0) {
			addFirst(newData);
			return;
		}
		if(index == size-1) {
			addLast(newData);
			return;
		}
		Node prev = head;
		for(int i=0; i<index-1; i++) {
			prev = prev.next;
		}
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}
	
	//Returns the element at the specific index.
	public int get(int index) {
		if(index<0 || index> size-1) {
			System.out.println("Index Out of Bound...!!");
			return 0;
		}
		if(index==0) {
			return getFirst();
		}
		if(index == size-1) {
			return getLast();
		}
		Node temp = head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	//Returns first element.
	public int getFirst() {
		return head.data;
	}
	
	//Returns last element.
	public int getLast() {
		return tail.data;
	}
	
	//Display the List
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//Private Inner Class which is Node contains
	//Data and the next element.
	private class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public String toString() {
			return this.data+"";
		}
	}
}
