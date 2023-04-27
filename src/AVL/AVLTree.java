package AVL;

import java.util.ArrayList;

import BinarySearchTree.BinarySearchTree;

import BinarySearchTree.NodeExistsException;

public class AVLTree{
	Node root;
	int height;	
	int size;
	ArrayList<Node> ArrayNo = new ArrayList<>();
	
	public AVLTree(int key) {		
        this.root = new Node(key);
        this.height=0;
    }
	
	/*
	 * Métodos da árvore binária de busca
	 * */
	
	public boolean isInternal(Node no) {
		return no.getRightChild() != null || no.getLeftChild()==null;
	}


	public boolean isExternal(Node no) {
		return no.getRightChild()== null && no.getLeftChild()==null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
    public Node getRoot() {
    	return root;
    }
    
	public int height(Node no) {
		if(no == null) {
			return -1;
		}
		int sonLeftNo = height(no.getLeftChild());
		int sonRightNo = height(no.getRightChild());
		
		if(sonLeftNo > sonRightNo) {
			return sonLeftNo + 1;
		}else {
			return sonRightNo +1;
		}

	}
	
	public int depth(Node no) {
		if(no == root) {
			return 0;
		}
		return 1 + (depth(no.getParent()));
	}
	
    public Node search(Node node, int key) {
        if (isExternal(node)) {
        	return node;
        }
        if(key < node.getKey()) {
        	if(node.getLeftChild() != null) {
        		return search(node.getLeftChild(),key);
        	}else {
        		return node;
        	}
        	
        } else if(key == node.getKey()) {
        	return node;
        }
        else {
        	if(node.getRightChild() != null) {
        		return search(node.getRightChild(), key);
        	}else {
        		return node;
        	}
        	
        }
            
    }

    public 	Node insert(int key) throws NodeExistsException  {
    	Node parent = search(root, key);
        if (parent.getKey() == key) {
            throw new NodeExistsException("Nó já existe");
        }

        Node newNode = new Node(key);
        newNode.setParent(parent);

        if (key < parent.getKey()) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }
        // Atualizar o fator de balanceamento ao longo do caminho percorrido
        int FB = getBalanceFactor(newNode);
        newNode.setFB(FB);

        return newNode;
    }
    
    public void inOrder(Node node) {
    	if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node.getKey());
        inOrder(node.getRightChild());
	    }
    public void print(Node node) {
	       if(node.getLeftChild() != null) {
	    	   print(node.getLeftChild());
	       }

	       ArrayNo.add(node);
	       
	       if(node.getRightChild()!=null) {
	    	   
	    	   print(node.getRightChild());
	       }
	       
	    }
    
    public void printTree() {
    	ArrayNo.clear();
    	print(getRoot());
    	Object tree[][] = new Object[height(getRoot()) +1 ][ArrayNo.size()];
    	
    	for(int i = 0; i<ArrayNo.size();i++) {
    		tree[depth(ArrayNo.get(i))][i] = ArrayNo.get(i).getKey() +"["+ getBalanceFactor(ArrayNo.get(i)) +"]";
    	}
    	
    	for(int l = 0;l<height(getRoot())+1;l++) {
    		for(int c =0; c < ArrayNo.size();c++) {
    			System.out.print(tree[l][c] != null ? tree[l][c]+"\t" : "\t");
    		}
    		System.out.println("");
    	}
    }
    
    /*
     * Métodos da árvore AVL
     * */
    

    
    public int getBalanceFactor(Node node) {
        int heightLeft = height(node.getLeftChild());
        int heightRight = height(node.getRightChild());
        return heightLeft - heightRight;
    }
    
    public Node balance(Node no) {
    	Node noParent = no.getParent();
    	Node noBalanced = null;
    	
    	int FB=0;
    	if((no.getFB()<=1) && (no.getFB()>=-1)) {
    		//está balanceado
    		return no;
    	}else {
    		//fazendo o balanceamento
    		Node child;
    		if(noParent !=null) {
    			//se ele não for raiz
    			if(no.getFB()== -2) { //rotação a esquerda
    				child= no.getRightChild();
    				FB=no.getRightChild().getFB();
    				
    				if(FB<=0) { 
    					//rotação simples
    					rotationLeftSimple(no);
    				}else if(FB>0) {
    					//rotação dupla
    				}
    			}        			
    		}
    	}
    	
    	return  noBalanced;
    	
    }
    

    public Node rotationLeftSimple(Node no) { //ESQUERDA
    	
    	Node child = no.getRightChild(); // filho
    	
    	child.setParent(no.getParent()); //o novo pai vai ser o avô
    	child.setLeftChild(no);// pai vai ser filho esquerdo
    	
    	no.setParent(child);// o pai vai ser o filho
    	
    	//atualizando o FB
    	 int fbNo = no.getFB();
    	 int fbChild = child.getFB();
    	 no.setFB(fbNo - 1 - Math.max(0, fbChild));
    	 child.setFB(fbChild - 1 + Math.min(0, no.getFB()));
    	
    	return child;
    }


  
    
    
	
}
