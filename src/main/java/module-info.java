module com.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
exports com.example.phase2.controller to javafx.fxml;
    opens com.example.phase2.controller to javafx.fxml;

}