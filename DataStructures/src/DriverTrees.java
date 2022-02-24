
public class DriverTrees {
	/**
	 * Height of the node p
	 * @param <E>
	 */
	public static <E> int depth(Position<E> p) {
		if(isRoot(p)) {
			return 0;
		}
		return 1 + depth(parent(p));
	}
}
