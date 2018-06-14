/*
 * program:  Box.java (1 of 2)
 * author:  Brian Stamm
 * date:  12.6.16
 * description:  This creates the Box object that has it's
 * basic measurements.  It can return basic descriptors of 
 * its measurements, like volume.
 */

package box;

public class Box {
	private double height;
	private double width;
	private double length;
	
	public Box(){
		height = 1;
		width = 1;
		length = 1;
	}
	
	public Box(double height, double length, double width){
		this.height = height;
		this.length = length;
		this.width = width;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public void setLength(double length){
		this.length = length;
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getVolume(){
		return (height*length*width);
	}
	
	public double getSurfaceArea(){
		return ((2*height*length) + (2*height*width) + (2*length*width));
	}
	
	

}
