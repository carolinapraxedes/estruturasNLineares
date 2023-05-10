package AVL;

import java.util.ArrayList;


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
        /*// Atualizar o fator de balanceamento ao longo do caminho percorrido
        int FB = getBalanceFactor(newNode);
        newNode.setFB(FB);*/

        return newNode;
    }
    

    
    /*
     * Métodos da árvore AVL
     * */
    
    public void updateBalanceFactor(Node node,int InsertOrRemove) {    	
    	Node father = node.getParent();
    	boolean stop = false;
    	while(!stop && father != null) {
    		if(node.getKey() > father.getKey()) {
    			//se for filho direito
    			father.FB = (father.getFB()+(-1*InsertOrRemove));
    		}else {
    			//se for filho esquerdo
    			father.FB = (father.getFB()+(1*InsertOrRemove));
    		}
    		
    		Node nodeBalanced = getBalance(node,InsertOrRemove);
    		if(node != nodeBalanced) {
    			node = nodeBalanced;
    			continue;
    		}
    		if((Node)father==null) {
    			stop=true;
    		}if((father.getFB()==0)&&(InsertOrRemove==1) || ((father.getFB()!=0) && (InsertOrRemove == -1))) {    			
    			stop=true;
    		}
    		node = node.getParent();
    		
    	}
    }

    
    public Node getBalance(Node node,int InsertOrRemove) {
    	Node father = node.getParent();
    	int fb=0;
    	
    	if((node.getFB() <= 1) && (node.getFB() >= -1)) {
    		return node; //está balanceado
    	}else {
    		//precisa balancear
    		
    		if(node.getParent()!=null) {
    			if(node.getFB()== -2) {
    				//esquerda
    				Node sonRight = node.getRightChild();
    				fb = sonRight.getFB();
    				if(fb<=0) {
    					//simples
    				}else {
    					//dupla
    				}
    				
    			}else if(node.getFB()== 2) {
    				//direita
    			}
    			
    			
    			
    			/*if(node.getKey() > node.getParent().getKey()) {
    				int sonRight = 1;
    			}else {
    				int sonLeft = -1;
    			}*/
    		}
    		
    	}
    	
    	return node;
    }
    
    /*public int getBalanceFactor(Node node) {
        int heightLeft = height(node.getLeftChild());
        int heightRight = height(node.getRightChild());
        return heightLeft - heightRight;
    }*/
    
    /*public void checkBalance(Node node) {
        if (node == null) {
            return;
        }
        
        int balanceFactor = getBalanceFactor(node);
        
        if (balanceFactor > 1 || balanceFactor < -1) {
            // A árvore está desbalanceada, fazer a rotação correspondente
            if (balanceFactor > 1) {
                if (getBalanceFactor(node.getLeftChild()) >= 0) {
                    // Rotação simples à direita
                	rotateRight(node);
                	
                } else {
                    // Rotação dupla à esquerda-direita
                    //rotationLeftRight(node);
                	rotationLeftDouble(node);
                	
                }
            } else {
                if (getBalanceFactor(node.getRightChild()) <= 0) {
                    // Rotação simples à esquerda
                	rotateLeft(node);
                	
                	
                } else {
                    // Rotação dupla à direita
                    rotationRightDouble(node);
                    
                	
                }
            }
            
            // Depois de fazer a rotação, é preciso atualizar os fatores de balanceamento dos nós afetados
            if (node.getParent() != null) {
                checkBalance(node.getParent());
            } else {
                root = node;
            }
        } else {
            checkBalance(node.getParent());
        }
    }
*/
    
 
    /*public Node balance(Node no) {
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
    */
    
	private Node rotateRight(Node node) {
		 Node leftChild = node.getLeftChild();
		    leftChild.setParent(node.getParent());

		    node.setLeftChild(leftChild.getRightChild());

		    if (node.getLeftChild() != null) {
		        node.getLeftChild().setParent(node);
		    }

		    leftChild.setRightChild(node);
		    node.setParent(leftChild);

		    return leftChild;
		
	}
    
	public Node rotateLeft(Node node) { //ESQUERDA
		 System.out.println("Aplicando rotação à esquerda simples em nó " + node.getKey());
		    
		    Node child = node.getRightChild();
		    
		    child.setParent(node.getParent());
		    child.setLeftChild(node);
		    
		    node.setParent(child);
		    
		    /*int FBNo = getBalanceFactor(node);
		    int FBChild = getBalanceFactor(child);
		    node.setFB(FBNo);
		    child.setFB(FBChild);*/
		    
		    System.out.println("Rotação à esquerda simples aplicada em nó " + node.getKey());
		    
		    return child;
    }
    

    private Node rotationRightDouble(Node node) {
    	 node.setRightChild(rotateRight(node.getRightChild()));
    	    return rotateLeft(node);
		
	}

	private Node rotationLeftDouble(Node node) {
		  node.setLeftChild(rotateLeft(node.getLeftChild()));
		    return rotateRight(node);
		
	}






    /*Imprimir arvore*/
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
  
    
    
	
}
