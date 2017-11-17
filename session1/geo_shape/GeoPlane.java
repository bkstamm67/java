package cp120.assignments.geo_shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bkstamm67
 * This is a simple class that contains an instance variable of type List<GeoShape> 
 */
public class GeoPlane {
	
	private List<GeoShape> shapes = new ArrayList<GeoShape>();
	
	/*
	public GeoPlane() {
		this.shapes = new ArrayList<GeoShape>(); 
	}
	*/
	
	/*
	 * @param GeoShape shape
	 * Adds a shape to the list.
	 */
	public void addShape(GeoShape shape) {
		shapes.add(shape);
	}
	/*
	 * @param GeoShape shape
	 * Removes a given shape from a list.
	 */
	public void removeShape(GeoShape shape) {
		shapes.remove(shape);
	}
	
	/*
	 * @param none
	 * Returns the list of shapes
	 */
	public List<GeoShape> getShapes(){
		return this.shapes;
	}
	
	/*
	 * This method traverses the list.
	 */
	public void redraw() {
		for(GeoShape shape: shapes) {
			shape.draw(null);
		}
	}
	
}
