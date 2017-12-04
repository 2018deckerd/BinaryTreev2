/*
 * This class defines a binary tree data structure along with utility methods
 * to make it useful.
 */
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/*
	 * Methods to insert a new node into the tree.
	 * 
	 * insertNode inserts a new node into the subtree with root
	 * node topNode and returns the new tree structure back with the
	 * same root node.
	 * 
	 * insert is the public interface to the subtreeInsert method and will
	 * be the method actually invoked by the calling program.  Methods like
	 * it are often called "wrapper" methods because they "wrap" the private
	 * methods that do all of the work in a more convenient interface.
	 */
	public void insert(String newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, String newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (topNode.record.compareTo(newRecord) > 0) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	
	/*
	 * Methods to perform an in-order tree traversal.
	 * 
	 * The inOrderSubtree method does all of the work, with inOrder
	 * serving as a wrapper method (see above).
	 */
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a pre-order traversal.
	 */
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a post-order traversal.
	 */
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {	
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	
	/*
	 * Methods to calculate the size (number of nodes) in a tree.
	 */
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			return subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1;
		}
	
	}
	
	
	/*
	 * Methods to calculate the maximum depth of a tree.
	 */
	
	public String maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private String subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return null;
		} else {
			if (((subtreeMaxDepth(topNode.left) + 1).compareTo(subtreeMaxDepth(topNode.right) + 1)) < 0) {
				return subtreeMaxDepth(topNode.right) + 1;
		}	else {
				return subtreeMaxDepth(topNode.left) + 1;
		}
	 }
	}
	
	/*
	 * Methods to calculate the minimum depth of a tree.
	 */
	
	public String minDepth() {
		return subtreeMinDepth(root);
	}
	
	private String subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return null;
		} else {
			if (((subtreeMinDepth(topNode.left) + 1).compareTo(subtreeMinDepth(topNode.right) + 1)) < 0) {
				return subtreeMinDepth(topNode.left) + 1;
			} else {
				return subtreeMinDepth(topNode.right) + 1;
			}
		}
	}
	
	/*
	 * Methods to calculate the number of times key occurs in the tree
	 */
	public int countMatches(String key) {
		return subtreeCountMatches(root, key);
	}
	
	private int subtreeCountMatches(Node topNode, String key) {
		if (topNode == null) {
			return 0;
		} else {
			if (key.equals(topNode.record)) {
				return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key) + 1;
			} else {
				return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key);
			}
		}
	}
	
	/*
	 * Methods to calculate the value of the largest record in the tree
	 */
	public String maxRecord() {
		return treeMaxRecord(root);
	}
	
	private String treeMaxRecord(Node topNode) {
		if (topNode == null) {
			return null;
		} else {
			if (topNode.record.compareTo(treeMaxRecord(topNode.left) + 1) < 0 && ((treeMaxRecord(topNode.right) + 1).compareTo(treeMaxRecord(topNode.left) + 1)) < 0) {
				return topNode.left.record;
			} else if ((topNode.record.compareTo(treeMaxRecord(topNode.left) + 1) > 0) && (topNode.record.compareTo(treeMaxRecord(topNode.right) + 1) > 0)) {
				return topNode.record;
			} else if (topNode.record.compareTo(treeMaxRecord(topNode.right) + 1) < 0 && (topNode.record.compareTo(treeMaxRecord(topNode.right) + 1)) < 0) {
				return (topNode.right).record;
			} 
		}
		return null;
	}
	
	/*
	 * Methods to calculate the value of the smallest record in the tree
	 */
	public String minRecord() {
		return treeMinRecord(root);
	}
	
	private String treeMinRecord(Node topNode) {
		// checks if the top of the node is null, if so, returns a value of 0
		if (topNode == null) {
			return null;
		} else {
			if (topNode.record.compareTo(treeMinRecord(topNode.right)) + 1 < 0 && (topNode.record.compareTo(treeMinRecord(topNode.left) + 1) < 0)) {
				return topNode.record;
			} else if ((treeMinRecord(topNode.left).compareTo(topNode.record) < 0) && (treeMinRecord(topNode.left) + 1).compareTo(treeMinRecord(topNode.right) + 1) < 0) {
				return treeMinRecord(topNode.left);
			} else if ((treeMinRecord(topNode.right).compareTo(topNode.record) < 0) && (treeMinRecord(topNode.right) + 1).compareTo(treeMinRecord(topNode.left) + 1) < 0) {
				return treeMinRecord(topNode.right);
			}
		}
		return null;
	} 
	
}

