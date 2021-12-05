package com.br.Academia.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    TRANCADO("Trancado");

    private String status;
    private Status(String S){
        this.status = S;
    }
}
