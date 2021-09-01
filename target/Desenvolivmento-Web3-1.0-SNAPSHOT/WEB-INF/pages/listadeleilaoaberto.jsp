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



    <h1> LEILÕES TUDO NOSSO</h1>

    <h3>MENU</h3>

    <h3>Usuario: ${usuarioLogado}</h3>
    <a href="http://localhost:8080/Desenvolivmento_Web3_war/">Inicio</a>
    <a href="entrada?acao=logaut">Sair</a>


<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Status</th>
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
                <td>${l.nome}</td>
                <td>${l.valorMinimo}</td>
                <td>${l.data}</td>
                <td>${l.status}</td>
                <td><a href="entrada?acao=filtroLance&nome=${l.nome}&usuario=${usuarioLogado}&valorMinimo=${valorMinimo}"> Fazer-Lance </a></td>
            </tr>

        </c:forEach>

    </table>
</form>
</tbody>
</html>
