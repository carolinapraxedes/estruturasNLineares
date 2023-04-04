package BinarySearchTree;

public class BinarySearchTree {
	   Node root;

	    public BinarySearchTree() {
	        root = null;
	    }
	    
	    public int depth(int key) {
	        return depthNode(root, key, 0);
	    }

	    private int depthNode(Node node, int key, int depth) {
	        if (node == null) {
	            return -1;
	        } else if (key == node.key) {
	            return depth;
	        } else if (key < node.key) {
	            return depthNode(node.left, key, depth + 1);
	        } else {
	            return depthNode(node.right, key, depth + 1);
	        }
	    }

	    public int height(Node node) {
	        if (node == null) {
	        	//altura vai ser zero
	            return -1;
	        }

	        //alturas dos filhos do nó passado
	        int leftHeight = height(node.left);
	        int rightHeight = height(node.right);

	        //a altura do nó passado vai ser a soma de 1 mais a altura da subárvore mais alta entre seus filhos
	        return 1 + Math.max(leftHeight, rightHeight);
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
	        	//se for menor que a root, vai pra esquerda
	            root.left = insertNode(root.left, key);
	        } else if (key > root.key) {
	        	//se for maior que a root, vai pra direita
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

	    public void inOrder(Node node) {
	        if (node != null) {
	            inOrder(node.left);
	            System.out.print(node.key + " ");
	            inOrder(node.right);
	        }
	    }


}
