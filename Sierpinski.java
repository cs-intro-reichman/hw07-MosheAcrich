/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		//// Replace this comment with your code

        double x1 = 0.0;
		double y1 = 0.0;
        double x2 = 1.0; 
		double y2 = 0.0;
        double x3 = 0.5; 
		double y3 = Math.sqrt( 3 / 4);

        sierpinski(n, x1, x2, x3, y1, y2, y3);
    }
	
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		//// Replace this comment with your code
		/// I do the basecase first, then i search for the halfpoint of every side in the triangle adn with the recursivity i do the 3 smaller triangels
		if (n == 0){
        	return;
		}

        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
		double x1HALF = (x1 + x2)/ 2;
        double y1HALF = (y1 + y2)/ 2;
        double x2HALF = (x2 + x3)/ 2;
        double y2HALF = (y2 + y3)/ 2;
        double x3HALF = (x3 + x1)/ 2;
        double y3HALF = (y3 + y1)/ 2;
		sierpinski(n - 1, x1, x1HALF, x3HALF, y1, y1HALF, y3HALF); 
        sierpinski(n - 1, x1HALF, x2, x2HALF, y1HALF, y2, y2HALF); 
        sierpinski(n - 1, x2HALF, x3, x3HALF, y2HALF, y3, y3HALF);
	}
}
