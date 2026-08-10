package com.evilyn.estoque.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTela {

    private static GerenciadorTela instancia;

    private GerenciadorTela(){

    }

    public static GerenciadorTela getInstancia(){
        if ( instancia == null) {
            instancia = new GerenciadorTela();
        }
        return instancia;
    }



    public void trocarTela(@org.jetbrains.annotations.UnknownNullability ActionEvent evente, String telaFXML, String titulo) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/evilyn/estoque/"+telaFXML));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) evente.getSource()).getScene().getWindow();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();

    }







}
