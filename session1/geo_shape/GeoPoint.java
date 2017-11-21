package cp120.assignments.geo_shape;

/*
 * @author bkstamm67
 * Per assignment, this class encapsulates a point on a plane: xco & yco.
 * Both xco & yco can be viewed similar as a x,y coordinate values. 
 */

public class GeoPoint {
	
	private double xco = 0;
	private double yco = 0;
	
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("(%.4f,%.4f)", this.xco, this.yco);
	}

}
