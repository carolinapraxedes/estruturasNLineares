package BinarySearchTree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		 BinarySearchTree tree = new BinarySearchTree();

	        
	        tree.insert(50);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);

	        System.out.print("Em Ordem: ");
	        tree.inOrder(tree.root);
	        
	        System.out.println();
	        System.out.println("procurando pela a chave 55: " + tree.search(tree.root, 55));

	}

}
