package BinarySearchTree;

public class Node {
	int key;
	Node left, right,parent;

	public Node(int item) {
		this.key = item;
		this.left = null;
		this.right = null;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public void setKey(int item) {
		this.key = item;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node getLeftChild() {
		return this.left;
	}
	
	public Node getRightChild() {
		return this.right;
	}
	
	public boolean isLeftChild() {
		return (parent != null && this == parent.left);
	}
	
	public boolean isRightChild() {
		return (parent != null && this == parent.right);
	}
	
}
