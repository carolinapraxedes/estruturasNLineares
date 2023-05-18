package TreeRB;


public class TreeRBMain {
	public static void main(String[] args) throws NodeExistsException {
		TreeRB arvore = new TreeRB(8);
		arvore.insert(10);
		arvore.insert(6);
		arvore.insert(5);
		arvore.printTree();
		
		System.out.println("==================");
		arvore.remove(6);
		arvore.printTree();
		
		
	}
	
	
}
