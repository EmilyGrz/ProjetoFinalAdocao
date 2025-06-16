package com.adsis.projetoAdocao.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusAnimalConverter implements AttributeConverter<StatusAnimal, String> {
    @Override
    public String convertToDatabaseColumn(StatusAnimal statusAnimal) {
        return statusAnimal != null ? statusAnimal.getValor() : null;
    }

    @Override
    public StatusAnimal convertToEntityAttribute(String valor) {
        return valor != null ? StatusAnimal.fromValor(valor) : null;
    }
}
