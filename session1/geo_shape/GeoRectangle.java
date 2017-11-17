package cp120.assignments.geo_shape;

import java.awt.Graphics2D;

/*
 * public class GeoRectangle extends GeoShape
This class encapsulates a rectangle as defined by its upper left-hand corner, width and height. Your class 
should have two fields of type double for storing the width and the height; the initial values for these 
fields must be 0. It will have the following methods:

public void draw( Graphics2D gtx )
This method is required to be implemented by every subclass of GeoShape. For now, it simply prints Drawing 
rectangle: followed by a single space and the object itself. For example, if a rectangle has an origin of 
(10.02,10.03), a width of 6.6, a height of 5.5, and a color of yellow, this method will print:

Drawing rectangle: origin=(10.0200,10.0300),color=#ff00ff,width=6.6000,height=5.5000
To format the tail of the string (beginning with origin=), use the toString method.

public void setWidth( double width )
This is the setter for the encapsulated width

public double getWidth()
This is the getter for the encapsulated width.

public void setHeight( double height )
This is the setter for the encapsulated height

public double getHeight()
This is the getter for the encapsulated height.

public String toString()
This method overrides GeoShape.toString. It returns a string in the format origin=(xco,yco),color=
#cccccc,width=width, height=height. To format the first part of the string, use super.toString. All 
floating point values must be formatted with a precision of exactly four digits to the right of the 
decimal point. For example, given a GeoRectangle with these properties:
 */

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
		System.out.printf("Drawing rectangle:  %s", this.toString());
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
	

	public String toString() {
		return String.format("%s,width=%.4f,height=%.4f",super.toString(),this.width,this.height);
	}
	
	@Override
	public boolean equals(Object other) {
		boolean truth = true;
		return truth;
	}
	/*
	public boolean equals(GeoPoint other) {
		boolean truth = true;
		/*if((other.getXco() == this.xco) && (other.getYco() == this.getYco())) {
			truth = true;
		}
		return truth;
	}
	*/

	
}
