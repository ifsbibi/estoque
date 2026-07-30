module com.evilyn.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;


    opens com.evilyn.estoque to javafx.fxml;
    opens com.evilyn.estoque.controller to javafx.fxml;
    opens com.evilyn.estoque.model to javafx.base;

    exports com.evilyn.estoque;

}
