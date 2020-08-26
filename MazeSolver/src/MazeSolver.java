import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import javafx.geometry.Point2D; 
public class MazeSolver {
	private int height;
	private int width;
	private int xStart;
	private int yStart;
	private boolean unreadableFile = false;
	private String[][] maze;
	Stack<Point2D> stack;

	
	public MazeSolver(File inputFile) {
		this.readFromFile(inputFile);
	}
	
	public void solve(){
		stack = new Stack<Point2D>();
		Point2D start = new Point2D(xStart, yStart);
		stack.push(start);
		int currentX = xStart;
		int currentY = yStart;
		while(!maze[currentX][currentY].equals("E")) {
			//Check left
			if (currentY - 1 >= 0 && (maze[currentX][currentY - 1].equals("1")||maze[currentX][currentY - 1].equals("E"))) {
				maze[currentX][currentY] = "X";
				Point2D current = new Point2D(currentX, currentY-1);
				stack.push(current);
				currentY = currentY - 1;
			}
			// Check down
			else if (currentX + 1 < maze.length && (maze[currentX + 1][currentY].equals("1")|| maze[currentX + 1][currentY].equals("E"))) {
				maze[currentX][currentY] = "X";
				Point2D current = new Point2D(currentX+1, currentY);
				stack.push(current);
				currentX = currentX + 1;
			}
			//Check right
			else if (currentY + 1 < maze[0].length && (maze[currentX][currentY + 1].equals("1")||maze[currentX][currentY + 1].equals("E"))) { 
				maze[currentX][currentY] = "X";
				Point2D current = new Point2D(currentX, currentY+1);
				stack.push(current);
				currentY = currentY + 1;
			} 
			//Check up
			else if (currentX - 1 >= 0 && (maze[currentX - 1][currentY].equals("1")||maze[currentX - 1][currentY].equals("E"))) {
				maze[currentX][currentY] = "X";
				Point2D current = new Point2D(currentX-1, currentY);
				stack.push(current);
				currentX = currentX - 1;
			} 
			//Go back if no options remain
			else {
				Point2D temp = stack.pop();
				
					maze[(int)temp.getX()][(int)temp.getY()] = "B";
					if (stack.isEmpty()) {
						break;
					} else {
						currentX = (int) stack.peek().getX();
						currentY = (int) stack.peek().getY();
					}
					
				
				
				
			}
		}
		maze[xStart][yStart] = "S";
	}
	
	public void readFromFile(File inputFile) {
		try {
			Scanner in  = new Scanner(inputFile);
			String dimensions = in.nextLine(); 
			String[] dims = dimensions.split(" ");
			this.height = Integer.valueOf(dims[0]);
			this.width = Integer.valueOf(dims[1]);
			String coords = in.nextLine();
			String[] cds = coords.split(" ");
			this.xStart = Integer.valueOf(cds[0]);
			this.yStart = Integer.valueOf(cds[1]);
			this.maze = new String[height][width];
			for (int i  = 0; i < this.height; i++) {
				String currentRow = in.nextLine();
				String[] elements = currentRow.split("");
				for (int j = 0; j < this.width; j++) {
					maze[i][j] = elements[j];
				}
			}
			in.close();
		} catch (Exception e) {
			unreadableFile = true;
		}
		
		
	}
	public String[][] getMaze() {
		return this.maze;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public boolean solved() {
		return !stack.isEmpty();
	}
	public boolean unreadable() {
		return unreadableFile;
	}
}
