package cp120.assignments.geo_shape;

import java.awt.Graphics2D;

/*
 * @author bkstamm67
 * This class creates the GeoOval, which extends the the parent class of
 * GeoRectangle, whose parent is GeoShape.
 */
public class GeoOval extends GeoRectangle{
	
	/*
	 * (non-Javadoc)
	 * @see cp120.assignments.geo_shape.GeoRectangle#draw(java.awt.Graphics2D)
	 */
	public void draw(Graphics2D gtx) {
		System.out.printf("Drawing oval:\n%s\n",super.toString());;
	}
	
}
