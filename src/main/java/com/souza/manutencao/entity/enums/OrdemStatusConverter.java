package com.souza.manutencao.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrdemStatusConverter implements AttributeConverter<OrdemStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrdemStatus ordemStatus) {
        return ordemStatus.getId();
    }

    @Override
    public OrdemStatus convertToEntityAttribute(Integer id) {
        return OrdemStatus.from(id);
    }
}
