<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 04/08/2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/pages/butaoquepisca.css"%></style>
    <style><%@include file="/WEB-INF/pages/butaolink.css"%></style>


</head>
<body>


<a href="entrada?acao=listarLeilao">Lista De leilões</a>
<a href="http://localhost:8080/Desenvolivmento_Web3_war/">Inicio</a>


<c:include page="sair.jsp"/>

<h1>JSP</h1>
<h2>${usuarioLogado}</h2>
<h1>Cadastro Do leilao</h1>
<form action="entrada?acao=cadastrarLeilao" method="post">
    <input type="text" placeholder="Objeto do leilao" name="objeto"/>
    <input type="number" placeholder="Valor Minimo" name="valor"/>
    <input type="date" placeholder="Valor Minimo" name="data"/>
    <select name="status" >
        <option value="inativo">Inativo</option>
    </select>

    <input type="submit" value="Salvar"/>
</form>
</body>
</html>
