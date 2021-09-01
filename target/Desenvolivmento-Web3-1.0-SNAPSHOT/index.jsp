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
    <style><%@include file="/WEB-INF/pages/butaolink.css"%></style>

</head>
<body>

<h1>Leilao Tudo Nosso</h1>

<a href="entrada?acao=novoLeilao">Cadastrar leilão</a>
<a href="entrada?acao=listarLeilao">Lista de leilões</a>
<a href="cadastro_cliente">Cadastrar Cliente</a>
<a href="entrada?acao=listarCliente">Lista de Clientes</a>
<a href="entrada?acao=leilaoAberto" >Lista de Leilões Abertos</a>

<img src="${pageContext.request.contextPath}/Logo_Do_Site.jpg" alt="Comunismo" width="400px">

</body>
</html>


<%
    expirarData ex = new expirarData(response, request);
    ex.executa();
%>
