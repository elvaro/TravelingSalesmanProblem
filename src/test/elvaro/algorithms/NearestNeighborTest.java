package elvaro.algorithms;

import elvaro.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NearestNeighborTest {
    private NearestNeighbor algorithm;

    @BeforeEach
    void setUp() {
        algorithm = new NearestNeighbor();
    }

    @AfterEach
    void tearDown() {
        algorithm = null;
    }

    @Test
    void calculateDistanceBetween2Points() {
        //create two points and calculate the distance between them
        Point a = new Point(10, 10);
        Point b = new Point(100, 100);
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, a, b);
        double totalDistance = algorithm.calculate(points);
        assertEquals(127.279, Double.parseDouble(String.format("%.3f", totalDistance).replaceAll(",", ".")));
    }

    @Test
    void calculateDistanceBetween3Points() {
        //create three points and calculate the distance between them
        Point a = new Point(10, 10);
        Point b = new Point(100, 100);
        Point c = new Point(200, 300);
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, a, b, c);
        double totalDistance = algorithm.calculate(points);
        assertEquals(350.886, Double.parseDouble(String.format("%.3f", totalDistance).replaceAll(",", ".")));
    }

    @Test
    void calculateDistanceBetween5Points() {
        //create five points and calculate the distance between them
        Point a = new Point(10, 10);
        Point b = new Point(10, 250);
        Point c = new Point(40, 100);
        Point d = new Point(100, 10);
        Point e = new Point(100, 250);
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, a, b, c, d, e);

        double totalDistance = algorithm.calculate(points);
        assertEquals(441.137, Double.parseDouble(String.format("%.3f", totalDistance).replaceAll(",", ".")));

        //verify the path. The path taken should be A -> D -> C -> B -> E
        ArrayList<Point> path = algorithm.getPath();
        assertEquals(a, path.get(0));
        assertEquals(d, path.get(1));
        assertEquals(c, path.get(2));
        assertEquals(b, path.get(3));
        assertEquals(e, path.get(4));
    }


    @Test
    void toString1() {
    }

    @Test
    void getPath() {
    }
}