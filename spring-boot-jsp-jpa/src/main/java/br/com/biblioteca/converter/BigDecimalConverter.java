package br.com.biblioteca.converter;


import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BigDecimalConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        BigDecimal bigDecimal = new BigDecimal(text);
        super.setValue(bigDecimal);
    }
}
