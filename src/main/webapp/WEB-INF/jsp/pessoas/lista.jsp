<%-- 
    Document   : listar
    Created on : 17/10/2019, 09:21:29
    Author     : professor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <style>
            *{
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
        </style>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Idade</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pessoaList}" var="pessoa">

                <tr>
                    <td>${pessoa.id}</td>
                    <td>${pessoa.nome}</td>
                    <td><button><a href="${linkTo[PessoasController].editar}?cod=${pessoa.id}">Editar</a></button></td>
                    <td><button><a href="${linkTo[PessoasController].excluir}?id=${pessoa.id}">Remover</a></button></td>
                </tr>
            </c:forEach> 
        </table><br><br>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>  


    </body>
</html>
