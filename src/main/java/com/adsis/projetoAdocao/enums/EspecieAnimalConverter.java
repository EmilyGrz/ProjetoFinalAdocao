package com.adsis.projetoAdocao.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EspecieAnimalConverter implements AttributeConverter<EspecieAnimal, String> {
    @Override
    public String convertToDatabaseColumn(EspecieAnimal especieAnimal) {
        return especieAnimal != null ? especieAnimal.getValor() : null;
    }

    @Override
    public EspecieAnimal convertToEntityAttribute(String valor) {
        return valor != null ? EspecieAnimal.fromValor(valor) : null;
    }
}
