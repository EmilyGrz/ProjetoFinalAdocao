package com.adsis.projetoAdocao.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoAnimalConverter implements AttributeConverter<SexoAnimal, String> {
    @Override
    public String convertToDatabaseColumn(SexoAnimal sexoAnimal) {
        return sexoAnimal != null ? sexoAnimal.getValor() : null;
    }

    @Override
    public SexoAnimal convertToEntityAttribute(String valor) {
        return valor != null ? SexoAnimal.fromValor(valor) : null;
    }
}
