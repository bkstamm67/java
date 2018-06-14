package cp120.assignments.geo_shape;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Formatter;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 * This is the superclass for this assignment which stores a GeoPoint and color.  
 * @author bkstamm67
 */
public abstract class GeoShape {
	
	private GeoPoint origin;
	private Color color;
	private double edgeWidth = DEFAULT_EDGE_WIDTH;
	private Color edgeColor	= DEFAULT_EDGE_COLOR;
	
	public static final Color DEFAULT_COLOR = Color.BLUE;
	public static final Color DEFAULT_EDGE_COLOR = Color.BLUE;
	public static final double DEFAULT_EDGE_WIDTH = 1;
	public static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint(0, 0);

	
	/**
	 * Default constructor, takes no args and sets the the origin and
	 * color to default values
	 */
	public GeoShape() {
		setOrigin(DEFAULT_ORIGIN);
		setColor(DEFAULT_COLOR);
	}
	
	/**
	 * this takes in a GeoPoint and Color.  GeoPoint cannot be null
	 * @param Geopoint Color
	 * @throws IllegalArgumentException
	 */
	public GeoShape(GeoPoint origin, Color color) throws IllegalArgumentException {
		if(origin == null) {
			throw new IllegalArgumentException();
		}
		else {
			setOrigin(origin);
			setColor(color);
		}
	}
	
	/**
	 * This is a method that will be developed in later assignments.  Currently, it 
	 * just prints the objects value determined in the toString() method.
	 * @param Graphics2D gtx
	 */
	public abstract void draw(Graphics2D gtx);
	
	/**
	 * This is a method that will be developed in later assignments.  Currently, it 
	 * just prints the objects value determined in the toString() method.
	 * @param Graphics2D gtx
	 */
	public void draw(Shape shape,Graphics2D gtx) {
			
		if(this.getColor() != null) {
			gtx.setColor(this.getColor());
			gtx.fill(shape);
		}
		
		if((this.getEdgeColor() != null) && (this.getEdgeWidth() > 0)){
			BasicStroke basic = new BasicStroke((float)this.getEdgeWidth());
			gtx.setStroke(basic);
			gtx.setPaint(this.getEdgeColor());
		}
		
		gtx.draw(shape);	
	}
	
	/**
	 * This is a getter that returns the value of the GeoPoint origin.
	 * @return Origin
	 */
	public GeoPoint getOrigin() {
		return this.origin;
	}
	
	/**
	 * This is the setter for origin.
	 * @param GeoPoint origin
	 * @throws IllegalArgumentException
	 */
	public void setOrigin( GeoPoint origin ) throws IllegalArgumentException{
		if(origin == null) {
			throw new IllegalArgumentException();
		}
		else {
			this.origin = origin;
		}
	}
	
	/**
	 * This takes an argument of color and sets the shape's color.
	 * @param Color color
	 */
	public void setColor( Color color ) {
		this.color = color;
	}
	
	/**
	 * This is the getter for the GeoShape's color.
	 * @return Color color 
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * This returns the edgeColor variable
	 * @return variable edgeColor
	 */
	public Color getEdgeColor() {
		return edgeColor;
	}

	/**
	 * This sets the variable edgeColor
	 * @param color
	 */
	public void setEdgeColor(Color color) {
		this.edgeColor = color;
	}
	
	/**
	 * This returns the edgeWidth variable
	 * @return edgeWidth
	 */
	public double getEdgeWidth() {
		return edgeWidth;
	}
	
	/**
	 * This sets the edgeWidth variable
	 * @param edgeWidth
	 */
	public void setEdgeWidth(double edgeWidth) {
		this.edgeWidth = edgeWidth;
	}
	
	/**
	 * This sets both the edge color and width by calling
	 * the setters for both
	 * @param color
	 * @param width
	 */
	public void setEdge(Color color, double width) {
		setEdgeWidth(width);
		setEdgeColor(color);
	}

	/**
	 * This creates a String version of the GeoRectangle
	 * @return String version of GeoRectangle
	 */
	public String toString() {
		Formatter formatter = new Formatter();
		int edge;
		int rgb;
		if(this.color != null && this.edgeColor != null) {
			rgb = this.color.getRGB() & 0x00ffffff;
			edge = this.edgeColor.getRGB() & 0x00ffffff;
			formatter.format("origin=%s,color=#%06x,edgeColor=#%06x,edgeWidth=%.4f",
					origin.toString(),rgb, edge, getEdgeWidth());
		}
		else if (this.edgeColor != null){
			edge = this.edgeColor.getRGB() & 0x00ffffff;
			formatter.format("origin=%s,color=#null,edgeColor=#%06x,edgeWidth=%.4f",
					origin.toString(),edge, getEdgeWidth());;	
		}
		else {
			formatter.format("origin=%s,color=#null,edgeColor=#null,edgeWidth=%.4f",
					origin.toString(),getEdgeWidth());;			
		}
		String answer = formatter.toString();
		formatter.close();
		return answer;
	}
	
}
