package elvaro.algorithms;

import elvaro.Point;

import java.util.ArrayList;

/**
 * This class will implement the Nearest Neighbor Algorithm. Meaning it will always choose the closest unvisited point until all points
 * have been visited. This algorithm gives a fast approximate solution but almost never the optimal solution.
 */
public class NearestNeighbor implements TSPAlgorithms {
    private Point[] points;

    /**
     * Create a new instance of this algorithm and supply the points data
     */
    public NearestNeighbor() {
    }


    @Override
    public void storeDataPoints(ArrayList<Point> points) {

    }
}
