package br.com.biblioteca.eenum;

public enum Risco {

    BAIXORISCO("Baixo Risco"),
    MEDIORISCO("Médio Risco"),
    ALTORISCO("Alto Risco");

    private String descricao;

    Risco(String descricao) {
        this.descricao = descricao;
    }
}
