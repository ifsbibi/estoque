package com.evilyn.estoque.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.evilyn.estoque.util.GerenciadorTela;

import java.io.IOException;

public class RelatorioController {
    @FXML
    protected void aoVoltarMenu(ActionEvent event) throws IOException {
        GerenciadorTela.getInstancia().trocarTela(event,"menu.fxml", "Sistema de Estoque - Menu");
    }
}



