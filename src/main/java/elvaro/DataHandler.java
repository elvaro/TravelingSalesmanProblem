package elvaro;

import elvaro.algorithms.TSPAlgorithms;
import elvaro.data.structures.Point;

import java.util.ArrayList;

public class DataHandler {
    private static final DataHandler dHandler = new DataHandler();

    /**
     * Private constructor
     */
    private DataHandler() {
    }

    /**
     * Returns the single instance of the DataHandler
     *
     * @return DataHandler object
     */
    public static DataHandler getDataHandler() {
        return dHandler;
    }

    public double submitDataAndProcess(ArrayList<Point> points, TSPAlgorithms algorithm) {
        return algorithm.calculateDistance(points);
    }
}
