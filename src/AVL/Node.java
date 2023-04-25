package AVL;


public class Node {

	int key;
	Node left, right,parent;
	int FB;

	public Node(int item) {
		this.key = item;
		this.left = null;
		this.right = null;
		
		
	}
	
	/*
	 * GETTERS AND SETTERS
	 * */
	
	public int getKey(){
		return this.key;
	}
	
	public void setKey(int item) {
		this.key = item;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getLeftChild() {
		return this.left;
	}
	
    public void setLeftChild(Node leftChild) {
        this.left = leftChild;
    }
	    
	public Node getRightChild() {
		return this.right;
	}
	
    public void setRightChild(Node rightChild) {
        this.right = rightChild;
    }
    public int getFB() {
    	return this.FB;
    }
    
    public void setFB(int FB) {
    	this.FB = FB;
    }
    
    
    /*
     * METHOD
     * */    
	
	public boolean isLeftChild() {
		return (parent != null && this == parent.left);
	}
	
	public boolean isRightChild() {
		return (parent != null && this == parent.right);
	}
	
	public boolean hasLeftChild(Node no) {
	
		return no.getLeftChild()!=null;
	}
	public boolean hasRightChild(Node no) {
		
		return no.getRightChild()!=null;
	}
}
