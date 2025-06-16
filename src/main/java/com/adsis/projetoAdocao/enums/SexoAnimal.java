package com.adsis.projetoAdocao.enums;

public enum SexoAnimal {
    MACHO("Macho"),
    FEMEA("Femea");

    private final String valor;

    SexoAnimal(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static SexoAnimal fromValor(String valor) {
        for (SexoAnimal statusAninal : values()) {
            if (statusAninal.getValor().equalsIgnoreCase(valor)) {
                return statusAninal;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + valor);
    }
}
