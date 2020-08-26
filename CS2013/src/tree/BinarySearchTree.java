package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
	private BSTNode<E> root;
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(E ... elements) {
		for (int i = 0; i < elements.length; i++) {
			insert(elements[i]);
		}
	}
	
	public void insert(E value) {
		if (value == null) {
			throw new NullPointerException("BST node data cannot be null!");
		}
		BSTNode<E> child = new BSTNode<>(value);
		
		if (this.isEmpty()) {
			this.root = child;
		} else {
			try {
				BSTNode<E> parent = insertionPoint(value);
				if (value.compareTo(parent.getData())== -1) {
					parent.left = child;
					child.parent = parent;
				} else if (value.compareTo(parent.getData()) == 1) {
					parent.right = child;
					child.parent = parent;
				}
			} catch(DuplicateItemException e) {
				throw new DuplicateItemException("Duplicate found in BST!");
			}
		}
	}
	
	private BSTNode<E> insertionPoint(E key) {
		BSTNode<E> current = this.root;
		BSTNode<E> parent = null;
		
		while(current != null) { 
			if (key == null) {
				throw new NullPointerException("BST node data cannot be null!");
			} else if (key.compareTo(current.getData()) == 0) {
				throw new DuplicateItemException("Duplicate found in BST!");
			} else if (key.compareTo(current.getData()) == -1) {
				parent = current;
				current = current.left;
			} else if (key.compareTo(current.getData()) == 1) {
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}
	
	public void delete(E value) {
		delete(nodeToDelete(value));
	}
	
	private void delete(BSTNode<E> node) {
		try {
			if (numChildren(node) == 0) {
				if (isLeftChild(node)) {
					node.parent.left = null;
					node.parent = null;
				} else if (isRightChild(node)) {
					node.parent.right = null;
					node.parent = null;
				}
			} else if (numChildren(node) == 1) {
				BSTNode<E> child = null;
				if (node.left != null) {
					 child = node.left;
				} else if (node.right != null) {
					 child = node.right;
				}
				if (node.parent.left != null && isLeftChild(node)) {
					node.parent.left = child;
					child.parent = node.parent;
				} else if (node.parent.right != null && isRightChild(node)) {
					node.parent.right = child;
					child.parent = node.parent;
				}
			} else if (numChildren(node) == 2) {
				BSTNode<E> max = maxLeftSubtree(node);
				node.setData(max.getData());
				delete(max);
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("Cannot delete a node that is not in the BST!");
		}
		
	}
	
	private BSTNode<E> nodeToDelete(E key) {
		BSTNode<E> current = this.root;
		while (current != null) {
			if (key == null) {
				throw new NullPointerException("BST node data cannot be null!");
			} else if (key.compareTo(current.getData())==0) { 
				return current;
			} else if (key.compareTo(current.getData()) == -1) {
				current = current.left;
			} else if (key.compareTo(current.getData()) == 1) {
				current = current.right;
			}
		}
		return null;
	}
	
	private int numChildren(BSTNode<E> node) {
		int count = 0;
		
		if (node.left != null) {
			count++;
		}
		if (node.right != null) { 
			count++;
		}
		return count;
	}
	
	private BSTNode<E> maxLeftSubtree(BSTNode<E> node) { 
		BSTNode<E> current = node.left;
		while (current.right != null) { 
			current = current.right;
		}
		return current;
	}
	
	public boolean find(E value) {
		BSTNode<E> current = this.root;
		while (current != null) {
			if (value.compareTo(current.getData()) == 0) {
				return true;
			} else if (value.compareTo(current.getData()) == -1) {
				current = current.left;
			} else if (value.compareTo(current.getData()) == 1) {
				current = current.right;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<E> preorder() {
		ArrayList<E> preorderList = new ArrayList<>();
		if (this.isEmpty()) {
			return preorderList;
		} else {
			return preorder(this.root, preorderList);
		}
		
	}
	private ArrayList<E> preorder(BSTNode<E> node, ArrayList<E> list) { 		
		if (node == null) {
			return null;
		} else {
			list.add(node.getData());
			preorder(node.left, list);
			preorder(node.right, list);
		}
		return list;
		
	}
	
	public ArrayList<E> inorder() {
		ArrayList<E> inorderList = new ArrayList<>();
		if (this.isEmpty()) {
			return inorderList;
		} else {
			return inorder(this.root, inorderList);
		}
	}
	
	private ArrayList<E> inorder(BSTNode<E> node, ArrayList<E> list) { 		
		if (node == null) {
			return null;
		} else {
			inorder(node.left, list);
			list.add(node.getData());
			inorder(node.right, list);
		}
		return list;
		
	}
	
	public ArrayList<E> postorder() {
		ArrayList<E> postorderList = new ArrayList<>();
		if (this.isEmpty()) {
			return postorderList;
		} else {
			return postorder(this.root, postorderList);
		}
	}
	
	private ArrayList<E> postorder(BSTNode<E> node, ArrayList<E> list) { 		
		if (node == null) {
			return null;
		} else {
			postorder(node.left, list);
			postorder(node.right, list);
			list.add(node.getData());
		}
		return list;
		
	}
	
	public ArrayList<E> breadthfirst() {
		ArrayList<E> bfsList = new ArrayList<>();
		if (root == null) {
			return bfsList;
		} else {
			Queue<BSTNode<E>> Q = new LinkedList<>();
			Q.add(root);
			while(!Q.isEmpty()) {
				BSTNode<E> node = Q.poll();
				bfsList.add(node.getData());
				if (node.left!= null) {
					Q.add(node.left);
				}
				if (node.right!= null) {
					Q.add(node.right);

				}
				
			}
			return bfsList;
		}
		
	}
	
	//For the sake of testing the protected methods (sibling, uncle, grandparent)
	protected BSTNode<E> getNode(E value) {
		BSTNode<E> current = this.root;
		while (current != null) {
			if (value.compareTo(current.getData()) == 0) {
				return current;
			} else if (value.compareTo(current.getData()) == -1) {
				current = current.left;
			} else if (value.compareTo(current.getData()) == 1) {
				current = current.right;
			}
		}
		return null;
	}
	
	
	protected boolean isLeaf(BSTNode<E> node) {
		if (node.left == null && node.right == null) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isLeftChild(BSTNode<E> node) {
		try {
			return node.parent.left.getData().equals(node.getData());	
		} catch (NullPointerException e) {
			return false;
		}
		
	}
	
	protected boolean isRightChild(BSTNode<E> node) {
		try {
			return node.parent.right.getData().equals(node.getData());	
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	protected BSTNode<E> sibling(BSTNode<E> node) {
		if (node == root) {
			return null;
		} else if(isLeftChild(node)) {
			if (node.parent.right != null) {
				return node.parent.right;
			} 
		} else if (isRightChild(node)) { 
			if (node.parent.left != null) { 
				return node.parent.left;
			}
		}
		return null;
	}
	
	protected BSTNode<E> uncle(BSTNode<E> node) {
		if (node == root) {
			return null;
		} else {
			return sibling(node.parent);
		}
	}
	
	protected BSTNode<E> grandparent(BSTNode<E> node) {
		if (node == root || node.parent == root) {
			return null;
		} else { 
			return node.parent.parent;
		}
	}
	
	//From Todd Davies answer to printing a BST on StackOverflow
	//https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram/8948691#8948691
	@Override
    public String toString(){
		if (root != null) {
			return "\n"+root.toString()+"\n";
		} else {
			return "\n └── <null> \n";
		}
        
    }


}
