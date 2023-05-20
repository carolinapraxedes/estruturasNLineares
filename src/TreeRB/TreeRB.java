package TreeRB;

import java.util.ArrayList;

public class TreeRB {
	   Node root;
	   int size;
	   ArrayList<Node> ArrayNo = new ArrayList<>();
		// 0 = black
		// 1 = red
	   
	public TreeRB(int key) {
		 this.root = new Node(key);	
		 root.setColor(0);
	}
			
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
    	
		// 0 = black
		// 1 = red
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
        
        newNode.setColor(1);
        verifyColor(newNode);
        
        return newNode;
    
    }
    
    public void verifyColor(Node no) {
		// 0 = black
		// 1 = red
    	Node grampa = no.getParent().getParent();
    	Node daddy = no.getParent();    	
    	Node uncle = null;
    	int uncleColor = 0;
    	
    	if(daddy.getColor() == 0) {
    		//case 1
    		return;
    	}
    			
    	
    	if(grampa != null) {
    		//case 2
    		if(hasTwoChild(grampa)){
    			//procurando quem é o tio
    			if(grampa.getRightChild() == daddy) {
    				uncle=grampa.getLeftChild();
    			}else {
    				uncle=grampa.getRightChild();
    			}
    			uncleColor = uncle.getColor();
    		}
    		//verificando as cores dos envolvidos
    		// 0 = black
    		// 1 = red
    		if(grampa.getColor() == 0 && daddy.getColor() == 1 && uncleColor ==1 && no.getColor()== 1) {
    			grampa.setColor(1);
    			daddy.setColor(0);
    			uncleColor = 0;
    			if(uncle !=null) {
    				uncle.setColor(uncleColor);
    			}
    			if(grampa.getParent().getColor() == 1) {
    				verifyColor(grampa);
    			}    			
    		}
    		//case 3
    		if(grampa.getColor()==0 && daddy.getColor()==1 && uncleColor == 0 && no.getColor()==1) {
        		// 0 = black
        		// 1 = red
    			
    			Node greatGrampa = grampa.getParent();
    			
    			if(greatGrampa !=null) {
    				if(grampa.isLeftChild()) {
        				greatGrampa.setLeftChild(daddy);
        			}else if(grampa.isRightChild()) {
        				greatGrampa.setRightChild(daddy);
        			}
    				daddy.setParent(greatGrampa);
    			} 
    			
    			if(grampa.getRightChild() == null && daddy.getRightChild() == null) {
    	  			//rotação direita simples
        			grampa.setParent(daddy);
        			grampa.setLeftChild(null);
        			daddy.setRightChild(grampa);
        			
        			//recolorindo após mudança dos ponteiros
        			daddy.setColor(0);
        			grampa.setColor(1);
        			
    			}else if(grampa.getLeftChild() == null && daddy.getLeftChild() == null) {
    				//rotação esquerda simples
    				
    			}


    			
    			    			
  
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    		}
    		
    	}
    	
    }
    
    
    public int remove(int key) throws NodeExistsException{
        Node no = search(root,key);
        Node noParent = no.getParent();
        int removedKey = no.getKey();
        Node child = null;
        if(removedKey == 0) {
            throw new NodeExistsException("Nó não existe");
        }
        if(isExternal(no)) {   		
            if (no.isRightChild()) {
                noParent.setRightChild(null);
            }else {
                noParent.setLeftChild(null);
            }
            return removedKey;
        }
        if (hasOneChild(no)) {
            if(no.hasLeftChild(no)) {
                child = no.getLeftChild();
            }else {
                child = no.getRightChild();
            }
            if(no.isRightChild()) {
                noParent.setRightChild(child);
            }else {
                noParent.setLeftChild(child);
            }	    		
            child.setParent(noParent);
            return removedKey;
        }
        if(hasTwoChild(no)) {
            Node successor = successor(no);
            removedKey = remove(successor.getKey());
            return removedKey;
        }
        return removedKey;
        
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
    		tree[depth(ArrayNo.get(i))][i] = ArrayNo.get(i).getKey();
    	}
    	
    	for(int l = 0;l<height(getRoot())+1;l++) {
    		for(int c =0; c < ArrayNo.size();c++) {
    			System.out.print(tree[l][c] != null ? tree[l][c]+"\t" : "\t");
    		}
    		System.out.println("");
    	}
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


	
	
	
	
	
	
	
}
