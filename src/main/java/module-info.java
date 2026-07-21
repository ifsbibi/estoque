module com.evilyn.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.evilyn.estoque to javafx.fxml;
    exports com.evilyn.estoque;
}