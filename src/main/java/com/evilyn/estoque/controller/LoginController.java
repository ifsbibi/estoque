package com.evilyn.estoque.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import com.evilyn.estoque.util.GerenciadorTela;

import java.io.IOException;
import java.util.Map;

public class LoginController {
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextFlow errosDados;

    private Map<String, String> usuariosCadastrados = Map.of(
            "admin@gmail.com", "1234",
            "evilyn@gmail.com" , "1234",
            "funci@gmail.com" , "1234"
    );

    @FXML
    protected void aoApertarBotao(ActionEvent event) throws IOException {

        String usuarioDigitado = usuario.getText().toLowerCase();
        String senhaDigitada = senha.getText();

        if (usuariosCadastrados.containsKey(usuarioDigitado) && usuariosCadastrados.get(usuarioDigitado).equals(senhaDigitada)){

            GerenciadorTela.getInstancia().trocarTela(event, "menu.fxml", "Sistema Estoque - Menu");


            errosDados.setVisible(false);


        }else{
            errosDados.setVisible(true);
        }

    }

    @FXML
    protected void aoEsquecerSenha(){
        System.out.println("Pqp, você esqueceu a senha!!!!!!");

    }

}
