/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import org.junit.Test;

import cp120.assignments.geo_shape.GeoPoint;
import cp120.assignments.geo_shape.GeoRectangle;

/**
 * @author bkstamm67
 *
 */
public class TestGeoRectangle {
	
	private double epilson = 0.0001;

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#draw(java.awt.Graphics2D)}.
	 */
	public class Tester extends GeoRectangle {
		
		public Tester() {
			super();
		}
		
		public Tester(double a, double b) {
			super(a,b);
		}
		
		public Tester(GeoPoint point,double a, double b) {
			super(point,a,b);
		}
		
		public Tester(GeoPoint point,Color color,double a,double b) {
			super(point,color,a,b);
		}
	}
	
	
	@Test
	public void testDraw() {
		Color red = Color.RED;
		Color blue = Color.BLUE;
		GeoPoint point = new GeoPoint(10.0,10.0);
		double edge = 2.0;
		double height = 35;
		double width = 35;
		GeoRectangle rectangle = new GeoRectangle(point,width,height);
		
		rectangle.setColor(red);
		rectangle.setEdge(blue, edge);
		
		GeoPlane plane = new GeoPlane();
		plane.addShape(rectangle);
		
		plane.show();
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is the rectangle correct?", "Confirm",
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
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#toString()}.
	 */
	@Test
	public void testToString() {
		 String expected = "origin=(0.0000,0.0000),color=#0000ff,edgeColor=#0000ff,edgeWidth=1.0000,width=0.0000,height=0.0000";
		 GeoRectangle testRect = new GeoRectangle();
		 String actual = testRect.toString();
		 assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#GeoRectangle()}.
	 */
	@Test
	public void testGeoRectangle() {
		Tester test = new Tester();
		GeoRectangle actual = new GeoRectangle();
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#GeoRectangle(double, double)}.
	 */
	@Test
	public void testGeoRectangleDoubleDouble() {
		double height = 12.5;
		double width = 34.324;
		Tester test = new Tester(width,height);
		GeoRectangle actual = new GeoRectangle(width,height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
		
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#GeoRectangle(cp120.assignments.geo_shape.GeoPoint, double, double)}.
	 */
	@Test
	public void testGeoRectangleGeoPointDoubleDouble() {
		double height = 12.5;
		double width = 34.324;
		GeoPoint point = new GeoPoint(2.0,2.5);
		Tester test = new Tester(point,width,height);
		GeoRectangle actual = new GeoRectangle(point,width,height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#GeoRectangle(cp120.assignments.geo_shape.GeoPoint, java.awt.Color, double, double)}.
	 */
	@Test
	public void testGeoRectangleGeoPointColorDoubleDouble() {
		double height = 12.5;
		double width = 34.324;
		GeoPoint point = new GeoPoint(2.0,2.5);
		Color red = Color.MAGENTA;
		Tester test = new Tester(point,red,width,height);
		GeoRectangle actual = new GeoRectangle(point,red,width,height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#setWidth(double)}.
	 */
	@Test
	public void testSetWidth() {
		GeoRectangle testRect = new GeoRectangle();
		testRect.setWidth(5.5);
		assertEquals(testRect.getWidth(),5.5, epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#setHeight(double)}.
	 */
	@Test
	public void testSetHeight() {
		GeoRectangle testRect = new GeoRectangle();
		testRect.setHeight(3.501);
		assertEquals(testRect.getHeight(),3.501, epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#getWidth()}.
	 */
	@Test
	public void testGetWidth() {
		double t = 2.345;
		GeoRectangle testRect = new GeoRectangle(t, 1.0);
		assertEquals(testRect.getWidth(),t,epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#getHeight()}.
	 */
	@Test
	public void testGetHeight() {
		double t = 2.345;
		GeoRectangle testRect = new GeoRectangle(1.0,t);
		assertEquals(testRect.getHeight(),t,epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#area()}.
	 */
	
	@Test
	public void testArea() {
		double height = 4.0;
		double width = 3.5;
		double area = height * width;
		GeoRectangle testRect = new GeoRectangle(width,height);
		assertEquals(testRect.area(),area,epilson);
	}
	

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoRectangle#perimeter()}.
	 */
	@Test
	public void testPerimeter() {
		double height = 4.0;
		double width = 3.5;
		double perimeter = height + height + width + width;
		GeoRectangle testRect = new GeoRectangle(width,height);
		assertEquals(testRect.perimeter(),perimeter,epilson);
	}

}
