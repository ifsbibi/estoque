package com.evilyn.estoque.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsuarioDAO {

    private static UsuarioDAO instancia;

    private Set<Usuario> bdUsuarios;

    public UsuarioDAO(){
        bdUsuarios = new HashSet<>();
        cadastrarUsuario(new Usuario("evilyn@gmail.com", "1234"));
        cadastrarUsuario(new Usuario("admin@gmail.com", "1234"));
    }

    public static UsuarioDAO getInstancia(){
        if (instancia == null){
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public Set<Usuario> getBdUsuarios(){
        return bdUsuarios;
    }

    public Optional<Usuario> buscarPorEmail(String email){
        return bdUsuarios.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public void cadastrarUsuario(Usuario usario){
        bdUsuarios.add(usario);
    }

}
