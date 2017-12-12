/**
 * 
 */
package cp120.assignments.geo_shape;

import static org.junit.Assert.*;

import org.junit.Test;

import cp120.assignments.geo_shape.GeoPoint;

/**
 * @author bkstamm67
 *
 */
public class TestGeoPoint {
	
	private double epilson = 0.0001;
	
	public class TestPoint extends GeoPoint {
		
		public TestPoint() {
			super();
		}
		
		public TestPoint(double a, double b) {
			super(a,b);
		}
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#GeoPoint()}.
	 */
	@Test
	public void testGeoPoint() {
		TestPoint expected = new TestPoint();
		GeoPoint actual = new GeoPoint();
		assertEquals(actual.getXco(),expected.getXco(),epilson);
		assertEquals(actual.getYco(),expected.getYco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#GeoPoint(double, double)}.
	 */
	@Test
	public void testGeoPointDoubleDouble() {
		double x = 23.32;
		double y = 1.24;
		TestPoint expected = new TestPoint(x,y);
		GeoPoint actual = new GeoPoint(x,y);
		assertEquals(actual.getXco(),expected.getXco(),epilson);
		assertEquals(actual.getYco(),expected.getYco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#getXco()}.
	 */
	@Test
	public void testGetXco() {
		double x = 23.32;
		double y = 1.0;
		TestPoint expected = new TestPoint(x,y);
		GeoPoint actual = new GeoPoint(x,y);
		assertEquals(actual.getXco(),expected.getXco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#setXco(double)}.
	 */
	@Test
	public void testSetXco() {
		double x = 76.29;
		double y = 1.0;
		TestPoint expected = new TestPoint(x,y);
		GeoPoint actual = new GeoPoint();
		actual.setXco(x);
		assertEquals(actual.getXco(),expected.getXco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#getYco()}.
	 */
	@Test
	public void testGetYco() {
		double x = 1.0;
		double y = 87.45;
		TestPoint expected = new TestPoint(x,y);
		GeoPoint actual = new GeoPoint(x,y);
		assertEquals(actual.getYco(),expected.getYco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#setYco(double)}.
	 */
	@Test
	public void testSetYco() {
		double x = 1.0;
		double y = 63.92;
		TestPoint expected = new TestPoint(x,y);
		GeoPoint actual = new GeoPoint();
		actual.setYco(y);
		assertEquals(actual.getYco(),expected.getYco(),epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#distance(cp120.assignments.geo_shape.GeoPoint)}.
	 */
	@Test
	public void testDistance() {
		double x = 3.6;
		double y = 54.3;
		GeoPoint test = new GeoPoint();
		double distance = Math.sqrt((Math.pow(x,2) + Math.pow(y, 2)));
		GeoPoint actual = new GeoPoint(x,y);
		assertEquals(actual.distance(test), distance, epilson);
	}

	/**
	 * Test method for {@link cp120.assignments.geo_shape.GeoPoint#toString()}.
	 */
	@Test
	public void testToString() {
		 String expected = "(0.0000,0.0000)";
		 GeoPoint point = new GeoPoint();
		 String actual = point.toString();
		 assertEquals(expected,actual);
		 
		 String expectedTwo = "(2.3456,5.4396)";
		 GeoPoint pointTwo = new GeoPoint(2.3456,5.4396);
		 String actualTwo = pointTwo.toString();
		 assertEquals(expectedTwo,actualTwo);
	}

}
