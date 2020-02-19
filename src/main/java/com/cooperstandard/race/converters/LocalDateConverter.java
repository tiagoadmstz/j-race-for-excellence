package com.cooperstandard.race.converters;

import br.com.dev.engine.date.Datas;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.util.Date;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Datas.localDateToDate(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Datas.dateToLocalDate(date);
    }

}
