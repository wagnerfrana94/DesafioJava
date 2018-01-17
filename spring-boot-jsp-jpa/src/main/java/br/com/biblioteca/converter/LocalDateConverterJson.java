package br.com.biblioteca.converter;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverterJson implements Converter<String,LocalDate> {

    private final DateTimeFormatter formatter;

    public LocalDateConverterJson(String dateFormat) {
        formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDate convert(String source) {
        if(source == null || source.isEmpty()){
            return null;
        }
        return LocalDate.parse(source, formatter);
    }
}
