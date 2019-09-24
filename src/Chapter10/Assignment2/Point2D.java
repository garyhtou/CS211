package Chapter10.Assignment2;

/**
 * Gary Tou
 * 9/24/2019
 */

public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;
    
    public Point2D() {
        this(0.0, 0.0);
    }
    
    public Point2D(double x, double y) {
        setLocation(x, y);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(Point2D other) {
        double xDiff = x - other.x;
        double yDiff = y - other.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /**
     * Compares this point to that point. Implements Comparable.
     * @param point another Point2D to compare against.
     * @return -1, 0, or 1
     */
    public int compareTo(Point2D point){
        if(this.y > point.y){ //Compare y values first
            return 1;
        } else if(this.y < point.y) {
            return -1;
        } else if(this.x > point.x){ //if y value are the same, compare x values
            return 1;
        } else if(this.x < point.x){
            return -1;
        }
        return 0; //returns 0 with both points are the same
    }

}
