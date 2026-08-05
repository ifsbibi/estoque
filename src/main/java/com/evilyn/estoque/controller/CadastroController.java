package com.evilyn.estoque.controller;

import com.evilyn.estoque.model.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.TextFlow;

import java.awt.*;

public class CadastroController {

    @FXML
    private TextField usuarioCadastrar;

    @FXML
    private PasswordField senhaCadastrar;

    @FXML
    private PasswordField confirmaSenha;

    @FXML
    private TextFlow erroSenha;

    private static UsuarioDAO dbUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected void aoConfirmarCadastro(){
        String

    }

    @FXML
    protected void aoAcessarLogin(){

    }


}
