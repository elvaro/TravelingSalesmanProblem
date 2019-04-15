package elvaro;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;


public class FXMLController {

    @FXML
    private Rectangle parentRectangle;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane centerPane;

    @FXML
    private Label addDataMessage;
    private ArrayList<Point> points;


    public void initialize() {
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
        DataHandler dataHandler = DataHandler.getDataHandler();
        dataHandler.addPoints(points);

        drawPoints();
    }

    /**
     * Draws the points on the pane. Adds tooltip to each of them
     */
    private void drawPoints() {
        addDataMessage.setVisible(false);
        for (Point point : points) {
            Circle circle = new Circle(point.x, point.y, 5);
            Tooltip tooltip = new Tooltip("X: " + point.x + ", Y: " + point.y);
            Tooltip.install(circle, tooltip);
            centerPane.getChildren().addAll(circle);
        }
    }
}
