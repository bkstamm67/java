package cp120.assignments.assignment001;

import edu.uweo.javaintro.tools.Turtle;

public class Bubbles {

	public static void main(String[] args) {
	
		//Initialize variables, put circle on left side
		double radius = 128;
		Turtle circle = new Turtle();
		circle.move(0,-248);
		circle.switchTo(Turtle.GREEN);
		
		//Loop to create circles
		while(radius >= 4) {
			circle.fillCircle(radius);
			circle.move(0,(radius + radius/2));
			radius/=2;
		}
	}
}
