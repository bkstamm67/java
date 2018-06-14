package cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

/**
 * This class creates the GeoOval, which extends the the parent class of
 * GeoRectangle, whose parent is GeoShape.
 * @author bkstamm67
 */
public class GeoOval extends GeoRectangle{
	
	/**
	 * this is the default constructor, not needing any arguments
	 * passing zeros for the initial values
	 */
	public GeoOval() {
		this(0.0,0.0);
	}
	
	/**
	 * this constructor takes the values of height and width passed in
	 * and sends on the default GeoPoint value to the 3 arg constructor
	 * @param double width and height
	 */
	public GeoOval(double width, double height) {
		this(DEFAULT_ORIGIN, width, height);
	}
	
	/**
	 * this constructor takes the values passed in and also passes the 
	 * DEFAULT_COLOR from the super class to the 4 arg constructor
	 * @param double width and height, GeoPoint origin
	 * @throws IllegalArumentException from the super class
	 */
	public GeoOval(GeoPoint origin, double width, double height) throws IllegalArgumentException {
		this(origin, DEFAULT_COLOR, width, height);
	}
	
	/**
	 * this constructor takes all the values passed in and sends those values
	 * to the super class constructor
	 * @param double width and height, GeoPoint origin, Color color
	 * @throws IllegalArumentException from the super class
	 */
	public GeoOval(GeoPoint origin, Color color, double width, double height) throws IllegalArgumentException {
		super(origin, color, width, height);
	}
	
	/**
	 * Using the equation 2*PI*(square of (a^2 + b^2)/2), calculates the 
	 * perimeter of the circle 
	 * @return double answer
	 */
	public double perimeter() {
		double h = getHeight()/2;
		double w = getWidth()/2;
		double a = Math.pow(h,2.0);
		double b = Math.pow(w, 2.0);
		double inside = (a+b)/2;
		inside = Math.sqrt(inside);
		double answer = 2 * Math.PI * inside;
		return answer;
	}
	
	/**
	 * This get the area of the circle and returns it using the
	 * equation height * width * Pi
	 * @return a area
	 */
	public double area() {
		double a = (getHeight()/2) * (getWidth()/2) * Math.PI;
		return a;
	}
	
	/**
	 * This is a method that will be developed in the last assignment.  
	 * It has been commented out to match the current assignment's output,
	 * but has been left as a placeholder.
	 * @param Graphics2D gtx
	 */
	public void draw(Graphics2D gtx) {
		//System.out.printf("Drawing oval:\n%s\n",super.toString());;
		//Get values
		double x = super.getOrigin().getXco();
		double y = super.getOrigin().getYco();
		double width = super.getWidth();
		double height = super.getHeight();
				
		Shape shape = new Arc2D.Double(x, y, width, height, 0, 360, Arc2D.OPEN);
		super.draw(shape, gtx);
		
	}
}
