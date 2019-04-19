package elvaro;

import elvaro.algorithms.greedy.Greedy;
import elvaro.algorithms.nearest.neighbor.NearestNeighbor;
import elvaro.algorithms.TSPAlgorithms;
import elvaro.data.structures.Point;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;


public class FXMLController {
    @FXML
    private Pane centerPane;

    @FXML
    private Label addDataMessage;

    @FXML
    private ComboBox<TSPAlgorithms> algorithm;

    @FXML
    private Label cost;

    private ArrayList<Point> points;

    private double totalDistance = 0;

    public void initialize() {
        //initialize all the algorithms and populate the dropdownmenu with them
        NearestNeighbor nn = new NearestNeighbor();
        Greedy greedy = new Greedy();
        algorithm.getItems().addAll(nn, greedy);
    }

    @FXML
    private void exitProgram() {
        System.exit(0);
    }

    @FXML
    private void displayAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this program");
        alert.setHeaderText("Information about this program");
        alert.setContentText("This program was written by Elvar Thor Olafsson. \n This project can be found on Github: https://github.com/elvaro/TravelingSalesmanProblem" +
                "");
        alert.showAndWait();
    }

    /**
     * This will open a file chooser so that the user can specify a data file for the application. The data read
     * is converted into Point objects.
     */
    @FXML
    private void openDataFileDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tab separated values", "*.tsv"));

        File selectedFile = fileChooser.showOpenDialog(null);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(selectedFile));
        } catch (FileNotFoundException e) {
            Alert fileNotFoundAlert = new Alert((Alert.AlertType.ERROR));
            fileNotFoundAlert.setTitle("File Not Found Exception");
            fileNotFoundAlert.setHeaderText("Unable to find file!");
            fileNotFoundAlert.setContentText("Please chose a different file or try again.");
            fileNotFoundAlert.showAndWait();
        }

        String st;
        points = new ArrayList<>();
        try {
            while ((st = br.readLine()) != null) {
                String[] splitString = st.split(" ");
                double x = Double.valueOf(splitString[0]);
                double y = Double.valueOf(splitString[1]);

                Point po = new Point(x, y);
                points.add(po);
            }
        } catch (IOException ex) {
            Alert errorReadingFileAlert = new Alert((Alert.AlertType.ERROR));
            errorReadingFileAlert.setTitle("Error reading file");
            errorReadingFileAlert.setHeaderText("Error reading file!");
            errorReadingFileAlert.setContentText("The following error occurred: " + ex);
            errorReadingFileAlert.showAndWait();
        }
        drawPoints();
    }

    /**
     * Draws the points on the pane. Adds tooltip to each of them
     */
    private void drawPoints() {
        centerPane.getChildren().clear();
        addDataMessage.setVisible(false);
        for (Point point : points) {
            Circle circle = new Circle(point.x, point.y, 5);
            Tooltip tooltip = new Tooltip("X: " + point.x + ", Y: " + point.y);
            Tooltip.install(circle, tooltip);
            centerPane.getChildren().addAll(circle);
        }
    }

    @FXML
    private void calculate() {
        TSPAlgorithms algo = algorithm.getSelectionModel().getSelectedItem();
        if (algo == null) {
            Alert noDataLoadedAlert = new Alert((Alert.AlertType.WARNING));
            noDataLoadedAlert.setTitle("No algorithm selected!");
            noDataLoadedAlert.setContentText("No algorithm selected. Please select an algorithm to continue.");
            noDataLoadedAlert.showAndWait();
        } else if (points != null && points.size() > 0) {
            DataHandler dataHandler = DataHandler.getDataHandler();
            totalDistance = dataHandler.submitDataAndProcess(points, algo);
            drawPath(algo.getPath());
            cost.setText("Calculated cost: " + totalDistance);
            cost.setVisible(true);
        } else {
            Alert noDataLoadedAlert = new Alert((Alert.AlertType.WARNING));
            noDataLoadedAlert.setTitle("No data loaded!");
            noDataLoadedAlert.setContentText("No data has been loaded. Please load data to continue.");
            noDataLoadedAlert.showAndWait();
        }
    }

    /**
     * Draw the calculated path in the GUI. Each point will be drawn along with a line to the next
     * point in the path
     *
     * @param path An ArrayList of Point objects, indicating the path
     */
    private void drawPath(ArrayList<Point> path) {
        centerPane.getChildren().clear();
        Point previousPoint = null;

        for (Point point : path) {
            Circle circle = new Circle(point.x, point.y, 5);
            Tooltip tooltip = new Tooltip("X: " + point.x + ", Y: " + point.y);
            Tooltip.install(circle, tooltip);
            Line line = new Line();
            if (previousPoint != null) {
                line = new Line(previousPoint.x, previousPoint.y, point.x, point.y);
            }
            centerPane.getChildren().addAll(circle, line);
            previousPoint = point;
        }
    }
}
