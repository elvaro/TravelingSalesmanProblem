package elvaro.data.structures;

import java.util.ArrayList;

/**
 * This class represents a single point within the 2D plane
 */
public class Point {
    public final double x;
    public final double y;
    public boolean visited = false;
    private ArrayList<Edge> containedInEdges = new ArrayList<>();

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addToEdge(Edge edge) {
        containedInEdges.add(edge);
    }

    public ArrayList<Edge> getContainedInEdges() {
        return containedInEdges;
    }

    /**
     * Calculate the distance from this point to the supplied point
     *
     * @param destPoint The Point to measure the distance to
     * @return The distance between the two points
     */
    public double calculateDistanceToPoint(Point destPoint) {
        double distance;

        double xFactor = Math.pow(destPoint.x - this.x, 2);
        double yFactor = Math.pow(destPoint.y - this.y, 2);

        distance = Math.sqrt(xFactor + yFactor);

        return distance;
    }
}
