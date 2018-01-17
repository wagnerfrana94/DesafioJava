package br.com.biblioteca.model;

import br.com.biblioteca.converter.LocalDateAttributeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pessoa extends AbstractEntity{


    @NotEmpty(message = "O nome não pode esta em branco")
    private String nome;

    @JsonFormat(pattern = "dd/mm/yyyy")
    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    private String cpf;

    private boolean funcionario;

    @ManyToOne
    @JoinTable(name = "membros", joinColumns = @JoinColumn(name = "idpessoa"),
            inverseJoinColumns = @JoinColumn(name="idprojeto"))
    private Projeto projeto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
    }
}
