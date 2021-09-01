<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 11/08/2021
  Time: 16:20
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

<form action="entrada?acao=fazUpgradeCliente" method="post">
    <div>

        <h1>Upgrade Cliente</h1>
        <h2> ID: ${pID} </h2>
        <input type="hidden" id="acao" name="acao" value="upgradeCliente"/>
        <input type="hidden" id="pID" name="pID" value="${pID}"/>
        <input type="text" placeholder="Email" name="cadastra-email" value="${email}"/>
        <input type="text" placeholder="Nome" name="cadastra-nome" value="${nome}"/>
        <input type="text" placeholder="Senha" name="cadastra-senha" value="${senha}"/>

        <input type="submit" value="Atualizar"/>
    </div>
</form>

</body>
</html>
