package elvaro.algorithms;

import elvaro.algorithms.greedy.Greedy;
import elvaro.data.structures.Edge;
import elvaro.data.structures.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreedyTest {
    Point pointA;
    Point pointB;
    Point pointC;
    Point pointD;
    Point pointE;
    Point pointF;
    Greedy greedy;
    ArrayList<Point> points = new ArrayList<>();

    @BeforeEach
    void setUp() {
        pointA = new Point(10, 10);
        pointB = new Point(30, 30);
        pointC = new Point(200, 20);
        pointD = new Point(20, 200);
        pointE = new Point(100, 100);
        pointF = new Point(200, 200);

        greedy = new Greedy();


    }

    @AfterEach
    void tearDown() {
        greedy = null;
    }

    @Test
    void calculate() {
    }

    @Test
    void getPath() {
    }

    @Test
    void createEdges() {
        Collections.addAll(points, pointA, pointB, pointC);
        greedy.calculateDistance(points);

        ArrayList<Edge> edges = greedy.getEdges();

        assertEquals(3, edges.size());

    }
}