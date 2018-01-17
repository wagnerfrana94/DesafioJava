package br.com.biblioteca.repository;

import br.com.biblioteca.model.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto,Long> {
}
