package elvaro;

/**
 * This class will implement the Nearest Neighbor Algorithm. Meaning it will always choose the closest unvisited point until all points
 * have been visited. This algorithm gives a fast approximate solution but almost never the optimal solution.
 */
public class NearestNeighbor {
    private Point[] points;

    /**
     * Create a new instance of this algorithm and supply the points data
     * @param points An array of Point
     */
    public NearestNeighbor(Point[] points) {
        this.points = points;
    }



}
