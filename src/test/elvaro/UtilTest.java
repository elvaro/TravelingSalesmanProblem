package elvaro;

import elvaro.data.structures.Edge;
import elvaro.data.structures.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilTest {
    Point pointA;
    Point pointB;
    Point pointC;
    Point pointD;

    @BeforeEach
    void setUp() {
        pointA = new Point(10, 10);
        pointB = new Point(100, 10);
        pointC = new Point(10, 100);
        pointD = new Point(50, 50);
    }

    @Test
    void create3Edges() {
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, pointA, pointB, pointC);
        ArrayList<Edge> edges = Util.createEdges(points);
        assertEquals(3, edges.size());
    }

    @Test
    void create1Edge() {
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, pointA, pointB);
        ArrayList<Edge> edges = Util.createEdges(points);
        assertEquals(1, edges.size());
    }

    @Test
    void createNoEdge() {
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, pointA);
        ArrayList<Edge> edges = Util.createEdges(points);
        assertEquals(0, edges.size());
    }

    @Test
    void create6Edges() {
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, pointA, pointB, pointC, pointD);
        ArrayList<Edge> edges = Util.createEdges(points);
        assertEquals(6, edges.size());
    }
}