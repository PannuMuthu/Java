package array2d;

public class Array2DNode<E extends Comparable<E>> {
	protected E data;
	protected Array2DNode<E> nextRow;
	protected Array2DNode<E> nextCol;
	protected Array2DNode<E> prevRow;
	protected Array2DNode<E> prevCol;
	
	public Array2DNode() {
		this.data = null;
	}
	
	public Array2DNode(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		if (this.data == null) {
			return "null";
		} else {
			return this.data.toString();
		}
	}
	

}
