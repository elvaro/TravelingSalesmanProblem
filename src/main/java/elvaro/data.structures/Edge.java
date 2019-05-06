package elvaro.data.structures;

public class Edge implements Comparable {
    public final double length;
    private final Point pointA;
    private final Point pointB;

    /**
     * Construct a new Edge that has Point a as starting point and Point b as end point
     *
     * @param a The starting Point
     * @param b The end Point
     */
    public Edge(Point a, Point b) {
        this.pointA = a;
        this.pointB = b;
        this.length = a.calculateDistanceToPoint(b);
    }


    /**
     * Compare two Edge objects against each other. We are comparing them based on length.
     * If this is the same object or the same length of two different Edges return 0.
     * Otherwise we return 1 or -1 depending on which Edge is longer.
     */
    @Override
    public int compareTo(Object o) {
        if (this == o || this.length == ((Edge) o).length) {
            return 0;
        }
        if (this.length > ((Edge) o).length) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Checks whether two edges are equal. They are equal if its the same Edge object, or if they share the
     * same start and end point even if they are switched. Otherwise they are not equal.
     *
     * @param o The Edge object to compare to
     * @return true if equal otherwise false
     */
    @Override
    public boolean equals(Object o) {
        Edge edge = (Edge) o;
        if (this == edge) {
            return true;
        }
        if (this.pointA == edge.pointA && this.pointB == edge.pointB) {
            return true;
        }
        if (this.pointA == edge.pointB && this.pointB == edge.pointA) {
            return true;
        }
        return false;
    }
}
