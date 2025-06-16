package com.adsis.projetoAdocao.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusAdocaoConverter implements AttributeConverter<StatusAdocao, String> {
    @Override
    public String convertToDatabaseColumn(StatusAdocao statusAdocao) {
        return statusAdocao != null ? statusAdocao.getValor() : null;
    }

    @Override
    public StatusAdocao convertToEntityAttribute(String valor) {
        return valor != null ? StatusAdocao.fromValor(valor) : null;
    }
}
