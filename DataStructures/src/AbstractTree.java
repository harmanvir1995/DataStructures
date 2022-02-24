
public abstract class AbstractTree<E> implements Tree<E> {
	/** Boolean for is internal Node of the tree **/
	public boolean isInternal(Position<E> p) {
		return numChildren(p) >0;
	}
	
	/** Boolean for the external node of the tree  **/
	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}
	
	/** Boolean to verify the root of the tree **/
	public boolean isRoot(Position<E> p) {
		return p == root();
	}
	
	/** Boolean to verify if the tree is empty or not. **/
	public boolean isEmpty() {
		return size() == 0;
	}
}
