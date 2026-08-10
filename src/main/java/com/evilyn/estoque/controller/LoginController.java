package com.evilyn.estoque.controller;

import com.evilyn.estoque.model.Usuario;
import com.evilyn.estoque.model.UsuarioDAO;
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
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextFlow errosDados;

    private final UsuarioDAO bdUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected void aoApertarBotao(ActionEvent event) throws IOException {

        String usuarioDigitado = usuario.getText().toLowerCase();
        String senhaDigitada = senha.getText();

        Optional<Usuario> usuarioEncontrado = bdUsuario.buscarPorEmail(usuarioDigitado);

        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(senhaDigitada)){

            GerenciadorTela.getInstancia().trocarTela(event, "menu.fxml", "Sistema Estoque - Menu");


            errosDados.setVisible(false);


        }else{
            errosDados.setVisible(true);
        }

    }

    @FXML
    protected void aoEsquecerSenha() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com.evilyn.estoque.enviarEmail.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Sistema de Estoque - Esqueceu a senha");
        stage.show();
    }

}
