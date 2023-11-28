import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BST<T extends Comparable<T>> implements Iterable<T> {
    private Comparator comparator;
    class BSTNode implements Comparable<BSTNode> {
            private T data;
            private BSTNode left;
            private BSTNode right;
            
            public BSTNode(T d) {
                setLeft(null);
                setRight(null);
                setData(d);
            }

            public T getData() { return data; }
            public void setData(T d) { data = d; }
            public void setLeft(BSTNode l) { left = l; }
            public void setRight(BSTNode r) { right = r; }
            public BSTNode getLeft() { return left; }
            public BSTNode getRight() { return right; }
            public boolean isLeaf() {
                return (getLeft() == null) && (getRight() == null); }

            @Override
            public int compareTo(BSTNode o) {
                return this.getData().compareTo(o.getData());
            }
     }

        private BSTNode root;
	    private int size;

        public static final int INORDER=0;
	    public static final int PREORDER=1;
	    public static final int POSTORDER=2;
	    public static final int LEVELORDER=3;
        public BST() {
            root = null;
            size = 0;
        }
        public BST(	 Comparator<T> comparator) {
            size = 0;
            root=null;
            this.comparator = comparator;
        }

        public void add(T d) {
            BSTNode n = new BSTNode(d);
            if (root() == null) {
                size++;
                root = n;
            } else {
                add(root(), n);
            }
        }
        public void traverse(int travType) {

        	
        	traverse(root(), travType);
        }
        public void delete(T value) {
            root = delete(root(), value);
        }

        private BSTNode delete(BSTNode root, T value) {
            if (root == null) {
                return null;
            }

            if (value.compareTo(root.data) < 0) {
                root.left = delete(root.left, value);
            } else if (value.compareTo(root.data) > 0) {
                root.right = delete(root.right, value);
            } else {
                // Node with only one child or no child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.data = minValue(root.getRight());

                root.right = delete(root.right, value);
            }

            return root;
        }

        private T minValue(BSTNode root) {
            T minValue = root.data;
            while (root.left != null) {
                minValue = root.left.data;
                root = root.left;
            }
            return minValue;
        }
        
        private void add(BSTNode r, BSTNode n) {
            int c=0;    
            if(comparator == null) 
            	c = n.compareTo(r);
            else
            	c = comparator.compare(r.getData(), n.getData());
            	
            
            if (c < 0) {
                if(r.getLeft() == null) {
                    r.setLeft(n);
                    size++;
    
                }
                else
                    add(r.getLeft(), n);
            }
            if(c > 0) {
                if(r.getRight() == null) {
                    r.setRight(n);
                    size++;
                }
                else
                    add(r.getRight(), n);
            }
        }
        public void find(T d) {
        	find( d,  root());
        }
        private T find(T d, BSTNode r) {
            if (r == null)
                return null;
            int c = d.compareTo(r.getData());
            if (c == 0)
                return r.getData();
            else if (c < 0)
                return find(d, r.getLeft());
            else
                return find(d, r.getRight());
        }
        
        
        /* Implement a height method. */
        private int height(BSTNode r) {
            int hit = -1;

            if (r == null) {
               return hit;
            }
            else if (r.isLeaf()) {
            	hit = 0;
            }
            else {
               int leftHeight = 0;
               int rightHeight = 0;
               if (r.getLeft() != null) {
                  leftHeight = height(r.getLeft());
               }
               if (r.getRight() != null) {
                  rightHeight = height(r.getRight());
               }
               hit = Math.max(leftHeight, rightHeight) + 1;
            }
            return hit;
         }
        public int height() {
            return height(root);
         }
        
        private Queue<T> queue = new LinkedList<T>();
	    private void visit(BSTNode r) {

	    	if (r != null)
			queue.add(r.getData());
	    }
        private void traverse(BSTNode r, int travType) {
            if(r==null)
                return;
            else {
                switch(travType) {
                case INORDER:
                    traverse(r.getLeft(), travType);
                    visit(r);
                    traverse(r.getRight(), travType);
                    break;
                case PREORDER:
                    visit(r);
                    traverse(r.getLeft(), travType);
                    traverse(r.getRight(), travType);
                    break;
                case POSTORDER:
                    traverse(r.getLeft(), travType);
                    traverse(r.getRight(), travType);
                    visit(r);
                    break;
                case LEVELORDER:
                	Queue<BSTNode> q = new LinkedList<>();
            		if(r != null){
            			q.add(r);
            		}
            		while (!q.isEmpty()) {
            			// get front element
            			// visti the this element
            			// add children of this element
            			BSTNode curr = q.remove();
            			visit(curr);
            			
            			if (curr.getLeft() != null) {
            				q.add(curr.getLeft());
            			}
            	
            			if (curr.getRight() != null) {
            				q.add(curr.getRight());
            			}
            		

            		}
    
                    
                }
            }
        }
        

        private class BSTIteratorInOrder implements Iterator{
        	
            public  BSTIteratorInOrder() {
                queue.clear();
                traverse(root(),INORDER);
            }
            @Override
            public boolean hasNext() {
                
                return !queue.isEmpty();
            }
    
            @Override
            public Object next() {
                
                return queue.remove();
            }
            
        }
        private class BSTItrator implements Iterator{
        	
            public  BSTItrator(int order) {
                queue.clear();
                traverse(root(),order);
            }
            @Override
            public boolean hasNext() {
                
                return !queue.isEmpty();
            }
    
            @Override
            public Object next() {
                
                return queue.remove();
            }
            
        }
  
        
       
         
        public int getSize() {
        	return size;
        }
    @Override
    public Iterator<T> iterator() {
        return new BSTIteratorInOrder();
    }
    public Iterator<T> iterator(int traversalOrder) {
        return new BSTItrator(traversalOrder);
    }
	public BSTNode root() {
		return root;
	}

    
}
