package com.evilyn.estoque.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstoqueDAO {

    private static EstoqueDAO instancia;
    private final ObservableList<Produto> listaProdutos;
    private int idProduto = 1;

    private EstoqueDAO(){
        this.listaProdutos = FXCollections.observableArrayList();
    }


    public static EstoqueDAO getInstance(){
        if ( instancia == null){
            instancia = new EstoqueDAO();

        }
        return instancia;
    }

    public void adiconar(Produto produto){
        produto.setId(idProduto++);
        listaProdutos.add(produto);

    }

    public ObservableList<Produto> listarProdutos(){
        return listaProdutos;
    }

    public void remover(Produto produto){
        listaProdutos.remove(produto);
    }
}
