/*
 * This class defines the basic node used in a binary tree
 */
public class Node {

	public String record;
	public Node left, right;
	
	public Node(String newRecord) {
		record = newRecord;
		left = null;
		right = null;
	}
	
}