package br.com.biblioteca.model;

import br.com.biblioteca.converter.LocalDateAttributeConverter;
import br.com.biblioteca.eenum.Risco;
import br.com.biblioteca.eenum.Status;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projeto extends AbstractEntity{

    @NotEmpty
    private String nome;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataInicio;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataPrevisaoFim;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataFim;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal orcamento;

    private Risco risco;

    @OneToOne
    @JoinColumn(name = "idgerente")
    private Pessoa gerente;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "projeto")
    private Set<Pessoa> membros = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public Set<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(Set<Pessoa> membros) {
        this.membros = membros;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataPrevisaoFim=" + dataPrevisaoFim +
                ", dataFim=" + dataFim +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", orcamento=" + orcamento +
                ", risco=" + risco +
                ", gerente=" + gerente +
                ", membros=" + membros +
                '}';
    }
}
