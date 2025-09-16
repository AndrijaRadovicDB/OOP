module com.example.septembar1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.septembar1 to javafx.fxml;
    exports com.example.septembar1;
}