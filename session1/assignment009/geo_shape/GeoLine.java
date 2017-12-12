package cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * This class creates a GeoLine
 * It consists of two points, the origin and end
 * @author bkstamm67
 */

public class GeoLine extends GeoShape {
	
	GeoPoint end;
	
	/**
	 * Default constructor that does not take any args, 
	 * It passing in two new GeoPoints to the two arg constructor
	 */
	public GeoLine() {
		this(new GeoPoint(), new GeoPoint());
	}
	
	/**
	 * The two arg constructor, that passes a default color to the 3 arg constructor
	 * @param GeoPoint origin, GeoPoint end
	 * @throws IllegalArgumentException from the parent class
	 */
	public GeoLine(GeoPoint origin, GeoPoint end) throws IllegalArgumentException {
		this(origin,DEFAULT_COLOR, end);
	}
	
	/**
	 * This constructor takes all the parameters and creates a line.
	 * @param GeoPoint origin, GeoPoint end, Color color
	 * @throws IllegalArgumentException from the parent class
	 */
	public GeoLine(GeoPoint origin, Color color, GeoPoint end) throws IllegalArgumentException{
		super(origin, color);
		this.end = end;
		
	}
	
	/**
	 * Returns the origin point
	 * @return the GeoPoint origin
	 */
	public GeoPoint getStart() {
		return super.getOrigin();
	}

	/**
	 * Sets the origin point from a GeoPoint that is passed in
	 * @param GeoPoint origin
	 * @throws IllegalArgumentException from the parent class
	 */
	public void setStart(GeoPoint origin) throws IllegalArgumentException {
		super.setOrigin(origin);
	}

	/**
	 * Returns the end point
	 * @return the GeoPoint end
	 */
	public GeoPoint getEnd() {
		return this.end;
	}

	/**
	 * Sets the end point from a GeoPoint that is passed in
	 * @param GeoPoint origin
	 * @throws IllegalArgumentException from the parent class
	 */
	public void setEnd(GeoPoint end) throws IllegalArgumentException {
		this.end = end;
	}

	/**
	 * This gets all the coordinates for both points in GeoLine and
	 * returns the slope, which is (y1 - y2) / (x1 - x2)
	 * @return double answer
	 */
	public double slope() {
		//Get values
		double originX = super.getOrigin().getXco();
		double originY = super.getOrigin().getYco();
		double endX = end.getXco();
		double endY = end.getYco();
		
		//Do math
		double denom = endY - originY;
		double nom = endX - originX;
		double answer = denom/nom;
		
		return answer;
	}

	/**
	 * This uses the distance method in the super class to determine
	 * the distance between the two points in GeoLine
	 * @return double distance
	 */
	public double length() {
		return super.getOrigin().distance(end);
	}

	/**
	 * This method draws the shape of a Line on the Graphics2D passed in.
	 * It takes the x and y coordinates from both the origin and end, drawing
	 * it on Graphics2D passed in.
	 * @param Graphics2D gtx
	 */
	public void draw(Graphics2D gtx) {
		//Get values to create line
		double xOrigin = super.getOrigin().getXco();
		double yOrigin = super.getOrigin().getYco();
		double xEnd = this.end.getXco();
		double yEnd = this.end.getYco();
		
		Shape shape = new Line2D.Double(xOrigin, yOrigin, xEnd, yEnd);
		
		//Set color
		if(super.getColor() != null) {
			gtx.setColor(super.getColor());
		}
		
		//Draw object
		gtx.draw(shape);
	}
	
	/**
	 * This creates a String version of the GeoLine
	 * @return String version of GeoLine
	 */
	public String toString() {
		return String.format("%s,end=%s",super.toString(),this.end);
	}
}
