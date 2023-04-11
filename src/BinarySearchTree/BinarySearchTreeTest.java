package BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) throws NodeExistsException {
		 BinarySearchTree tree = new BinarySearchTree(9);
		 tree.insert(8);
		 	tree.insert(10);
		 	tree.insert(5);
		 	tree.insert(6);
		 	tree.printTree();
		 	tree.remove(5);
		 	System.out.println();
		 	tree.printTree();
		 	
		 	
		 	tree.insert(4);
		 	System.out.println();
		 	tree.printTree();
		 	
		 	tree.insert(11);
		 	System.out.println();
		 	tree.printTree();
		 	
		 	tree.remove(10);
		 	System.out.println();
		 	tree.printTree();
		 	
	}

}
