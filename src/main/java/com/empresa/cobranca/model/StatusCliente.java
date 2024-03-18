package com.empresa.cobranca.model;

public enum StatusCliente {
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusCliente(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
