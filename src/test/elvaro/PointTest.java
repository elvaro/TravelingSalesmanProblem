package elvaro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateDistanceToPoint() {
        Point a = new Point(100, 100);
        Point b = new Point(200, 200);

        double distance = a.calculateDistanceToPoint(b);

        //I only want a 3 digit precision when doing the tests. Also have to do the comma replacement since double does not like that when parsing a string with comma in it
        assertEquals(141.421, Double.parseDouble(String.format("%.3f", distance).replaceAll(",", ".")));

        //test whether the distance is correct from the 0,0 coordinate
        Point zero = new Point(0, 0);
        double distanceFromZero = zero.calculateDistanceToPoint(a);
        assertEquals(141.421, Double.parseDouble(String.format("%.3f", distanceFromZero).replaceAll(",", ".")));

        //test whether the distance is same from point a to point zero
        double distanceToZero = a.calculateDistanceToPoint(zero);
        assertEquals(141.421, Double.parseDouble(String.format("%.3f", distanceToZero).replaceAll(",", ".")));
    }
}