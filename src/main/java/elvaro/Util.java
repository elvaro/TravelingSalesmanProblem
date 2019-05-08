package elvaro;

import elvaro.data.structures.Edge;
import elvaro.data.structures.Point;

import java.util.ArrayList;

public class Util {

    /**
     * This will create a list of Edge objects based on the Point objects. The edges are symmetrical so that
     * an edge from point A to point b will only be created once. Edge from point B to A will not be created since
     * that is the same edge.
     *
     * @param points An ArrayList of Point objects
     * @return An ArrayList of Edge objects
     */
    public static ArrayList<Edge> createEdges(ArrayList<Point> points) {
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Edge> tempEdges = new ArrayList<>();
        for (Point a : points) {
            for (Point b : points) {
                if (a != b) {
                    Edge newEdge = new Edge(a, b);
                    tempEdges.add(newEdge);
                }
            }
            for (Edge edge : tempEdges) {
                if (!edges.contains(edge)) {
                    edges.add(edge);
                }
            }
            tempEdges.clear();
        }
        return edges;
    }
}
