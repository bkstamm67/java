package cp120.assignments.geo_shape;

import java.awt.Graphics2D;
import java.awt.Color;

/*
 * @author bkstamm67
 * This is the superclass for this assignment which stores a GeoPoint and color.  
 */
public abstract class GeoShape {
	
	private GeoPoint origin;
	private Color color;
	
	/*
	 * This method method must be implemented by every concrete subclass of GeoShape.
	 */
	public abstract void draw(Graphics2D gtx);
	
	/*
	 * This is a getter that returns the value of the GeoPoint origin.
	 */
	public GeoPoint getOrigin() {
		if(this.origin == null) {	
			this.origin = new GeoPoint();
		}
		return origin;
	}
	
	/*
	 * @param GeoPoint origin
	 * @throws IllegalArgumentException
	 * This is the setter for
	 */
	public void setOrigin( GeoPoint origin ) throws IllegalArgumentException{
		if(origin == null) {
			throw new IllegalArgumentException();
		}
		this.origin = origin;
	}
	
	/*
	 * @param Color color
	 * This takes an argument of color and sets the shape's color.
	 */
	public void setColor( Color color ) {
		this.color = color;
	}
	
	/*
	 * This is the getter for the GeoShape's color. 
	 */
	public Color getColor() {
		return this.color;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		int rgb = this.color.getRGB() & 0x00ffffff;
		return String.format("origin=%s,color=#%06x",origin.toString(),rgb);
	}
	/*
	@Override
	public boolean equals(Object other) {
		boolean truth = true;
		return truth;
	}
	*/
	/*
	public boolean equals(GeoPoint other) {
		boolean truth = true;
		if((other.getXco() == this.xco) && (other.getYco() == this.getYco())) {
			truth = true;
		}
		return truth;
		
		 @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

	}*/


}
