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

    <style><%@include file="/WEB-INF/pages/lista.css"%></style>
    <style><%@include file="/WEB-INF/pages/butaoquepisca.css"%></style>
    <style><%@include file="/WEB-INF/pages/butaolink.css"%></style>



    <h1>LEILÕES TUDO NOSSO</h1>


    <a href="entrada?acao=novoLeilao"> Cadastrar </a>
    <h3>Usuario: ${usuarioLogado}</h3>
    <a href="entrada?acao=logaut">Sair</a>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Senha</th>
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
                <td>${l.email}</td>
                <td>${l.senha}</td>
                <td><a href="entrada?acao=deletaCliente&id=${l.id}"> excluir </a> </td>
                <td><a href="entrada?acao=upgradeCliente&id=${l.id}"> Upgrade </a></td>
            </tr>

        </c:forEach>

    </table>
</form>
</tbody>
</html>
