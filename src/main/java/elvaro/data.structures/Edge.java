package elvaro.data.structures;

public class Edge implements Comparable {
    private final Point pointA;
    private final Point pointB;
    public final double length;

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


    @Override
    /**
     * Compare two Edge objects against each other. We are comparing them based on length.
     * If this is the same object or the same length of two different Edges return 0.
     * Otherwise we return 1 or -1 depending on which Edge is longer.
     */
    public int compareTo(Object o) {
        if (this == o || this.length == ((Edge)o).length) {
            return 0;
        }
        if(this.length > ((Edge)o).length) {
            return 1;
        } else {
            return -1;
        }
    }
}
