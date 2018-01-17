package br.com.biblioteca.controller;

import br.com.biblioteca.converter.BigDecimalConverter;
import br.com.biblioteca.converter.LocalDateConverter;
import br.com.biblioteca.converter.PessoaConverter;
import br.com.biblioteca.eenum.Status;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("projetos")
public class ProjetosController {

    private final ProjetoService projetoService;
    private final PessoaService pessoaService;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(LocalDate.class, new LocalDateConverter());
        binder.registerCustomEditor(BigDecimal.class, new BigDecimalConverter());
        binder.registerCustomEditor(Pessoa.class,new PessoaConverter(pessoaService));
    }

    @Autowired
    public ProjetosController(ProjetoService projetoService, PessoaService pessoaService) {
        this.projetoService = projetoService;
        this.pessoaService = pessoaService;
    }

    @RequestMapping("/salvar")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("salvaprojeto");
        modelAndView.addObject("status", Status.values());
        modelAndView.addObject("pessoas", pessoaService.getAll());
        return modelAndView;
    }

    @RequestMapping("editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("editarprojeto");
        modelAndView.addObject("projeto",projetoService.getById(id));
        modelAndView.addObject("status", Status.values());
        modelAndView.addObject("pessoas", pessoaService.getAll());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Projeto projeto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/projetos");
        projetoService.save(projeto);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("listaprojetos");
        modelAndView.addObject("projetos",projetoService.getAll());
        return modelAndView;
    }

    @RequestMapping("/detalhes/{id}")
    public ModelAndView detalhe(@PathVariable("id")  Long id){
        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("projeto",projetoService.getById(id));
        return  modelAndView;
    }

    @RequestMapping(value = "/editar",method = RequestMethod.POST)
    public ModelAndView alterar(Projeto projeto){
        ModelAndView modelAndView = new ModelAndView("redirect:/projetos");
        projetoService.update(projeto);
        return  modelAndView;
    }

    @RequestMapping(value = "/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/projetos");
        projetoService.excluir(id);
        return  modelAndView;
    }

}
