module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens elvaro to javafx.fxml;
    exports elvaro;
}
