<%@ page import="acao.expirarData" %><%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 08/08/2021
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/style/telaprincipal.css" %>
    </style>

</head>
<body>
<nav id="main-navbar">
    <div id="navbar-navLogo">
        <h1>Leilao Tudo Nosso</h1>
    </div>

    <div id="navbar-menu">
        <a href="entrada?acao=novoLeilao">Cadastrar leilão</a>
        <a href="entrada?acao=listarLeilao">Lista de leilões</a>
        <a href="cadastro_cliente">Cadastrar Cliente</a>
        <a href="entrada?acao=listarCliente">Lista de Clientes</a>
        <a href="entrada?acao=leilaoAberto">Lista de Leilões Abertos</a>
    </div>

</nav>


</body>
</html>


<%
    expirarData ex = new expirarData(response, request);
    ex.executa();
%>
