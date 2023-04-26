package AVL;

import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.NodeExistsException;

public class Main {

	public static void main(String[] args) throws NodeExistsException {
		 AVLTree tree = new AVLTree(9);
		 	tree.insert(8);
		 	tree.insert(10);

		 	tree.insert(5);
		 	tree.insert(6);
//		 	tree.insert(7);
		 	
		 	tree.printTree();
		 	//System.out.println(tree.getBalanceFactor(tree.getRoot()));



	}

}
