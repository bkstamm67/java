package cp120.assignments.geo_shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;


/**
 * This class creates the GeoRectangle, which extends the the parent class of GeoShape.
 * @author bkstamm67
 */
public class GeoRectangle extends GeoShape{
	
	private double width;
	private double height;

	/**
	 * This is the default constructor, passing in zero for both
	 * width and height
	 */
	public GeoRectangle() {
		this(0.0, 0.0);
	}
	
	/**
	 * This constructor takes in two doubles and passing them
	 * along with the DEFAULT_ORIGIN to the 3 arg constructor
	 * @param width, height
	 */
	public GeoRectangle(double width, double height) {
		this(DEFAULT_ORIGIN, width, height);
	}
	
	/**
	 * This constructor takes in two doubles and a GeoPoint and passing them
	 * along with the DEFAULT_COLOR to the 4 arg constructor
	 * @param origin, width, height
	 * @throws IllegalArgumentException
	 */
	public GeoRectangle( GeoPoint origin, double width, double height ) throws IllegalArgumentException {
		this(origin,DEFAULT_COLOR,width,height);
	}
	
	/**
	 * This constructor takes in two doubles, a GeoPoint, and a
	 * Color and passing them.  It uses the super constructor
	 * from GeoShape and then sets the width & height through the setters
	 * @param origin, color, width, height
	 * @throws IllegalArgumentException
	 */
	public GeoRectangle( GeoPoint origin, Color color, double width, double height ) throws IllegalArgumentException {
		super(origin, color);
		setWidth(width);
		setHeight(height);
	}
	
	/** 
	 * This sets the width variable
	 * @param double width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * This sets the height variable
	 * @param double height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * This returns the width of the object
	 * @return double width
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * This returns the height of the object
	 * @return double height
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * This finds the area of the rectangle by multiplying the
	 * height by the width
	 * @return area of object
	 */
	public double area() {
		double rectangleArea = this.height * this.width;
		return rectangleArea;
	}
	
	/**
	 * This finds the perimeter of the rectangle by adding two width sides
	 * and two height sides
	 * @return perimeter of object
	 */
	public double perimeter() {
		double rectanglePerimeter = (this.height *2) + (2 * this.width);
		return rectanglePerimeter;
	}
	
	/**
	 * This takes in the Graphic2D gtx arg and draws the rectangle based
	 * on the values of the object.  If it has a color or edge values, those
	 * will also be drawn
	 * @param Graphics2D gtx
	 */
	public void draw(Graphics2D gtx) {
		//Get values
		double x = super.getOrigin().getXco();
		double y = super.getOrigin().getYco();
		
		Shape shape = new Rectangle2D.Double(x,y,this.width,this.height);
		
		/*
		//Set color
		if(super.getColor() != null) {
			gtx.setColor(super.getColor());
			gtx.fill(shape);
		}
		
		//Set edge colors and width
		if((super.getEdgeColor() != null) && (super.getEdgeWidth() > 0)){
			BasicStroke basic = new BasicStroke((float)super.getEdgeWidth());
			gtx.setStroke(basic);
			gtx.setPaint(super.getEdgeColor());
		}
		
		gtx.draw(shape);
		*/
		super.draw(shape, gtx);
	}

	/**
	 * This creates a String version of the GeoRectangle
	 * @return String version of GeoRectangle
	 */
	public String toString() {
		return String.format("%s,width=%.4f,height=%.4f",super.toString(),this.width,this.height);
	}
	
	/**
	 *
	 */
	/*
	@Override(non-Javadoc)
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj == null) {
			result = false;
		}
		else if(this == obj) {
			result = true;
		}
		else if(!(obj instanceof GeoRectangle)) {
			result = false;
		}
		else {
			GeoRectangle other = (GeoRectangle)obj;
			if((Double.compare(other.getHeight(), this.getHeight())) != 0) {
				result = false;
			}
			else{
				result = true;
			}
			if((Double.compare(other.getWidth(), this.getWidth())) != 0) {
				result = false;
			}
			else{
				result = true;
			}
			
			
			
		}
		
		return result;
	}
	*/
}
