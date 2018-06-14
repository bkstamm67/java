package cp120.assignments.geo_shape;

import java.awt.Graphics2D;

/*
 * @author bkstamm67
 * This class creates the GeoRectangle, which extends the the parent class of GeoShape.
 */
public class GeoRectangle extends GeoShape{
	
	private double width = 0;
	private double height = 0;

	/*
	 * This is a method that will be developed in later assignments.  Currently, it 
	 * just prints the objects value determined in the toString() method.
	 */
	public void draw(Graphics2D gtx) {
		System.out.printf("Drawing rectangle:\n%s\n", this.toString());
	}
	
	/*
	 * @param double width 
	 * This sets the width variable.
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/*
	 * @param double height
	 * This sets the height variable
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/*
	 * This returns the width of the object
	 */
	public double getWidth() {
		return this.width;
	}
	
	/*
	 * This returns the height of the object
	 */
	public double getHeight() {
		return this.height;
	}
	
	/*
	 * (non-Javadoc)
	 * @see cp120.assignments.geo_shape.GeoShape#toString()
	 */
	public String toString() {
		return String.format("%s,width=%.4f,height=%.4f",super.toString(),this.width,this.height);
	}
	
}
