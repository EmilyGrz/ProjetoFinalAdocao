package com.adsis.projetoAdocao.enums;

public enum StatusAnimal {
    ADOTADO("Adotado"),
    DISPONIVEL("Disponivel");

    private final String valor;

    StatusAnimal(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static StatusAnimal fromValor(String valor) {
        for (StatusAnimal statusAninal : values()) {
            if (statusAninal.getValor().equalsIgnoreCase(valor)) {
                return statusAninal;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + valor);
    }
}
