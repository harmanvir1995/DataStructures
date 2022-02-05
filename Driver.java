
public class Driver {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertFirst(10);
		l.display();
		System.out.println();
		l.insertFirst(20);
		l.display();
		System.out.println();
		l.insertLast(50);
		l.display();
		System.out.println();
		System.out.println(l.size());
		l.insertFirst(70);
		l.display();
		System.out.println();
		l.insertFirst(90);
		l.display();
		System.out.println();
		System.out.println(l.get(4)); 
		System.out.println();
		l.insertFirst(120);
		l.display();System.out.println();
		l.insertFirst(200);
		l.display();System.out.println();
		l.insertFirst(250);
		l.display();
		System.out.println();
		System.out.println(l.size());
		System.out.println();
		l.remove(8);
		l.display();
	}

}
