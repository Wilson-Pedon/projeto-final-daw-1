<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 04/08/2021
  Time: 16:44
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
<h1>Update Do leilao</h1>


<h2> ID: ${pID} </h2>


<form action="entrada" method="post">
    <input type="hidden" id="acao" name="acao" value="updateLeilao"/>
    <input type="hidden" id="pID" name="pID" value="${pID}"/>
    <input type="text" placeholder="Objeto do leilao" name="objeto" value="${nome}"/>
    <input type="text" placeholder="Valor Minimo" name="valor" value="${valor}"/>
    <input type="date" name="data" value="${data}"/>
    <select name="status">
        <option value="Inativo">Inativo</option>
        <option value="Aberto">Aberto</option>
        <option value="Finalizado">Finalizado</option>
        <option value="Expirado">Expirado</option>
    </select>
    <input type="submit" value="Atualizar"/>
</form>



</body>
</html>
