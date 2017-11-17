package cp120.assignments.geo_shape;

/*
 * public class GeoPoint
This class encapsulates a point in a plane: (xco, yco). This plane is very similar to the Cartesian plane, 
but the origin of the plane is its upper left-hand corner and y-values increase as you move downwards. Your 
class should have two fields of type double for storing the x- and y-coordinate values; their initial values 
must be 0. It will have the following methods:

public double getXco()
This is the getter for the encapsulated x-coordinate.

public void setXco( double xco )
This is the setter for the encapsulated x-coordinate.

public double getYco()
This is the getter for the encapsulated y-coordinate.

public void setYco( double yco )
This is the setter for the encapsulated y-coordinate.

public double distance( GeoPoint other )

This method calculates the distance between itself and another GeoPoint. The formula for finding the distance between two points can be found on the Math is Fun (Links to an external site.)Links to an external site. Website.

public String toString()
 */
/*
 * @author bkstamm67
 * Per assignment, this class encapsulates a point on a plane: xco & yco.
 * Both xco & yco can be viewed similar as a x,y coordinate values. 
 */

public class GeoPoint {
	
	private double xco = 0;
	private double yco = 0;
	
	/*
	public GeoPoint() {
		setXco(0);
		setYco(0);
	}
	
	public GeoPoint(int x, int y) {
		setXco(x);
		setYco(y);
	}
	*/
	
	/*
	 * This is the getter for the xco variable
	 */
	public double getXco() {
		return xco;
	}
	
	/*
	 * @param double xco
	 * This takes a double and sets the xco variable 
	 */
	public void setXco(double xco) {
		this.xco = xco;
	}
	/*
	 * This is the getter for the yco variable
	 */
	public double getYco() {
		return yco;
	}
	
	/*
	 * @param double yco
	 * This takes a double and sets the yco variable 
	 */
	public void setYco(double yco) {
		this.yco = yco;
	}
	
	/*
	 * @param GeoPoint other
	 * This takes in another GeoPoint instance and uses the Pythagorean theorem 
	 * to calculate the distance between the points, returning a double.
	 */
	public double distance(GeoPoint other) {
		double c = 0;
		double a = (this.getXco()) - (other.getXco());
		double b = (this.getYco()) - (other.getYco());
		a = Math.pow(a, 2.0);
		b = Math.pow(b, 2.0);
		c = a + b;
		c = Math.sqrt(c);
		return c;
	}
	
	
	public String toString() {
		return String.format("(%.4f,%.4f)", this.xco, this.yco);
	}
	
/*
	public boolean equals(GeoPoint other) {
		boolean truth = true;
		if((other.getXco() == this.xco) && (other.getYco() == this.getYco())) {
			truth = true;
		}
		return truth;
	}*/

}
