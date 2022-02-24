
public class Driver {

	public static void main(String[] args) {
		Stack<Integer> st = null;
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		printStack(st);
	}
	
	static void printStack(Stack<Integer> st) {
		while(!st.isEmpty()) {
			System.out.print(st.pop() + "--> ");
		}
	}
	public static void reverseStack(Stack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		int x = st.pop();
		reverseStack(st);
		st.push(x);
	}
	
	public static void reverse(int number) {
		System.out.print(number%10);
		if(number/10 == 0) {
			return;
		}
		reverse(number/10);
		//System.out.println("========================");
		//System.out.print(number%10);
	}

}
