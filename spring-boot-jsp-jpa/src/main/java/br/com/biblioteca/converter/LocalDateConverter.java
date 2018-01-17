package br.com.biblioteca.converter;


import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        super.setValue(localDate);
    }
}
