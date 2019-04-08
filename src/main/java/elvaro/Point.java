package elvaro;

/**
 * This class represents a single point within the 2D plane
 */
public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate the distance from this point to the supplied point
     *
     * @param distantX The X coordinate of the distant point
     * @param distantY The Y coordinate of the distant point
     * @return The distance between the two points
     */
    public double calculateDistanceToPoint(double distantX, double distantY) {
        double distance;

        double xFactor = Math.pow(distantX - this.x, 2);
        double yFactor = Math.pow(distantY - this.y, 2);

        distance = Math.sqrt(xFactor + yFactor);
        return distance;
    }
}
