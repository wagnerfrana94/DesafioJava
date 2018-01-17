package br.com.biblioteca.repository;

import br.com.biblioteca.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa,Long> {
}
