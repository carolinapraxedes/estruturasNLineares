package BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree {	
	   Node root;
	   int size;
	   ArrayList<Node> ArrayNo = new ArrayList<>();

	    public BinarySearchTree(int key) {
	    	
	        this.root = new Node(key);	        
	        this.size = 1;
	        ArrayNo.add(root);
	    }
	    

		public boolean isInternal(Node no) {
			return no.getRightChild() != null && no.getLeftChild()==null;
		}


		public boolean isExternal(Node no) {
			return no.getRightChild()== null || no.getLeftChild()==null;
		}
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
	    public Node search(Node node, int key) {
	        if (isExternal(node)) {
	        	return node;
	        }
	        if(key < node.getKey()) {
	        	return search(node.getLeftChild(),key);
	        } else if(key == node.getKey()) {
	        	return node;
	        }
	        else {
	        	return search(node.getRightChild(), key);
	        }
	            
	    }

	    public Node insert(int key) throws NodeExistsException  {
	    	
	    	Node no = search(root,key);
	    	if(no.getKey()== key) {
	    		 throw new NodeExistsException("Nó já existe");
	    	}else{
	    		Node newNode = new Node(key);
	    		newNode.setParent(no);
	    		if(newNode.isRightChild()) {
	    			no.setLeftChild(newNode);
	    		}else {
	    			no.setRightChild(newNode);
	    		}
	    		ArrayNo.add(newNode);
	    		return newNode;
	    	}
	    }
	    
	    public void printNo() {
	    	for(int i=0;i<ArrayNo.size();i++) {
	    		System.out.print(ArrayNo.get(i).getKey()+ " ");
	    	}
	    }
	    
	    public int remove(int key) throws NodeExistsException{
	    	Node no = search(root,key);
	    	Node noParent = no.getParent();
	    	key = no.getKey();
	    	Node child = null;
	    	if(no.getKey() == 0) {
	    		 throw new NodeExistsException("Nó não existe");
	    	}
	    	if(isExternal(no)) {
	    		key = no.getKey();	    			    		
	    		if (no.isRightChild()) {
	    			noParent.setRightChild(null);
	    		}else {
	    			noParent.setLeftChild(null);
	    		}
	    		return key;
	    	}
	    	if (hasOneChild(no)) {
	    		if(no.hasLeftChild(no)) {
	    			child = no.getLeftChild();
	    		}else {
	    			child = no.getRightChild();
	    		}
	    		if(no.hasRightChild(no)) {
	    			noParent.setRightChild(child);
	    		}else {
	    			noParent.setLeftChild(child);
	    		}	    		
	    		child.setParent(noParent);
	    		return key;
	    	}
			
			if(hasTwoChild(no)) {
				key = no.getKey();
				Node successor = successor(no.getRightChild());
				remove(successor.getKey());
				key = successor.getKey();
				return key;
			}
			return key;
	    }
	    
	    public boolean hasOneChild(Node no) {
	    	return (no.hasLeftChild(no) || no.hasRightChild(no));
	    }		
	    
	    public boolean hasTwoChild(Node no) {
	    	return(no.hasLeftChild(no) && no.hasRightChild(no));
	    }
	    
	    public Node successor(Node no){
	    	if(no.getLeftChild() == null) {
	    		return no;
	    	}else {
	    		return successor(no.getLeftChild());
	    	}
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

	    /*void insert(int key) {
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
			*/

	    public void inOrder(Node node) {
	       if(node.getLeftChild() != null) {
	    	   inOrder(node.getLeftChild());
	       }
	       
	       
	       if(node.getRightChild()!=null) {
	    	   
	    	   inOrder(node.getRightChild());
	       }
	    }


}
