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

    <style>
        <%@include file="/WEB-INF/style/lista.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/style/butaoquepisca.css" %>
    </style>
    <style>
        <%@include file="/WEB-INF/style/butaolink.css" %>
    </style>


    <h1> LEILÕES TUDO NOSSO</h1>


    <h3>Usuario: ${usuarioLogado}</h3>
    <a href="entrada?acao=logaut">Sair</a>


<body>
<form action="entrada?acao=cadastraLance" method="post">


    <input type="hidden" id="acao" name="acao" value="cadastraLance"/>
    <input type="hidden" id="objeto" name="objeto" value="${objeto}"/>
    <input type="text" name="usuario" placeholder="Nome"/>
    <input type="text" name="valordolance" placeholder="Digite o valor do Lance"/>
    <input type="email" name="email" placeholder="E-mail"/>

    <input type="submit" value="FAZER LANCE" id="butao"/>


</form>

<a href="entrada?acao=leilaoAberto">Lista De Leiões</a>
<a href="http://localhost:8080/Desenvolivmento_Web3_war/">Inicio</a>

</body>


<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>Valor</th>
        <th>Objeto</th>
        <th>Email</th>
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
                <td>${l.valor}</td>
                <td>${l.objeto}</td>
                <td>${l.email}</td>
            </tr>

        </c:forEach>

    </table>
</form>
</tbody>
</html>
