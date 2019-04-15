package elvaro;

import java.util.ArrayList;

public class DataHandler {
    private static final DataHandler dHandler = new DataHandler();
    private ArrayList<Point> points;

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

    public void addPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
