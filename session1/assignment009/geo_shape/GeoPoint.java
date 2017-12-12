package cp120.assignments.geo_shape;

/**
 * Per assignment, this class encapsulates a point on a plane: xco & yco.
 * Both xco & yco can be viewed similar as a x,y coordinate values. 
 * @author bkstamm67
 */

public class GeoPoint {
	
	private double xco;
	private double yco;
	
	/**
	 * Default constructor that sets both coordinates at 0
	 */
	public GeoPoint() {
		setXco(0);
		setYco(0);
	}
	
	/**
	 * Takes two arguments, setting both xco and yco
	 * @param double xco, double yco
	 */
	public GeoPoint(double xco, double yco) {
		setXco(xco);
		setYco(yco);
	}
	
	/**
	 * This is the getter for the xco variable
	 * @return xco
	 */
	public double getXco() {
		return xco;
	}
	
	/**
	 * This takes a double and sets the xco variable
	 * @param double xco 
	 */
	public void setXco(double xco) {
		this.xco = xco;
	}
	
	/**
	 * This is the getter for the yco variable
	 * @return yco
	 */
	public double getYco() {
		return yco;
	}
	
	/**
	 * This takes a double and sets the yco variable 
	 * @param double yco
	 */
	public void setYco(double yco) {
		this.yco = yco;
	}
	
	/**
	 * This takes in another GeoPoint instance and uses the Pythagorean theorem 
	 * to calculate the distance between the points, returning a double.
	 * @param GeoPoint other
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
	
	/**
	 * This creates a String version of the GeoPoint
	 * @return String version of GeoPoint
	 */
	public String toString() {
		return String.format("(%.4f,%.4f)", this.xco, this.yco);
	}
}
