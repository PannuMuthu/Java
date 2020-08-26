package hw08;

public class BSTNode<E extends Comparable<E>> {
	protected BSTNode<E> parent;
	protected BSTNode<E> left;
	protected BSTNode<E> right;
	protected char color;
	private E data;
	
	public BSTNode(E data, char color) {
		this.data = data;
		this.color = color;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public char getColor() {
		return color;
	}
	
	public void setColor(char color) {
		this.color = color;
	}
	
	//From Todd Davies answer to printing a BST on StackOverflow
	//https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram/8948691#8948691
	private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
         if(right!=null) {
             right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
         }
         if (this.data == null && this.color == 'B') {
			 sb.append(prefix).append(isTail ? "└── " : "┌── ").append(" NIL ").append("\n");
		 }
         else if (color != 'N') {
        	 sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append("(").append(color).append(")").append("\n");
		 } else if (color == 'N') {
			 sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append("\n");
		 } 
         if(left!=null) {
             left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
         }
         return sb;
    }

    @Override
    public String toString() {
         return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
	
}
