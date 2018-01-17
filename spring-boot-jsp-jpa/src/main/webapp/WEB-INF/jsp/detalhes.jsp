
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Projetos</title>
    <link rel="stylesheet" href="../../static/bootstrap/css/bootstrap.css">

</head>
<body>
<header>
    <h1 class="text-center">${projeto.nome}</h1>
</header>

<section class="container">
    <dl class="dl-horizontal">
        <dt>Data início</dt>
        <dd>${projeto.dataInicio}</dd>
        <dt>Data previsao de término</dt>
        <dd>${projeto.dataPrevisaoFim}</dd>
        <dt>Data término</dt>
        <dd>${projeto.dataFim}</dd>
        <dt>Descrição</dt>
        <dd>${projeto.descricao}</dd>
        <dt>Status</dt>
        <dd>${projeto.status.descricao}</dd>
        <dt>Orçamento</dt>
        <dd>R$ ${projeto.orcamento}</dd>
        <dt>Risco</dt>
        <dd>${projeto.risco.descricao}</dd>
        <dt>Gerente</dt>
        <dd>${projeto.gerente.nome}</dd>
        <c:forEach items="${projeto.membros}" var="membro">
            <dt>Membro</dt>
            <dd>${membro.nome}</dd>
        </c:forEach>
    </dl>

</section>
<script src="../../static/lib/jquery-1.11.1.min.js"></script>
<script src="../../static/bootstrap/js/bootstrap.js"></script>
</body>
</html>
