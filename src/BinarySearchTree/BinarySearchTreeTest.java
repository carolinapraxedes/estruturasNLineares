package BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		 BinarySearchTree tree = new BinarySearchTree();

	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);

	        System.out.print("Inorder traversal: ");
	        tree.inOrderTraversal(tree.root);

	        System.out.println();
	        System.out.println("Search for key 60: " + tree.search(tree.root, 60));

	}

}
