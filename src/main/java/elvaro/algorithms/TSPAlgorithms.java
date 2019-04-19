package elvaro.algorithms;

import elvaro.data.structures.Point;

import java.util.ArrayList;

public interface TSPAlgorithms {
    /**
     * Calculate the total distance needed to travel to all points
     *
     * @param points An ArrayList of Points
     */
    double calculate(ArrayList<Point> points);

    /**
     * A string representation of the object
     *
     * @return A string representing the object
     */
    String toString();

    /**
     * Returns the path traveled to all points
     *
     * @return An ArrayList containing Point objects in the path
     */
    ArrayList<Point> getPath();
}
