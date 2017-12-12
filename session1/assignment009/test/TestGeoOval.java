/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.junit.Test;

/**
 * Testing for the GeoOval
 * @author bkstamm67
 */
public class TestGeoOval {
	
	private double epilson = 0.0001;
	
	/**
	 * Creates a Tester object used for testing
	 */
	public class Tester extends GeoOval{
		
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
	
	/**
	 * Test the draw method, asking the user to verify the object has been drawn 
	 */
	@Test
	public void testDraw() {
		Color red = Color.RED;
		Color blue = Color.BLUE;
		GeoPoint point = new GeoPoint(10.0,10.0);
		double edge = 2.0;
		double height = 35;
		double width = 35;
		GeoOval circle = new GeoOval(point,width,height);
		
		circle.setColor(red);
		circle.setEdge(blue, edge);
		
		GeoPlane plane = new GeoPlane();
		plane.addShape(circle);
		
		plane.show();
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is the oval correct?", "Confirm",
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
	 * Test the area method, seeing the value returned is the actual area of a circle
	 */
	@Test
	public void testArea() {
		double height = 4.5;
		double width = 2.25;
		double radiusOne = height/2;
		double radiusTwo = width/2;
		double area = Math.PI * radiusOne * radiusTwo;
		
		GeoOval circle = new GeoOval(width, height);
		
		assertEquals(circle.area(),area,epilson);
	}

	/**
	 * Test the perimeter method, seeing the value returned is the actual perimeter of a circle
	 */
	@Test
	public void testPerimeter() {
		double height = 6.25;
		double width = 3.75;
		double a = height/2;
		double b = width/2;
		double equation = Math.pow(a, 2.0) + Math.pow(b, 2.0);
		equation /=2;
		equation = Math.sqrt(equation);
		double perimeter = Math.PI * equation * 2;
		
		GeoOval circle = new GeoOval(width, height);
		
		assertEquals(circle.perimeter(),perimeter,epilson);
	}

	/**
	 * Test the default constructor
	 */
	@Test
	public void testGeoOval() {
		Tester test = new Tester();
		GeoOval actual = new GeoOval();
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test the constructor where the height and width are passed in
	 */
	@Test
	public void testGeoOvalDoubleDouble() {
		double height = 12.345;
		double width = 87.32;
		Tester test = new Tester(width, height);
		GeoOval actual = new GeoOval(width, height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test the constructor that takes a GeoPoint, width and height
	 */
	@Test
	public void testGeoOvalGeoPointDoubleDouble() {
		double height = 12.345;
		double width = 4.98;
		GeoPoint point = new GeoPoint(3,6);
		Tester test = new Tester(point, width, height);
		GeoOval actual = new GeoOval(point, width, height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test the constructor taking the GeoPoint, color, width and height
	 */
	@Test
	public void testGeoOvalGeoPointColorDoubleDouble() {
		double height = 12.345;
		double width = 4.98;
		GeoPoint point = new GeoPoint(3,6);
		Color green = Color.GREEN;
		Tester test = new Tester(point, green,width, height);
		GeoOval actual = new GeoOval(point, green,width, height);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getHeight(),test.getHeight(),epilson);
		assertEquals(actual.getWidth(),test.getWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

}
