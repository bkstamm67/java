/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;

import cp120.assignments.geo_shape.TestGeoRectangle.Tester;

/**
 * @author bkstamm67
 *
 */
public class TestGeoShape {
	
	private double epilson = 0.0001;

	public class Tester extends GeoShape {
		
		public Tester() {
			super();
		}
		
		public Tester(GeoPoint origin, Color color) {
			super(origin,color);
		}
		
		public void draw(Graphics2D gtx) {
			
		}
	
	}
	
	
	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#GeoShape()}.
	 */
	@Test
	public void testGeoShape() {
		Tester test = new Tester();
		GeoRectangle actual = new GeoRectangle();
		
		assertEquals(actual.getEdgeColor(),test.getEdgeColor());
		assertEquals(actual.getColor(),test.getColor());
		assertEquals(actual.getEdgeWidth(),test.getEdgeWidth(),epilson);
		assertEquals(actual.getOrigin(),test.getOrigin());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#GeoShape(cp120.assignments.geo_shape.GeoPoint, java.awt.Color)}.
	 */
	@Test
	public void testGeoShapeGeoPointColor() {
		GeoPoint point = new GeoPoint(9.87,5.32);
		Color gray = Color.GRAY;
		Tester test = new Tester(point,gray);
		
		assertEquals(GeoShape.DEFAULT_EDGE_COLOR,test.getEdgeColor());
		assertEquals(gray,test.getColor());
		assertEquals(GeoShape.DEFAULT_EDGE_WIDTH,test.getEdgeWidth(),epilson);
		assertEquals(point,test.getOrigin());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		Color gray = Color.GRAY;
		Tester test = new Tester(null,gray);
	}
	
	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#draw(java.awt.Graphics2D)}.
	 */
	/*
	@Test
	public void testDraw() {
		fail("Not yet implemented");
	}
	*/

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#getOrigin()}.
	 */
	@Test
	public void testGetOrigin() {
		GeoPoint point = new GeoPoint(9.25,4.15);
		Color gray = Color.GRAY;
		Tester test = new Tester(point,gray);

		assertEquals(point,test.getOrigin());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#setOrigin(cp120.assignments.geo_shape.GeoPoint)}.
	 */
	@Test
	public void testSetOrigin() {
		GeoPoint point = new GeoPoint(9.25,4.15);
		
		Tester test = new Tester();
		test.setOrigin(point);

		assertEquals(point,test.getOrigin());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetOriginNullArgument() {
		Tester test = new Tester();
		test.setOrigin(null);
	}
	
	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#setColor(java.awt.Color)}.
	 */
	@Test
	public void testSetColor() {
		Color gray = Color.GRAY;
		Tester test = new Tester();
		test.setColor(gray);
		
		assertEquals(gray,test.getColor());

	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#getColor()}.
	 */
	@Test
	public void testGetColor() {
		Tester test = new Tester();
		
		assertEquals(GeoShape.DEFAULT_COLOR,test.getColor());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#getEdgeColor()}.
	 */
	@Test
	public void testGetEdgeColor() {
		Tester test = new Tester();
		
		assertEquals(GeoShape.DEFAULT_EDGE_COLOR,test.getEdgeColor());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#setEdgeColor(java.awt.Color)}.
	 */
	@Test
	public void testSetEdgeColor() {
		Color gray = Color.GRAY;
		Tester test = new Tester();
		test.setEdgeColor(gray);
		
		assertEquals(gray,test.getEdgeColor());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#getEdgeWidth()}.
	 */
	@Test
	public void testGetEdgeWidth() {
		Tester test = new Tester();
		
		assertEquals(GeoShape.DEFAULT_EDGE_WIDTH,test.getEdgeWidth(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#setEdgeWidth(double)}.
	 */
	@Test
	public void testSetEdgeWidth() {
		Tester test = new Tester();
		double edge = 6.390;
		test.setEdgeWidth(edge);
		
		assertEquals(edge,test.getEdgeWidth(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#setEdge(java.awt.Color, double)}.
	 */
	@Test
	public void testSetEdge() {
		Tester test = new Tester();
		double edge = 6.390;
		Color gray = Color.GRAY;
		test.setEdge(gray,edge);
		
		assertEquals(edge,test.getEdgeWidth(),epilson);
		assertEquals(gray,test.getEdgeColor());
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoShape#toString()}.
	 */
	@Test
	public void testToString() {
		String expected = "origin=(0.0000,0.0000),color=#0000ff,edgeColor=#0000ff,edgeWidth=1.0000";
		Tester test = new Tester();
		String actual = test.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testToStringColorNull() {
		String expected = "origin=(0.0000,0.0000),color=#null,edgeColor=#0000ff,edgeWidth=1.0000";
		Tester test = new Tester();
		test.setColor(null);
		String actual = test.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testToStringAllColorNull() {
		String expected = "origin=(0.0000,0.0000),color=#null,edgeColor=#null,edgeWidth=1.0000";
		Tester test = new Tester();
		test.setColor(null);
		test.setEdgeColor(null);
		String actual = test.toString();
		assertEquals(expected,actual);
	}

}
