<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 05/08/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>

    <style>
        <%@include file="/WEB-INF/style/login.css" %>
    </style>




</head>
<body>


<form action="entrada?acao=login" method="post">
    <div>
        <img src="${pageContext.request.contextPath}/WEB-INF/img/perfil.png" alt="Comunismo" width="400px">

        <h1>LOGIN</h1>

        <input type="text" placeholder="User-Name" name="nome" width="200px"/>
        <input type="password" placeholder="Senha" name="senha" width="200px"/>


        <input type="submit" value="entrar"/>

    </div>
</form>


</body>
</html>
