package br.com.biblioteca.converter;


import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

public class PessoaConverter extends PropertyEditorSupport {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaConverter(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    public void setAsText(String text) {
        super.setValue(pessoaService.findOne(Long.parseLong(text)));
    }
}
