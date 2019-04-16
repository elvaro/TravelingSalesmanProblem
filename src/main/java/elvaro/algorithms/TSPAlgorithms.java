package elvaro.algorithms;

import elvaro.Point;

import java.util.ArrayList;

public interface TSPAlgorithms {
    /**
     * Store the Point in the algorithm object
     * @param points An ArrayList of Points
     */
    void storeDataPoints(ArrayList<Point> points);

    String toString();
}
