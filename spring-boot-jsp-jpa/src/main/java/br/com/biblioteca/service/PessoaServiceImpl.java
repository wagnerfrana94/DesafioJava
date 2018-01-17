package br.com.biblioteca.service;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Iterable<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findOne(long id) {
        if(pessoaRepository.exists(id))
            return pessoaRepository.findOne(id);
        return null;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
