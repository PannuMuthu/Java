package application;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.scene.paint.Color;

public class PPMImage {
	private String magicNumber="";
	private String dimensions="";
	private String maxString="";
	private int width;
	private int height;
	private char[][][] raster;
	private char[][][] copyRaster;
	protected File temp = new File("temp.ppm");
	
	public PPMImage(File image) {
		readImage(image);
		setTempFile();
	}
	
	public void writeImage(File filename) {
		try {
			if (!(filename.getName().substring((filename.getName().length()-4), (filename.getName().length())).equals(".ppm"))) {
				throw new NotPPMImageException("Invalid output file");
			}
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filename));
			fos.write(magicNumber.getBytes());
			fos.write('\n');
			fos.write(dimensions.getBytes());
			fos.write('\n');
			fos.write(maxString.getBytes());
			fos.write('\n');
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					for (int rgb =0; rgb<3;rgb++) {
						fos.write(raster[row][col][rgb]);
					}
				}
			}
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public void flipHorizontal() {
		for (int row = 0; row < height; row++) {
			int imageColumn = 0;
			for (int column = width-1; column> imageColumn;column--) {
				for (int rgb = 0; rgb<3; rgb++) {
					char temp = raster[row][column][rgb];
					raster[row][column][rgb] = raster[row][imageColumn][rgb];
					raster[row][imageColumn][rgb] = temp;
				}
				imageColumn++;
			}
			
		}
		setTempFile();
		
	}
	
	public void grayscale() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int r = raster[i][j][0];
				int g = raster[i][j][1];
				int b = raster[i][j][2];
				
				raster[i][j][0]=(char) (r*0.299 + g*0.587 + b*0.114);
				raster[i][j][1]=(char) (r*0.299 + g*0.587 + b*0.114);
				raster[i][j][2]=(char) (r*0.299 + g*0.587 + b*0.114);
			}
		}
		setTempFile();
	}
	
	public void sepia() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int r = raster[i][j][0];
				int g = raster[i][j][1];
				int b = raster[i][j][2];
				
				if((r*0.393 + g*0.769 + b*0.189)>255.0) {
					raster[i][j][0]= 255;
				} 
				else {
					raster[i][j][0]=(char) (r*0.393 + g*0.769 + b*0.189);
				}
				if((r*0.349 + g*0.686 + b*0.168)>255.0) {
					raster[i][j][1]= 255;
				} 
				else {
					raster[i][j][1]=(char) (r*0.349 + g*0.686 + b*0.168);
				}
				if((r*0.272 + g*0.534 + b*0.131)>255.0) {
					raster[i][j][2]= 255;
				} else {
					raster[i][j][2]=(char) (r*0.272 + g*0.534 + b*0.131);
				}
				
			}
		}
		setTempFile();
	}
	
	public void filterRed() {
		for (int  i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				int r = raster[i][j][0];
				int g = raster[i][j][1];
				int b = raster[i][j][2];
				Color color = Color.rgb(r, g, b);
				if (color.getHue()>30.0 && color.getHue()<330.0) {
					raster[i][j][0]=(char) (r*0.299 + g*0.587 + b*0.114);
					raster[i][j][1]=(char) (r*0.299 + g*0.587 + b*0.114);
					raster[i][j][2]=(char) (r*0.299 + g*0.587 + b*0.114);
				} else {
					raster[i][j][0] = copyRaster[i][j][0];
					raster[i][j][1] = copyRaster[i][j][1];
					raster[i][j][2] = copyRaster[i][j][2];
					
				}
			}
		}
		setTempFile();
	}
	
	public void filterColors(double startDegree, double endDegree) {
		for (int  i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				int r = raster[i][j][0];
				int g = raster[i][j][1];
				int b = raster[i][j][2];
				Color color = Color.rgb(r, g, b);
				if (color.getHue()>startDegree && color.getHue()<endDegree) {
					raster[i][j][0] = copyRaster[i][j][0];
					raster[i][j][1] = copyRaster[i][j][1];
					raster[i][j][2] = copyRaster[i][j][2];
				} else {
					raster[i][j][0]=(char) (r*0.299 + g*0.587 + b*0.114);
					raster[i][j][1]=(char) (r*0.299 + g*0.587 + b*0.114);
					raster[i][j][2]=(char) (r*0.299 + g*0.587 + b*0.114);
				}
			}
		}
		setTempFile();
	}
	
	
	
	public void negative() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int r = raster[i][j][0];
				int g = raster[i][j][1];
				int b = raster[i][j][2];
				
				raster[i][j][0]=(char) (255-r);
				raster[i][j][1]=(char) (255-g);
				raster[i][j][2]=(char) (255-b);
			}
		}
		setTempFile();
	}
	
	public void flipVertical() {
		for (int column = 0; column < width; column++) {
			int imageRow = 0;
			for (int row = height-1; row> imageRow;row--) {
				for (int rgb = 0; rgb<3; rgb++) {
					char temp = raster[row][column][rgb];
					raster[row][column][rgb] = raster[imageRow][column][rgb];
					raster[imageRow][column][rgb] = temp;
				}
				imageRow++;
			}
			
		}
		setTempFile();
	}
	
	public void setTempFile() {
		try {
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(temp));
			fos.write(magicNumber.getBytes());
			fos.write('\n');
			fos.write(dimensions.getBytes());
			fos.write('\n');
			fos.write(maxString.getBytes());
			fos.write('\n');
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					for (int rgb =0; rgb<3;rgb++) {
						fos.write(raster[row][col][rgb]);
					}
				}
			}
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void resetImage() {
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				raster[i][j][0]=copyRaster[i][j][0];
				raster[i][j][1]=copyRaster[i][j][1];
				raster[i][j][2]=copyRaster[i][j][2];
			}
		}
		setTempFile();
	}
	
	private void readImage(File image) { 
		int t1;
		int t2;
		
		try {
			if (!(image.getName().substring((image.getName().length()-4), (image.getName().length())).equals(".ppm"))) {
				 throw new NotPPMImageException("Invalid input file");
			}
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(image));
			this.magicNumber = (char)fis.read() + "" + (char)fis.read();
			if (!magicNumber.equals("P6")) {
				fis.close();
				throw new NotPPMImageException("This is not a PPM Image!");
			}
			fis.skip(1);
			while((t1=(char)fis.read())!='\n') {
				 dimensions += (char)t1 + "";
			}
			this.width = Integer.parseInt(dimensions.split(" ")[0]);
			this.height = Integer.parseInt(dimensions.split(" ")[1]);
			
			if (width<=0 || height<=0) {
				fis.close();
				throw new NotPPMImageException("Invalid image dimensions!");
			}
			while((t2=(char)fis.read())!='\n') {
				maxString += (char)t2 + "";
			}
			this.raster = new char[height][width][3];
			
			while (fis.available()!=0) {
				for (int i = 0; i<height; i++) {
					for (int j = 0; j<width; j++) {
						raster[i][j][0] = (char)fis.read();
						raster[i][j][1] = (char)fis.read();
						raster[i][j][2] = (char)fis.read();
					}
				}
			}
			fis.close();
			
			this.copyRaster = new char[height][width][3];
			for (int i = 0; i< height; i ++) {
				for (int j = 0; j <width; j++) {
					copyRaster[i][j][0] = raster[i][j][0];
					copyRaster[i][j][1] = raster[i][j][1];
					copyRaster[i][j][2] = raster[i][j][2];
				}
			}
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
