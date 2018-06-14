/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Tests the GeoPlane
 * @author bkstamm67
 */
public class TestGeoPlane {

	/**
	 * Test the run method, asking the user if a plane was created.  
	 * This also tests the default constructor since no GeoShapes have been
	 * added to the GeoPlane or a custom color was set
	 */
	@Test
	public void testRun() {
		GeoPlane plane = new GeoPlane();
		plane.run();
		
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is there a blank, gray plane?", "Confirm",
	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	    	answer = -1;
	    	} 
	    else if (response == JOptionPane.YES_OPTION) {
	          answer = 1;
	        } 
	    else if (response == JOptionPane.CLOSED_OPTION) {
	          answer = 0;
	    }
	    
	    assertEquals(answer,1);
	}

	/**
	 * Tests the constructor taking a color, using a different color than the default
	 * It also asks user if the plane is the color passed in
	 */
	@Test
	public void testGeoPlaneColor() {
		Color orange = Color.ORANGE;
		GeoPlane plane = new GeoPlane(orange);
		
		plane.show();
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is the plane orange or marigold?", "Confirm",
	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	    	answer = -1;
	    	} 
	    else if (response == JOptionPane.YES_OPTION) {
	          answer = 1;
	        } 
	    else if (response == JOptionPane.CLOSED_OPTION) {
	          answer = 0;
	    }
	    
	    assertEquals(answer,1);
		
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPlane#addShape(cp120.assignments.geo_shape.GeoShape)}.
	 */
	@Test
	public void testAddShape() {
				
		GeoRectangle rectangle = new GeoRectangle();
		GeoPlane plane = new GeoPlane();
		plane.addShape(rectangle);
		List<GeoShape> shapes = plane.getShapes();
		assertEquals(1,shapes.size());
		assertEquals(rectangle,shapes.get(0));
		
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPlane#removeShape(cp120.assignments.geo_shape.GeoShape)}.
	 */
	@Test
	public void testRemoveShape() {
		GeoRectangle rectangle = new GeoRectangle();
		GeoPlane plane = new GeoPlane();
		plane.addShape(rectangle);
		plane.removeShape(rectangle);
		List<GeoShape> shapes = plane.getShapes();
		assertEquals(0,shapes.size());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPlane#getShapes()}.
	 */
	@Test
	public void testGetShapes() {
		GeoRectangle rectangle = new GeoRectangle();
		GeoOval circle = new GeoOval();
		GeoLine line = new GeoLine();
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(rectangle);
		plane.addShape(circle);
		plane.addShape(line);
		
		List<GeoShape> shapes = plane.getShapes();
		assertEquals(3,shapes.size());
		assertEquals(rectangle,shapes.get(0));
		assertEquals(circle,shapes.get(1));
		assertEquals(line,shapes.get(2));
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPlane#redraw()}.
	 */
	@Test
	public void testRedraw() {
		GeoRectangle rectangle = new GeoRectangle(15.0,15.0);
		GeoOval circle = new GeoOval(new GeoPoint(150,150),30,30);
		GeoLine line = new GeoLine(new GeoPoint(300,300), new GeoPoint(400,450));
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(rectangle);
		plane.addShape(circle);
		plane.addShape(line);
		
		plane.redraw();
		
		plane.show();
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is there a rectangle, circle, and line on"
	    		+ " the plane?", "Confirm",
	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	    	answer = -1;
	    	} 
	    else if (response == JOptionPane.YES_OPTION) {
	          answer = 1;
	        } 
	    else if (response == JOptionPane.CLOSED_OPTION) {
	          answer = 0;
	    }
	    
	    assertEquals(answer,1);
	}

}
