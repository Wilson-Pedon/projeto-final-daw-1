<%--
  Created by IntelliJ IDEA.
  User: wilso
  Date: 05/08/2021
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/pages/butaoquepisca.css"%></style>

</head>
<body>



<form action="cadastro_cliente" method="post">
    <div>

        <h1>Cadastrar Cliente</h1>

        <P>* Campos Super Essenciais</P>

        <input type="text" placeholder="Email" name="cadastra-email"/>
        <input type="text" placeholder="Nome" name="cadastra-nome"/>
        <input type="password" placeholder="Senha" name="cadastra-senha"/>

        <input type="text" placeholder="Senha" name="*CPF COMPLETO"/>
        <input type="number" placeholder="Senha" name="*NUMERO DO CARTÃO"/>
        <input type="number" placeholder="Senha" name="*SENHA DE QUATRO DIGITOS"/>

        <input type="submit" value="Cadastrar"/>
    </div>
</form>

</body>
</html>
