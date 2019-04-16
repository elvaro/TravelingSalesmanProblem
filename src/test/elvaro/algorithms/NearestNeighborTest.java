package elvaro.algorithms;

import elvaro.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

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
    void toString1() {
    }

    @Test
    void getPath() {
    }
}