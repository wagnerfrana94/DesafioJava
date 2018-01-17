package br.com.biblioteca.eenum;

public enum Status {
    EMANALISE("Em análise"),
    ANALISEREALIZADA("Análise realizada"),
    ANALISEAPROVADA("Análise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EMANDAMENTO("Em andamento"),
    ENCERRADO("encerrado"),
    CANCELADO("cancelado")
    ;


    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
