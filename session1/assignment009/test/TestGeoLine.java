/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.junit.Test;

import cp120.assignments.geo_shape.TestGeoRectangle.Tester;

/**
 * Testing class for GeoLine
 * @author bkstamm67
 */
public class TestGeoLine {
	
	private double epilson = 0.0001;

	/**
	 * This class is used for testing, to compare objects.
	 */
	public class Tester extends GeoLine {
		
		public Tester() {
			super();
		}
		
		public Tester(GeoPoint a, GeoPoint b) {
			super(a,b);
		}
		
		public Tester(GeoPoint a,Color color, GeoPoint b) {
			super(a,color,b);
		}	
	}
	

	/**
	 * This tests the draw method in GeoLine.  It will ask user to confirm
	 */
	@Test
	public void testDraw() {
		Color red = Color.RED;
		GeoPoint start = new GeoPoint(10.0,10.0);
		GeoPoint end = new GeoPoint(50.0,30.0);
		GeoLine line = new GeoLine(start,red,end);
		
		GeoPlane plane = new GeoPlane();
		plane.addShape(line);
		
		plane.show();
		int answer = 0;
	    int response = JOptionPane.showConfirmDialog(null, "Is there a red line?", "Confirm",
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
	 * Test the toString() for the GeoLine class.
	 */
	@Test
	public void testToString() {
		 String expected = "origin=(0.0000,0.0000),color=#0000ff,edgeColor=#0000ff,edgeWidth=1.0000,end=(0.0000,0.0000)";
		 GeoLine testLine = new GeoLine();
		 String actual = testLine.toString();
		 assertEquals(expected,actual);
	}

	/**
	 * Tests the default constructor, using the Tester class.
	 */
	@Test
	public void testGeoLine() {
		Tester test = new Tester();
		GeoLine actual = new GeoLine();
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getStart().getXco(),test.getStart().getXco(),epilson);
		assertEquals(actual.getStart().getYco(),test.getStart().getYco(),epilson);
		assertEquals(actual.getEnd().getXco(),test.getEnd().getXco(),epilson);
		assertEquals(actual.getEnd().getYco(),test.getEnd().getYco(),epilson);
	}

	/**
	 * Tests the constructor that takes two GeoPoints
	 */
	@Test
	public void testGeoLineGeoPointGeoPoint() {
		GeoPoint one = new GeoPoint(1.5,2.5);
		GeoPoint two = new GeoPoint(3.5,4.5);
		Tester test = new Tester(one, two);
		GeoLine actual = new GeoLine(one, two);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getStart().getXco(),test.getStart().getXco(),epilson);
		assertEquals(actual.getStart().getYco(),test.getStart().getYco(),epilson);
		assertEquals(actual.getEnd().getXco(),test.getEnd().getXco(),epilson);
		assertEquals(actual.getEnd().getYco(),test.getEnd().getYco(),epilson);
	}

	/**
	 * Tests the constructor that takes two GeoPoints and a color
	 */
	@Test
	public void testGeoLineGeoPointColorGeoPoint() {
		GeoPoint one = new GeoPoint(1.5,2.5);
		GeoPoint two = new GeoPoint(3.5,4.5);
		Color pink = Color.PINK;
		Tester test = new Tester(one,pink,two);
		GeoLine actual = new GeoLine(one,pink,two);
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getStart().getXco(),test.getStart().getXco(),epilson);
		assertEquals(actual.getStart().getYco(),test.getStart().getYco(),epilson);
		assertEquals(actual.getEnd().getXco(),test.getEnd().getXco(),epilson);
		assertEquals(actual.getEnd().getYco(),test.getEnd().getYco(),epilson);
		assertEquals(actual.getStart(),test.getStart());
	}

	/**
	 * Tests to see if getStart() method works, comparing the GeoPoint and the
	 * Tester object
	 */
	@Test
	public void testGetStart() {
		GeoPoint one = new GeoPoint(1.751,2.598);
		GeoPoint two = new GeoPoint(3.514,4.556);
		Tester test = new Tester(one, two);
		GeoLine actual = new GeoLine(one, two);
		
		assertEquals(actual.getStart(),test.getStart());
		assertEquals(actual.getStart(),one);

	}

	/**
	 * Tests the setStart() method by passing in a GeoPoint, changing the default value
	 */
	@Test
	public void testSetStart() {
		GeoPoint one = new GeoPoint(1.751,2.598);
		GeoPoint two = new GeoPoint(3.514,4.556);
		Tester test = new Tester();
		GeoLine actual = new GeoLine(one, two);
		test.setStart(one);
		
		assertEquals(actual.getStart(),test.getStart());
	}

	/**
	 * Tests the method for getEnd, by both comparing the Tester object and
	 * a GeoPoint
	 */
	@Test
	public void testGetEnd() {
		GeoPoint one = new GeoPoint(1.751,2.598);
		GeoPoint two = new GeoPoint(3.514,4.556);
		Tester test = new Tester(one, two);
		GeoLine actual = new GeoLine(one, two);
		
		assertEquals(actual.getEnd(),test.getEnd());
		assertEquals(actual.getEnd(),two);
	}

	/**
	 * Test the setEnd() method, by changing the default value for the 
	 * Tester object
	 */
	@Test
	public void testSetEnd() {
		GeoPoint one = new GeoPoint(1.751,2.598);
		GeoPoint two = new GeoPoint(3.514,4.556);
		Tester test = new Tester();
		GeoLine actual = new GeoLine(one, two);
		test.setEnd(two);
		
		assertEquals(actual.getEnd(),test.getEnd());
	}

	/**
	 * Test the slope method
	 */
	@Test
	public void testSlope() {
		GeoPoint one = new GeoPoint(1.5,2.5);
		GeoPoint two = new GeoPoint(6.5,5.75);
		Tester test = new Tester(one,two);
		GeoLine actual = new GeoLine(one, two);
		
		assertEquals(actual.slope(),test.slope(),epilson);
		

	}

	/**
	 * Test the length() method
	 */
	@Test
	public void testLength() {
		GeoPoint one = new GeoPoint(1.5,2.5);
		GeoPoint two = new GeoPoint(6.5,5.75);
		Tester test = new Tester(one,two);
		GeoLine actual = new GeoLine(one, two);
		
		assertEquals(actual.length(),test.length(),epilson);
	}

}
