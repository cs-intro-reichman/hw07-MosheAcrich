/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.

		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
 	if (n == 0){
            StdDraw.line(x1,y1,x2,y2);
            return;
        }
    	double xA = x1 + (x2 - x1) / 3.0;
    	double yA = y1 + (y2 - y1) / 3.0;
    	double xC = x1 + 2 * (x2 - x1) / 3.0;
    	double yC = y1 + 2 * (y2 - y1) / 3.0;
    	double xB = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
    	double yB = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);
    	curve(n - 1, x1, y1, xA, yA); 
    	curve(n - 1, xA, yA, xB, yB); 
    	curve(n - 1, xB, yB, xC, yC); 
    	curve(n - 1, xC, yC, x2, y2); 
    }
	

     /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        // Draws a Koch snowflake of depth n
		////
        double x1 = 0.3, y1 = 0.2;
        double x2 = 0.7, y2 = 0.2;
        double x3 = (x1 + x2) / 2.0;
        double y3 = 0.2 + (Math.sqrt(3) * 0.4 / 2.0);

        curve(n, x3, y3, x2, y2); 
        curve(n, x2, y2, x1, y1);
        curve(n, x1, y1, x3, y3); 
    }
}
