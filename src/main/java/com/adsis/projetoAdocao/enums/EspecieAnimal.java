package com.adsis.projetoAdocao.enums;

public enum EspecieAnimal {
    CANINO("Canino"),
    FELINO("Felino");

    private final String valor;

    EspecieAnimal(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static EspecieAnimal fromValor(String valor) {
        for (EspecieAnimal especieAnimal : values()) {
            if (especieAnimal.getValor().equalsIgnoreCase(valor)) {
                return especieAnimal;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + valor);
    }
}
