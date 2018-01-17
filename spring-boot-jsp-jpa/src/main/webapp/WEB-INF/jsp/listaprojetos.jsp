
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Projetos</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css">

</head>
<body>
<header class="container">
    <h1 class="text-center">Lista de Projetos</h1>

</header>

<section class="container">
    <br/>
    <button class="btn btn-lg btn-link">
        <a href="projetos/salvar">
            <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
        </a>
    </button>
    <br/>
</section>

<section class="container">
    <table class="table">
        <thead>
            <tr>
                <td>Nome</td>
                <td>Data início</td>
                <td>Data previsão de término</td>
                <td>Data de término</td>
                <td>Orçamento</td>
                <td>Status</td>
                <td>Risco</td>
                <td>Editar</td>
                <td>Excluir</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${projetos}" var="projeto">
                <tr>
                    <td><a href="projetos/detalhes/${projeto.id}">${projeto.nome}</a></td>
                    <td>${projeto.dataInicio}</td>
                    <td>${projeto.dataPrevisaoFim}</td>
                    <td>${projeto.dataFim}</td>
                    <td>${projeto.orcamento}</td>
                    <td>${projeto.status.descricao}</td>
                    <td>${projeto.risco.descricao}</td>
                    <td>
                        <a href="projetos/editar/${projeto.id}">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                    </td>
                    <td>
                        <a href="projetos/excluir/${projeto.id}">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="static/lib/jquery-1.11.1.min.js"></script>
<script src="static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
