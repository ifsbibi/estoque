package com.evilyn.estoque;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HomeController {

    @FXML
    protected void aoSair(ActionEvent event) throws
            IOException {
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fmxlLoader.load());

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
