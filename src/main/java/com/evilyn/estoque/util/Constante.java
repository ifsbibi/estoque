package com.evilyn.estoque.util;

public enum Constante {

    REGEX_EMAIL("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"),

    REGEX_SENHA("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");

    private final String valor;

    Constante(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
