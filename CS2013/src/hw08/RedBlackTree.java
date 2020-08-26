package hw08;

public class RedBlackTree<E extends Comparable<E>> extends BinarySearchTree<E> {
	protected final BSTNode<E> NIL = new BSTNode<E>(null,'B');
	
	public RedBlackTree() {}

	public RedBlackTree(E ... elements) {
		for (int i = 0; i < elements.length; i++) {
			insert(elements[i]);
		}
	}
	
	public void leftRotate(BSTNode<E> node) {
		if (node.parent != NIL) {
			BSTNode<E> pivot = node.right;
			pivot.parent = node.parent;
			if (isLeftChild(node)) {
				node.parent.left = pivot;
			} else if (isRightChild(node)) {
				node.parent.right = pivot;
			}
			node.parent = pivot;
			node.right = pivot.left;
			if (pivot.left != NIL) {
				pivot.left.parent = node;
			}
			pivot.left = node;
		} else {
			BSTNode<E> pivot = this.root.right;
			this.root.right = pivot.left;
			if (pivot.left != NIL) {
				pivot.left.parent = this.root;
			}
			this.root.parent = pivot;
			pivot.left = this.root;
			pivot.parent = NIL;
			this.root = pivot;
		}
		
	}
	public void rightRotate(BSTNode<E> node) {
		if (node.parent != NIL) {
			BSTNode<E> pivot = node.left;
			pivot.parent = node.parent;
			if (isLeftChild(node)) {
				node.parent.left = pivot;
			} else if (isRightChild(node)) {
				node.parent.right = pivot;
			}
			node.parent = pivot;
			node.left = pivot.right;
			if (pivot.right != NIL) {
				pivot.right.parent = node;
			}
			pivot.right = node;
		} else {
			BSTNode<E> pivot = this.root.left;
			this.root.left = pivot.right;
			if (pivot.right != NIL) {
				pivot.right.parent = this.root;
			}
			this.root.parent = pivot;
			pivot.right = this.root;
			pivot.parent = NIL;
			this.root = pivot;
		}
		
	}
	
	private void insertCleanup(BSTNode<E> node) {
		if (this.root.color == 'R') {
			this.root.color = 'B';
		} 
		else if (node.parent.color == 'R') {
			BSTNode<E> uncle = uncle(node);
			BSTNode<E> parent = node.parent;
			BSTNode<E> grandparent = grandparent(node);
			if (uncle(node)!= NIL && uncle(node).color == 'R') {
				parent.color = 'B';
				uncle.color = 'B';
				grandparent.color = 'R';
				insertCleanup(grandparent);
			} else {
				if (isRightChild(node) && isLeftChild(parent)) {
					leftRotate(parent);
					BSTNode<E> temp = node;
					node = parent;
					parent = temp;
				} if (isLeftChild(node) && isRightChild(parent)) {
					rightRotate(parent);
					BSTNode<E> temp = node;
					node = parent;
					parent = temp;
				} if (isLeftChild(node) && isLeftChild(node)) {
					parent.color = 'B';
					grandparent.color = 'R';
					rightRotate(grandparent);
				} if (isRightChild(node) && isRightChild(node)) {
					parent.color = 'B';
					grandparent.color = 'R';
					leftRotate(grandparent);
				}
			} 
		} 
			
	}
	
	@Override
	public void insert(E value) {
		if (value == null) {
			throw new NullPointerException("BST node data cannot be null!");
		}
		BSTNode<E> child = new BSTNode<>(value,'N');
		
		if (this.isEmpty()) {
			this.root = child;
			child.color = 'B';
			child.parent = NIL;
			child.left = NIL;
			child.right = NIL;
		} else {
			try {
				child.color = 'R';
				BSTNode<E> parent = insertionPoint(value);
				if (value.compareTo(parent.getData())== -1) {
					parent.left = child;
					child.parent = parent;
					child.left = NIL;
					child.right = NIL;
				} else if (value.compareTo(parent.getData()) == 1) {
					parent.right = child;
					child.parent = parent;
					child.right = NIL;
					child.left = NIL;
				}
			} catch(DuplicateItemException e) {
				throw new DuplicateItemException("Duplicate found in BST!");
			}
			insertCleanup(child);
		}
		
	}
	
}
