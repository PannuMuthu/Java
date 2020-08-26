import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RecursiveArt {
	 private ArrayList<Rectangle> finalRectangleArray = new ArrayList<Rectangle>();
	 private double baseFraction;
	 private int levelOfSubdivisions;
	
	 
	 public RecursiveArt(Rectangle mainRectangle, double baseFraction, int levelOfSubdivisions) {
		 this.baseFraction = baseFraction;
		 this.levelOfSubdivisions = levelOfSubdivisions;
		 this.finalRectangleArray = RectangleArtRecurse(mainRectangle, baseFraction, levelOfSubdivisions);

	 }
	 
	 public ArrayList<Rectangle> RectangleArtRecurse (Rectangle inputRectangle, double baseFraction, int subdivs) {
		 Random random = new Random();
		 ArrayList<Rectangle> outRectangleArray = new ArrayList<Rectangle>();
		 //Base case 1
		 if (subdivs == 1 && inputRectangle.getWidth() > inputRectangle.getHeight()) {
			 double miniRectangleWidthDiv = inputRectangle.getWidth()*((random.nextInt((int)(1/baseFraction)-1)+1)*baseFraction);
			 Rectangle r1 = new Rectangle();
			 Rectangle r2 = new Rectangle();
			 r1.setX(inputRectangle.getX());
			 r1.setY(inputRectangle.getY());
			 r1.setStroke(Color.BLACK);
			 r1.setStrokeWidth(1);
			 r1.setWidth(miniRectangleWidthDiv);
			 r1.setHeight(inputRectangle.getHeight());
			 double r1area = r1.getWidth()*r1.getHeight();
			 r1.setFill(Color.hsb((r1area % 361), 1, 1));
			 r2.setX(inputRectangle.getX() + miniRectangleWidthDiv);
			 r2.setY(inputRectangle.getY());
			 r2.setStroke(Color.BLACK);
			 r2.setStrokeWidth(1);
			 r2.setWidth(inputRectangle.getWidth()-miniRectangleWidthDiv);
			 r2.setHeight(inputRectangle.getHeight());
			 double r2area = r2.getWidth()*r2.getHeight();
			 r2.setFill(Color.hsb((r2area % 361), 1, 1));
			 outRectangleArray.add(r1);
			 outRectangleArray.add(r2);

			 return outRectangleArray;
		 } 
		 //Base case 2
		 else if (subdivs == 1 && inputRectangle.getWidth() < inputRectangle.getHeight()) { 
			 double miniRectangleHeightDiv = inputRectangle.getHeight()*((random.nextInt((int)(1/baseFraction)-1)+1)*baseFraction);
			 Rectangle r1 = new Rectangle();
			 Rectangle r2 = new Rectangle();
			 r1.setX(inputRectangle.getX());
			 r1.setY(inputRectangle.getY());
			 r1.setStroke(Color.BLACK);
			 r1.setStrokeWidth(1);
			 r1.setWidth(inputRectangle.getHeight());
			 r1.setHeight(miniRectangleHeightDiv);
			 double r1area = r1.getWidth()*r1.getHeight();
			 r1.setFill(Color.hsb((r1area % 361), 1, 1));
			 r2.setX(inputRectangle.getX());
			 r2.setY(inputRectangle.getY() + miniRectangleHeightDiv);
			 r2.setStroke(Color.BLACK);
			 r2.setStrokeWidth(1);
			 r2.setWidth(inputRectangle.getWidth());
			 r2.setHeight(inputRectangle.getHeight() - miniRectangleHeightDiv);
			 double r2area = r2.getWidth()*r2.getHeight();
			 r2.setFill(Color.hsb((r2area % 361), 1, 1));
			 outRectangleArray.add(r1);
			 outRectangleArray.add(r2);

			 return outRectangleArray;
		 }
		 //Recursive Case 1
		 else if (inputRectangle.getWidth() > inputRectangle.getHeight()){  
			 double miniRectangleWidthDiv = inputRectangle.getWidth()*((random.nextInt((int)(1/baseFraction)-1)+1)*baseFraction);
			 Rectangle r1 = new Rectangle();
			 Rectangle r2 = new Rectangle();
			 r1.setX(inputRectangle.getX());
			 r1.setY(inputRectangle.getY());
			 r1.setStroke(Color.BLACK);
			 r1.setStrokeWidth(1);
			 r1.setWidth(miniRectangleWidthDiv);
			 r1.setHeight(inputRectangle.getHeight());
			 double r1area = r1.getWidth()*r1.getHeight();
			 r1.setFill(Color.hsb((r1area % 361), 1, 1));
			 r2.setX(inputRectangle.getX() + miniRectangleWidthDiv);
			 r2.setY(inputRectangle.getY());
			 r2.setStroke(Color.BLACK);
			 r2.setStrokeWidth(1);
			 r2.setWidth(inputRectangle.getWidth()-miniRectangleWidthDiv);
			 r2.setHeight(inputRectangle.getHeight());
			 double r2area = r2.getWidth()*r2.getHeight();
			 r2.setFill(Color.hsb((r2area % 361), 1, 1));
			 outRectangleArray.addAll(RectangleArtRecurse(r1, baseFraction, subdivs-1));
			 outRectangleArray.addAll(RectangleArtRecurse(r2, baseFraction, subdivs-1));
			 return outRectangleArray;
		 } 
		 //Recursive Case 2
		 else {
			 double miniRectangleHeightDiv = inputRectangle.getHeight()*((random.nextInt((int)(1/baseFraction)-1)+1)*baseFraction);
			 Rectangle r1 = new Rectangle();
			 Rectangle r2 = new Rectangle();
			 r1.setX(inputRectangle.getX());
			 r1.setY(inputRectangle.getY());
			 r1.setStroke(Color.BLACK);
			 r1.setStrokeWidth(1);
			 r1.setHeight(miniRectangleHeightDiv);
			 r1.setWidth(inputRectangle.getWidth());
			 r2.setX(inputRectangle.getX());
			 r2.setStroke(Color.BLACK);
			 r2.setStrokeWidth(1);
			 r2.setY(inputRectangle.getY() + miniRectangleHeightDiv);
			 r2.setHeight(inputRectangle.getHeight() - miniRectangleHeightDiv);
			 r2.setWidth(inputRectangle.getWidth());
			 outRectangleArray.addAll(RectangleArtRecurse(r1, baseFraction, subdivs-1));
			 outRectangleArray.addAll(RectangleArtRecurse(r2, baseFraction, subdivs-1));

			 return outRectangleArray;
		 }
	 }
	 
	 public ArrayList<Rectangle> getArray(){
		 return finalRectangleArray;
	 }
}
