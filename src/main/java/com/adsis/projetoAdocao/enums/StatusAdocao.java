package com.adsis.projetoAdocao.enums;

public enum StatusAdocao {
    PENDENTE("Pendente"),
    APROVADA("Aprovada"),
    RECUSADO("Recusada");

    private final String valor;

    StatusAdocao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static StatusAdocao fromValor(String valor) {
        for (StatusAdocao status : values()) {
            if (status.getValor().equalsIgnoreCase(valor)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + valor);
    }
}