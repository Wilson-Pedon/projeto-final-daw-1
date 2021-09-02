<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 04/07/2021
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leilao</title>

    <style>
        <%@include file="/WEB-INF/style/lista.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/style/butaoquepisca.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/style/butaolink.css" %>
    </style>


    <h1> LEILÕES TUDO NOSSO</h1>

    <h3>MENU</h3>

    <a href="entrada?acao=novoLeilao"> Cadastrar </a>
    <h3>Usuario: ${usuarioLogado}</h3>
    <a href="entrada?acao=logaut">Sair</a>

<body>
<form action="entrada?acao=filtroLeilao" method="post">
    <select name="filtro-status">
        <option value="Todos">Todos</option>
        <option value="Inativo">Inativo</option>
        <option value="Aberto">Aberto</option>
        <option value="Finalizado">Fechado</option>
        <option value="Expirado">Expirado</option>
    </select>
    <input type="submit" value="Buscar"/>
</form>
</body>


<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Status</th>
        <th>Ações</th>
        <th>Ações</th>
        <th>Ações</th>
    </tr>
    </thead>
</table>


</head>

<tbody>

<form>
    <table>

        <c:forEach items="${list}" var="l">

            <tr>
                <td>${l.id}</td>
                <td>${l.nome}</td>
                <td>${l.valorMinimo}</td>
                <td>${l.data}</td>
                <td>${l.status}</td>
                <td><a href="entrada?acao=deleta&id=${l.id}"> excluir </a></td>
                <td>
                    <a href="entrada?acao=novoUpdateLeilao&id=${l.id}&nome=${l.nome}&valor=${l.valorMinimo}&data=${l.data}">
                        Upgrade </a></td>
                <td>
                    <a href="entrada?acao=finalizarLeilao&id=${l.id}&nome=${l.nome}&valor=${l.valorMinimo}&data=${l.data}&status=${l.status}">Finalizar
                        Leilão</a></td>

            </tr>

        </c:forEach>

    </table>
</form>
</tbody>
</html>
