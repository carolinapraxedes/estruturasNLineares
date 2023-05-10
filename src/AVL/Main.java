package AVL;



public class Main {

	public static void main(String[] args) throws NodeExistsException {
		 AVLTree tree = new AVLTree(9);
		 	tree.printTree();
		 	System.out.println("====================");
		 	tree.insert(8);
		 	tree.printTree();
		 	System.out.println("====================");
		 	tree.insert(10);
		 	tree.printTree();
		 	System.out.println("====================");

		 	tree.insert(5);
		 	tree.printTree();
		 	System.out.println("====================");
		 	tree.insert(6);
		 	tree.printTree();
		 	System.out.println("====================");
		 	tree.insert(7);
		 	tree.printTree();
		 	System.out.println("====================");
		 	
		 	//tree.printTree();
		 	//System.out.println(tree.getBalanceFactor(tree.getRoot()));



	}

}
