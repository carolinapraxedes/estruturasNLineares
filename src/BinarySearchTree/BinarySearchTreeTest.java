package BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) throws NodeExistsException {
		 BinarySearchTree tree = new BinarySearchTree(9);
		 	Node no2 = tree.insert(8);
		 	Node no3 = tree.insert(10);
		 	Node no4 = tree.insert(5);
		 	Node no5 = tree.insert(6);
		 	tree.printNo();
		 	tree.remove(5);
		 	tree.printNo();
	}

}
