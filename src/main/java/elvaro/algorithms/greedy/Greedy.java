package elvaro.algorithms.greedy;

import elvaro.Util;
import elvaro.algorithms.TSPAlgorithms;
import elvaro.data.structures.Edge;
import elvaro.data.structures.Point;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy implements TSPAlgorithms {
    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Edge> tour = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();

    @Override
    public double calculateDistance(ArrayList<Point> points) {
        this.points = points;
        edges = Util.createEdges(points);
        Collections.sort(edges);
        for(Edge edge : edges) {
            if(tour.size() == 0) {
                tour.add(edge);
            }
            if(!tour.contains(edge)) {
                //check if we have a cycle
                //check if we have a degree that is higher than 2
                tour.add(edge);
            }
        }
        return 0;
    }

    private boolean isCyclic(Edge edge) {
        
    }

    @Override
    public ArrayList<Point> getPath() {
        return null;
    }

    @Override
    public String toString() {
        return "Greedy";
    }
}
