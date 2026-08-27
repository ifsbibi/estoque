package com.evilyn.estoque.model;

import com.evilyn.estoque.util.ConexaoDB;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsuarioDAO {

    private Set<Usuario> bdUsuarios;

    public UsuarioDAO(){
        bdUsuarios = new HashSet<>();
    }
    public boolean validarLogin(String email,String senha){
        Optional<Usuario> usuarioEncontrado = buscarPorEmail(email);
        if(usuarioEncontrado.isEmpty()){
            return false;
        }
        return BCrypt.checkpw()
    }

    public Set<Usuario> getBdUsuarios(){
        return bdUsuarios;
    }

    public Optional<Usuario> buscarPorEmail(String email){
        String sqlSelect = "SELECT * FROM usuario WHERE email = ?";

        try (Connection con = ConexaoDB.abrirConexao(); PreparedStatement pstm = con.prepareStatement(sqlSelect)){
        pstm.setString(1,email);
        try (ResultSet rs = pstm.executeQuery()){
            if(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                return Optional.of(usuario);
            }
        }
        } catch (SQLException ex){
            System.err.println("BANCO DE DADOS - - - ERRO ao buscar usuario por email" + ex.getMessage());
            ex.printStackTrace();

        }
    }





    public void cadastrarUsuario(Usuario usuario){
        String sqlInsert = "INSERT INTO usuario (email,senha) VALUES (?,?)";

        String senhaCriptograda = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());




        try(Connection con = ConexaoDB.abrirConexao(); PreparedStatement pstm = con.prepareStatement(sqlInsert)){
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm.execute();


        } catch (SQLException ex){
            System.err.println("BANCO DE DADOS - - - Erro ao inserir nobo usu[ario" + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void atualizarSenha(String email, String novaSenha){
        String sqlUptade = "UPDATE usuario SET senha = ? WHERE email = ?";
        try(Connection con = ConexaoDB.abrirConexao(); PreparedStatement pstm = con.prepareStatement(sqlUptade)){
            pstm.setString(1, novaSenha);
            pstm.setString(2, email);
            pstm.executeUpdate();
        } catch (SQLException ex){
            System.err.println("BANCO DE DADOS - - - ERRO ao atualizar a senha!" + ex.getMessage());
            ex.printStackTrace();
        }



    }

}
