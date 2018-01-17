
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Projetos</title>
    <link rel="stylesheet" href="../static/bootstrap/css/bootstrap.css">

</head>
<body>

<header>
    <h1 class="text-center">Cadastro de Projetos</h1>
</header>

<div class="container">
    <form action="/spring-boot-jsp-jpa/projetos" method="post">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
        </div>

        <div class="form-group">
            <label for="dataInicio">Data de início</label>
            <input type="date" class="form-control" name="dataInicio" id="dataInicio">
        </div>

        <div class="form-group">
            <label for="previsaoTermino">Data de previsão de término</label>
            <input type="date" class="form-control" name="dataPrevisaoFim" id="previsaoTermino">
        </div>

        <div class="form-group">
            <label for="dataTermino">Data de término</label>
            <input type="date" class="form-control" name="dataFim" id="dataTermino">
        </div>

        <div class="form-group">
            <label for="orcamento">Orçamento total</label>
            <input type="text" class="form-control" name="orcamento" id="orcamento" placeholder="R$">
        </div>


        <div class="form-group">
            <label for="status">Status</label>
            <select name="status" id="status" class="form-control">
                <option>Selecione um status</option>
                <c:forEach items="${status}" var="s">

                    <option value="${s}">${s.descricao}</option>

                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="gerente">Gerente</label>
            <select name="gerente" id="gerente" class="form-control">
                <option>Selecione um gerente</option>
                <c:forEach items="${pessoas}" var="pessoa">

                    <option value="${pessoa.id}">${pessoa.nome}</option>

                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="descricao">Descrição</label>
            <textarea rows="10" cols="20" name="descricao" class="form-control" id="descricao"></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
</div>
<script src="../static/lib/jquery-1.11.1.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
