package BinarySearchTree;

public class BinarySearchTree {
	   Node root;

	    public BinarySearchTree() {
	        root = null;
	    }

	    void insert(int key) {
	        root = insertNode(root, key);
	    }

	    Node insertNode(Node root, int key) {
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }

	        if (key < root.key) {
	            root.left = insertNode(root.left, key);
	        } else if (key > root.key) {
	            root.right = insertNode(root.right, key);
	        }

	        return root;
	    }

	    Node search(Node node, int key) {
	        if (node == null || node.key == key) {
	            return node;
	        }

	        if (key < node.key) {
	            return search(node.left, key);
	        }

	        return search(node.right, key);
	    }

	    void inOrderTraversal(Node node) {
	        if (node != null) {
	            inOrderTraversal(node.left);
	            System.out.print(node.key + " ");
	            inOrderTraversal(node.right);
	        }
	    }
}
