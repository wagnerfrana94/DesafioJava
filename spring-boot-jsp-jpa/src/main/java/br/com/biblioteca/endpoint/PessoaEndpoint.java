package br.com.biblioteca.endpoint;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
public class PessoaEndpoint {


    private final PessoaService pessoaService;

    @Autowired
    public PessoaEndpoint(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);
    }

}
