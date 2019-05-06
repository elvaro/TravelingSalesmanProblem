package elvaro.algorithms.greedy;

import elvaro.algorithms.TSPAlgorithms;
import elvaro.data.structures.Edge;
import elvaro.data.structures.Point;

import java.util.ArrayList;

public class Greedy implements TSPAlgorithms {
    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();

    @Override
    public double calculate(ArrayList<Point> points) {
        this.points = points;
//        createEdges();
        return 0;
    }

    @Override
    public ArrayList<Point> getPath() {
        return null;
    }

    /**
     * Returns an ArrayList of Edge objects
     *
     * @return the ArrayList of Edges
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Greedy";
    }
}
