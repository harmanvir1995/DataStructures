import java.util.ArrayList;

public class GeeksForGeek {
	public class Node {
		int data;
		Node left;
		Node right;
		Node() {}
		Node(int data) { this.data = data; }
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return this.data +"";
		}
	}
	
	/**
	 * Function to return the diameter of a Binary Tree.
	 * @param root
	 * @return
	 */
	// Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, 
                        Math.max(leftDiameter, rightDiameter)); 
    }
    
   
	
	/**
	 * Function to find the height of a binary tree.
	 * @param node
	 * @return
	 */
	 //Function to find the height of a binary tree.
    int height(Node node){
        if(node == null){
            return 0;
        }
        int leftheight = height(node.left) + 1;
        int rightheight = height(node.right) + 1;
        if(leftheight > rightheight){
            return leftheight;
        }
        else{
            return rightheight;
        }
    }
	
	/**
	 * Prints the left view of the tree.
	 */
	 //Function to return list containing elements of left view of binary tree.
	 int maxlevel = 0;
	    //Function to return list containing elements of left view of binary tree.
	    ArrayList<Integer> leftView(Node root)
	    {
	      // Your code here
	      ArrayList<Integer> alist = new ArrayList<>();
	      return leftViewHelper(alist, root, 1);
	    }
	    
	    //Helper
	    ArrayList<Integer> leftViewHelper(ArrayList<Integer> alist, Node node, int level){
	        //Base case
	        if(node == null){
	            return alist;
	        }
	        //
	        if(maxlevel < level){
	            alist.add(node.data);
	            maxlevel = level;
	        }
	        
	        leftViewHelper(alist, node.left, level+1);
	        leftViewHelper(alist, node.right, level+1);
	        return alist;
	    }
	
	

	/**
	 * Function to check whether a Binary Tree is BST or not.
	 * 
	 * @param root
	 * @return
	 */
	boolean isBST(Node root)
	{
		// code here.
		return isBSThelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE );
	}
	//Helper Method for isBST
	boolean isBSThelper( Node node, int min, int max){
		//base case
		if(node == null){
			return true;
		}   
		//When data is out of range
		if(node.data <= min || node.data >= max){
			return false;
		}
		//When data is in range then recursive call
		return isBSThelper(node.left, min, node.data) && isBSThelper(node.right, node.data, max); 
	}
}
