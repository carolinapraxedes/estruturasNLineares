package TreeRB;

public class Node {
	int key,color;
	Node left, right,parent;



	public Node(int item) {
		this.key = item;
		this.left = null;
		this.right = null;				
	}
	
	public int getColor() {
		// 0 = black
		// 1 = red
		return color;
	}

	public void setColor(int color) {
		// 0 = black
		// 1 = red
		this.color = color;
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
