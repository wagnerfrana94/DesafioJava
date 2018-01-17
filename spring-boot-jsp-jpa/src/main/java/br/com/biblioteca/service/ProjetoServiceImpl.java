package br.com.biblioteca.service;

import br.com.biblioteca.eenum.Status;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoServiceImpl implements ProjetoService{

    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoServiceImpl(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Override
    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    @Override
    public Iterable<Projeto> getAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto getById(Long id) {
        return projetoRepository.findOne(id);
    }

    @Override
    public void update(Projeto projeto) {
        if(projetoRepository.exists(projeto.getId()))
            projetoRepository.save(projeto);
    }

    @Override
    public void excluir(long id) {
        Projeto projeto = getById(id);
        if(projeto.getStatus().equals(Status.ANALISEAPROVADA) ||
                projeto.getStatus().equals(Status.ANALISEREALIZADA)
                || projeto.getStatus().equals(Status.EMANALISE))
            projetoRepository.delete(id);

    }
}
