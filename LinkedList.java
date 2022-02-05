
public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.size =0;
		head = null;
		tail = null;
	}
	
	public Node get(int target) {
		Node node = head;
		for(int i=1; i<target; i++) {
			node =node.next;
		}
		return node;
	}
	
	public void insertFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
		if(tail==null) {
			tail = node;
		}
	}
	
	public void insertLast(int data) {
		Node node = new Node(data);
		tail.next = node;
		tail = node;
		tail.next = null;
		size++;
	}
	
	public boolean removeFirst() {
		if(head!=null) {
			head = head.next;
			size--;
			return true;
		}
		return false;
	}
	
	public void removeLast() {
		Node temp = head;
		Node secondLast = get(size-1);
		secondLast.next = null;
		tail = secondLast;
		size--;
	}
	
	public void remove(int target) {
		if(target==1) {
			removeFirst();
		}
		Node beforeTarget = get(target-1);
		Node afterTarget = beforeTarget.next.next;
		beforeTarget.next = afterTarget;
		size--;
		
	}
	
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp + " -> ");
			temp = temp.next;
		}
	}
	
	public int size() {
		return size;
	}
	
	
	
	
	
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
