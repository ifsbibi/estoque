package com.evilyn.estoque.controller;

import com.evilyn.estoque.model.UsuarioDAO;
import com.evilyn.estoque.service.RecuperacaoSenhaService;
import com.evilyn.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EnviaEmailController {

    @FXML
    private TextField emailRecuperacao;

    @FXML
    private Label emailNaoCadastrado;


    private final RecuperacaoSenhaService service = new RecuperacaoSenhaService();
    @FXML
    protected void aoValidarEmail(ActionEvent event) throws IOException {
        String email = emailRecuperacao.getText().trim();

        String codigo = service.solicitarRecuperacao(email);

        if (codigo == null) {
            emailNaoCadastrado.setVisible(true);
            return;
        }


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/evilyn/estoque/codigoConfirmacao.fxml"));
        Parent root = fxmlLoader.load();

        CodigoConfirmacaoController controller = fxmlLoader.getController();
        controller.codigoConfirmacao(service, codigo);

        Scene scene = new Scene(root);
        Stage stage = (Stage) emailRecuperacao.getScene().getWindow();
        stage.setTitle("Código Confirmação");
        stage.setScene(scene);
        stage.show();
    }
}












