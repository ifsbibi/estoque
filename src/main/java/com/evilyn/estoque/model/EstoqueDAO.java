package com.evilyn.estoque.model;

import com.evilyn.estoque.util.ConexaoDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class EstoqueDAO {

    private final ObservableList<Produto> produtosList;


    public EstoqueDAO(){
        this.produtosList = FXCollections.observableArrayList();
    }

    public void adicionar(Produto produto){
        String sqlInsert = "INSERT INTO produto (nome,categoria,quantidade,preco) VALUES (?,?,?,?)";

        try(Connection con = ConexaoDB.abrirConexao(); PreparedStatement pstm = con.prepareStatement(sqlInsert)){
           pstm.setString(1, produto.getNome());
           pstm.setString(2,produto.getCategoria());
           pstm.setInt(3,produto.getQuantidade());
           pstm.setDouble(4,produto.getPreco());
           pstm.execute();

        } catch (SQLException ex){
            System.err.println("Erro na conexão do Banco de Dados!" + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public ObservableList<Produto> listarProdutos() throws SQLException {

        String sqlSelect = "SELECT * FROM produto";
        try(
                Connection con = ConexaoDB.abrirConexao();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sqlSelect)
                ){

            while (rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produtosList.add(produto);
            }

        }  catch (SQLException ex ){
            System.err.println("BANCO DE DADOS - - - Erro ao executar select de prtodutos!" + ex.getMessage());
            ex.printStackTrace();
        }


        return produtosList;
    }

    public void remover(List<Produto> listaProduto){
        String sqlDelete = "DELETE FROM produto WHERE id = ?";
        try (Connection con = ConexaoDB.abrirConexao(); PreparedStatement pstm = con.prepareStatement(sqlDelete)){
            for (var produto : listaProduto){
                pstm.setInt(1,produto.getId());
                pstm.addBatch();
            }
            pstm.executeBatch();
        } catch (SQLException ex){
            System.err.println("BANCO DE DADOS - - - Erro ao deletar um produto" + ex.getMessage());
            ex.printStackTrace();
        }
        produtosList.removeAll(listaProduto);
    }


    public double calcularValorTotalEstoque(){
        return produtosList.stream().mapToDouble(Produto::getValorTotal).sum();
    }

    public long calcularEstoqueBaixo(int limite){
        return  produtosList.stream().filter( p -> p.getQuantidade() < limite).count();

    }
}

