package br.com.biblioteca.service;

import br.com.biblioteca.model.Projeto;

public interface ProjetoService {
    Projeto save(Projeto projeto);

    Iterable<Projeto> getAll();

    Projeto getById(Long id);

    void update(Projeto projeto);

    void excluir(long id);

}
