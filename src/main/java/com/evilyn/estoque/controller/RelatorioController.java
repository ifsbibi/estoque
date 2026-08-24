package com.evilyn.estoque.controller;

import com.evilyn.estoque.model.EstoqueDAO;
import com.evilyn.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioController {

    @FXML
    private Label lblTotalProdutos;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblEstoqueBaixo;

    private final EstoqueDAO dadosEstoque = new EstoqueDAO();

    @FXML
    public  void initialize(){

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        int totalProdutos = dadosEstoque.listarProdutos().size();
        lblTotalProdutos.setText(String.valueOf(totalProdutos));

        double valorTotalEstoque = dadosEstoque.calcularValorTotalEstoque();
        lblValorTotal.setText(formatoMoeda.format(valorTotalEstoque));

        long estoqueBaixo = dadosEstoque.calcularEstoqueBaixo(10);
        lblEstoqueBaixo.setText(String.valueOf(estoqueBaixo));




    }

    @FXML
    protected void aoVoltarAoMenu(ActionEvent event) throws IOException {
        GerenciadorTela.getInstancia().trocarTela(event, "menu.fxml", "Sistema de Estoque - Menu");
    }

}