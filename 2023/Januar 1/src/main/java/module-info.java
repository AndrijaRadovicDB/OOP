module com.example.januar1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.januar1 to javafx.fxml;
    exports com.example.januar1;
}