package elvaro;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        File sceneFile = new File("src/main/resources/elvaro/scene.fxml");
        File styleFile = new File("src/main/resources/elvaro/styles.css");

        Parent root = FXMLLoader.load(sceneFile.toURI().toURL());
        
        Scene scene = new Scene(root);

        scene.getStylesheets().add(styleFile.toURI().toURL().toExternalForm());
        
        stage.setTitle("Traveling Salesman Problem");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
