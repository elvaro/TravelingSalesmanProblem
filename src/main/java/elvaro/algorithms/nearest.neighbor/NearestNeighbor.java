package elvaro.algorithms.nearest.neighbor;

import elvaro.data.structures.Point;
import elvaro.algorithms.TSPAlgorithms;

import java.util.ArrayList;

/**
 * This class will implement the Nearest Neighbor Algorithm. Meaning it will always choose the closest unvisited point until all points
 * have been visited. This algorithm gives a fast approximate solution but almost never the optimal solution.
 */
public class NearestNeighbor implements TSPAlgorithms {
    private ArrayList<Point> path = new ArrayList<>();

    /**
     * Create a new instance of this algorithm
     */
    public NearestNeighbor() {
    }

    @Override
    public double calculateDistance(ArrayList<Point> points) {
        Point startPoint = points.get(0);
        startPoint.visited = true;

        ArrayList<Point> remainingPoints = points;
        remainingPoints.remove(0);
        path.add(startPoint);
        double totalDistance = calculateDistanceToClosestPosition(startPoint, remainingPoints);

        return totalDistance;
    }

    private double calculateDistanceToClosestPosition(Point currentPoint, ArrayList<Point> remainingPoints) {
        double closestDistance = -1;
        Point closestPoint = null;
        if (remainingPoints.size() > 0) {
            for (Point nextPoint : remainingPoints) {
                double distanceToNextPoint = currentPoint.calculateDistanceToPoint(nextPoint);
                if (distanceToNextPoint < closestDistance || closestDistance == -1) {
                    closestPoint = nextPoint;
                    closestDistance = distanceToNextPoint;
                }
            }
            remainingPoints.remove(closestPoint);
            path.add(closestPoint);
        } else {
            return 0;
        }
        return closestDistance + calculateDistanceToClosestPosition(closestPoint, remainingPoints);
    }

    @Override
    public String toString() {
        return "Nearest Neighbor";
    }

    @Override
    public ArrayList<Point> getPath() {
        return path;
    }
}
