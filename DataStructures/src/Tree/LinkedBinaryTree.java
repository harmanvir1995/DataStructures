package Tree;
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
	
	/** Returns true if tree is empty else it returns false */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	/**
	 * returns the root of the tree
	 * @return
	 */
	public Position<E> root(){
		return root;
	}
	
	/** Returns true if it is the internal node and false is its the external node */
	public boolean isInternal(Position<E> p) {
		Node<E> node = validate(p);
		if(node.getRight() != null || node.getLeft() != null) {
			return true;
		}
		return false;
	}
	
	/** Returns true if it is the external node and false is its the internal node */
	public boolean isExternal(Position<E> p) {
		Node<E> node = validate(p);
		if(node.getRight() == null && node.getLeft() == null) {
			return true;
		}
		return false;
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
	public Position<E> addRoot(E e) throws IllegalStateException{
		if(!isEmpty()) {
			throw new IllegalStateException("Tree is already build up using the root.");
		}
		Node<E> root = new Node<E>(e, null, null, null);
		size = 1;
		return root;
	}
	
	/** This returns ans sets the lefty child of the p*/ 
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getLeft() != null) {
			throw new IllegalArgumentException("Parent already has a left chil");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	/** This sets and returns the right child of the parent p. */ 
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getRight() != null) {
			throw new IllegalArgumentException("Parent p already has the right child");
		}
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	/** Replaces the element at position p with the element e and returns the replaced element.*/
	public E replace(Position<E> p, E e) throws IllegalArgumentException{
		E temp = p.getElement();
		Node<E> node = validate(p);
		node.setElement(e);
		return temp;
	}
	
	/** Attaches trees t1 and t2 to the external node of p */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(isInternal(node)) {
			throw new IllegalArgumentException("p is an internal node.");
		}
		size = size + t1.size() + t2.size();
		if(!t1.isEmpty()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmpty()) {
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.size =0;
			t2.root = null;
		}
	}
	
	/** Returns the number of children of the Position p. */ 
	public int numChildren(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(node.getLeft() != null && node.getRight()!= null) {
			return 2;
		}
		if(node.getLeft() != null || node.getRight()!= null) {
			return 1;
		}
		return 0;
	}
	
	/** Removes the node at Position p and replaces it with its child */
	public E remove(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(numChildren(p) == 2) {
			throw new IllegalArgumentException("p already has 2 Children.");
		}
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if(child != null) {
			child.setParent(node.getParent());
		}
		if(node == root) {
			child = root;
		}
		else {
			Node<E> parent = node.getParent();
			if(node == parent.getLeft()) {
				parent.setLeft(child);
			}
			else {
				parent.setRight(child);
			}
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setRight(null);
		node.setLeft(null);
		node.setParent(node);
		return temp;
	}
	
	/** This method returns Element e  */
	@Override
	public E getElement() throws IllegalStateException {
		System.out.println("Element from LinkedBinaryTree Class @Overridenz");
		return null;
	}
}
//-----------------------End of LinkedBinaryTree class--------------------------//
