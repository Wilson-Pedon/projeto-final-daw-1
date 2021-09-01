<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 12/08/2021
  Time: 15:12
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


<form action="entrada?acao=" method="post">
    <div>

        <h1>Cadastrar Lance</h1>


        <input type="text" placeholder="Objeto" name="cadastra-objeto"/>
        <input type="text" placeholder="Nome" name="cadastra-nome"/>
        <input type="number" placeholder="Valor Do Lance" name="cadastra-valor"/>

        <input type="submit" value="Cadastrar"/>

    </div>
</form>



</body>
</html>
