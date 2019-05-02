package elvaro.data.structures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    Point pointA;
    Point pointB;
    Point pointC;
    Point pointD;
    Point pointE;
    Point pointF;

    Edge AB;
    Edge AC;
    Edge AD;
    Edge AE;
    Edge AF;
    Edge BC;
    Edge BD;
    Edge BE;
    Edge BF;
    Edge CD;
    Edge CE;
    Edge CF;
    Edge DE;
    Edge DF;
    Edge EF;

    ArrayList<Edge> edges = new ArrayList<>();

    @BeforeEach
    void setUp() {
        pointA = new Point(10,10);
        pointB = new Point(30,30);
        pointC = new Point(200,20);
        pointD = new Point(20,200);
        pointE = new Point(100,100);
        pointF = new Point(200,200);

        AB = new Edge(pointA, pointB);
        AD = new Edge(pointA, pointD);
        BD = new Edge(pointB, pointD);
        DE = new Edge(pointD, pointE);
        EF = new Edge(pointE, pointF);
        BC = new Edge(pointB, pointC);
        CF = new Edge(pointC, pointF);
        AC = new Edge(pointA, pointC);
        AE = new Edge(pointA, pointE);
        AF = new Edge(pointA, pointF);
        BF = new Edge(pointB, pointF);
        BE = new Edge(pointB, pointE);
        CD = new Edge(pointC, pointD);
        CE = new Edge(pointC, pointE);
        DF = new Edge(pointD, pointF);

        edges.addAll(Arrays.asList(AB, AD, BD, DE, EF, BC, CF, AC, AE, AF, BF, BE, CD, CE, DF));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLength() {
        Edge newEdge = new Edge(pointA, pointB);
        assertEquals(28.284, Double.parseDouble(String.format("%.3f", newEdge.length).replaceAll(",", ".")));
    }

    @Test
    void testSorting() {
        Edge firstEdge = edges.get(0);
        Edge lastEdge = edges.get(14);
        assertEquals(AB, firstEdge);
        assertEquals(DF, lastEdge);
        Collections.sort(edges);
        firstEdge = edges.get(0);
        lastEdge = edges.get(14);
        assertEquals(AB, firstEdge);
        assertEquals(AF, lastEdge);
    }
}