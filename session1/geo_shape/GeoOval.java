package cp120.assignments.geo_shape;

import java.awt.Graphics2D;

public class GeoOval extends GeoRectangle{
	
	public void draw(Graphics2D gtx) {
		System.out.printf("Drawing oval: width=%.4f,height=%.4f",this.getHeight(),this.getWidth());;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean truth = true;
		return truth;
	}

}
