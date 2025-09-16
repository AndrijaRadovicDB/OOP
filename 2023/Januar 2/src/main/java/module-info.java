module com.example.januar2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.januar2 to javafx.fxml;
    exports com.example.januar2;
}