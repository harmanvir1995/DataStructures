/** Concrete implementation of the Binary Tree using Node based Linked Structure   **/
public class LinkedBinaryTree<E> implements Position<E> {

	//----------nested Node Class----------------------
	protected static class Node<E> implements Position<E>{
		private E element;			//an element stored at this node
		private Node<E> parent;		//a reference to the parent
		private Node<E> left;		//a reference to the left child
		private Node<E> right;		//a reference to the right child
		
		/** Constructs the node with given element and neighbors **/
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		/** Returns element **/
		@Override
		public E getElement() {
			return element;
		}
		
		/**
		 * gets the parent 
		 * @return
		 */
		public Node<E> getParent(){
			return parent;
		}
		
		/**
		 * Gets the Left element
		 * @return
		 */
		public Node<E> getLeft(){
			return left;
		}
		
		/**
		 * Gets the right name
		 * @return
		 */
		public Node<E> getRight(){
			return right;
		}
		
		/**
		 * Set the element
		 * @param e
		 */
		public void setElement(E e) {
			element = e;
		}
		
		/**
		 * set the parent
		 * @param parentNode
		 */
		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}
		
		/**
		 * Sets the left child
		 * @param leftChild
		 */
		public void setLeft(Node<E> leftChild) {
			left = leftChild;
		}
		
		/**
		 * Sets the right child
		 * @param rightChild
		 */
		public void setRight(Node<E> rightChild) {
			right = rightChild;
		}
	}
	//----------End of nested Node Class----------------------
	
	/** Factory function to create a new node storing element **/
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	//LinkedBinaryTree instance variable
	protected Node<E> root = null;
	private int size = 0;
	
	//Constructor 
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}
	
	//non public utility
	/** Validates the position and returns it as a node. */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		Node<E> node = (Node<E>)p;		//safe cast
		if(node.getParent() == node) {
			throw new IllegalArgumentException("p is no longer in th tree");
		}
		return node;
	}
	
	/**
	 * Returns the number of trees
	 */
	public int size() {
		return size;
	}
	
	/**
	 * returns the root of the tree
	 * @return
	 */
	public Position<E> root(){
		return root;
	}
	
	/**
	 * Returns the Position of p's parent (or null if p is root)
	 * @param p
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Position<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	/** Returns the Position of p's left child (or null if no child exists). */
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	/** Returns the Position of p's right child (or null if no child exists). */
	public Position<E> right(Position<E> p){
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	// update methods supported by this class
	/** Places element e at the root of an empty tree and returns its new Position. */
	public Position<E> addRoot(E e){
		if(!isEmpty()) {
			
		}
	}
	@Override
	public E getElement() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

}
