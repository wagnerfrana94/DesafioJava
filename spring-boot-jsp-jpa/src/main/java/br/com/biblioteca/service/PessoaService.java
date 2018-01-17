package br.com.biblioteca.service;

import br.com.biblioteca.model.Pessoa;

public interface PessoaService {
    Iterable<Pessoa> getAll();

    Pessoa findOne(long id);

    Pessoa save(Pessoa pessoa);
}
