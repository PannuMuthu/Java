package tree;
import java.util.ArrayList;

public class BSTTester {
	public static void main(String[] args) {
		System.out.println("BINARY SEARCH TREE DATA STRUCTURE\n");
		
		System.out.println("Creating & printing Integer tree from comma separated vals:");
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(4,5,3,7,1,2,0,6,10,8,9);
		System.out.println(tree);
		System.out.println("Creating & printing empty String tree:");
		BinarySearchTree<String> tree2 = new BinarySearchTree<>();
		System.out.println(tree2);
		
		System.out.println("Inserting 15 and 11 into Integer tree: ");
		tree.insert(15);
		tree.insert(11);
		System.out.println(tree);
		
		System.out.println("Deleting 2 (0 child node) from Integer tree: ");
		tree.delete(2);
		System.out.println(tree);
		System.out.println("Deleting 8 (1 child node) from Integer tree: ");
		tree.delete(8);
		System.out.println(tree);
		System.out.println("Deleting 4 (2 child node) from Integer tree: ");
		tree.delete(4);
		System.out.println(tree);
		
		System.out.println("Is 10 in the Integer tree ('find()')? ");
		System.out.println(tree.find(10)+"\n");
		System.out.println("Is 42 in the Integer tree ('find()')? ");
		System.out.println(tree.find(42)+"\n");
		
		System.out.println("Is the Integer tree empty ('isEmpty()')?");
		System.out.println(tree.isEmpty()+"\n");
		System.out.println("Is the String tree empty ('isEmpty()')?");
		System.out.println(tree2.isEmpty()+"\n");
		
		System.out.println("Reprinting Integer tree: ");
		System.out.println(tree);
		System.out.println("Preorder Traversal for Integer tree: ");
		System.out.println(tree.preorder()+"\n");
		System.out.println("Inorder Traversal for Integer tree: ");
		System.out.println(tree.inorder()+"\n");
		System.out.println("Postorder Traversal for Integer tree: ");
		System.out.println(tree.postorder()+"\n");
		System.out.println("Breadth-First Traversal for Integer tree: ");
		System.out.println(tree.breadthfirst()+"\n");
		
		System.out.println("Reprinting Integer tree: ");
		System.out.println(tree);
		System.out.println("For the next few examples, I am using my 'getNode()' method so I can view nodes that are normally not public (just for testing). \n");
		System.out.println("Is 0 a leaf in the Integer tree?");
		System.out.println(tree.isLeaf(tree.getNode(0)) + "\n");
		System.out.println("Is 7 a leaf in the Integer tree?");
		System.out.println(tree.isLeaf(tree.getNode(7)) + "\n");
		System.out.println("Is 9 a left child of its parent in the Integer tree?");
		System.out.println(tree.isLeftChild(tree.getNode(9)) + "\n");
		System.out.println("Is 9 a right child of its parent in the Integer tree?");
		System.out.println(tree.isRightChild(tree.getNode(0)) + "\n");
		System.out.println("What is the sibling node of 1 in the Integer tree? (The method 'sibling()' returns a BSTNode but for testing I am displaying the value of that node)");
		System.out.println(tree.sibling(tree.getNode(1)).getData()+"\n");
		System.out.println("What is the sibling node of 0 in the Integer tree?");
		System.out.println(tree.sibling(tree.getNode(0))+"\n");
		System.out.println("What is the uncle node of 7 in the Integer tree? (The method 'uncle()' returns a BSTNode but for testing I am displaying the value of that node)");
		System.out.println(tree.uncle(tree.getNode(7)).getData()+"\n");
		System.out.println("What is the uncle node of 5 in the Integer tree?");
		System.out.println(tree.uncle(tree.getNode(5))+"\n");
		System.out.println("What is the grandparent node of 11 in the Integer tree? (The method 'grandparent()' returns a BSTNode but for testing I am displaying the value of that node)");
		System.out.println(tree.grandparent(tree.getNode(11)).getData()+"\n");
		System.out.println("What is the grandparent node of 3 in the Integer tree?");
		System.out.println(tree.grandparent(tree.getNode(3))+"\n");
		
		System.out.println("EXCEPTION HANDLING:");
		System.out.println("Reprinting Integer tree:");
		System.out.println(tree);
		System.out.println("Attempting to insert a null value into the Integer tree:");
		try {
			tree.insert(null);
		} catch (NullPointerException e) {
			System.out.println("Successfully thrown and caught NullPointerException (cannot insert null value into BST)");
		}
		System.out.println();
		
		System.out.println("Attempting to insert a duplicate value into the Integer tree (trying to insert 3 again):");
		try {
			tree.insert(3);
		} catch (DuplicateItemException e) {
			System.out.println("Successfully thrown and caught DuplicateItemException");
		}
		System.out.println();
		
		System.out.println("Attempting to delete a nonexisting value from the Integer tree (trying to delete 500):");
		try {
			tree.delete(500);
		} catch (NullPointerException e) {
			System.out.println("Successfully thrown and caught NullPointerException (cannot delete item that is not in BST)");
		}
		
	}
}
