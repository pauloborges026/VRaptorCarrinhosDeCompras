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
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
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
                <th>Descrição</th>
                <th>Valor</th>
                <th colspan="2">Ação</th>
            </tr>
        <c:forEach items="${produtoList}" var="produto">
              <p>Seja bem vindo ${clientelogado.cliente.nome}</p>
            <tr>
                <td>${produto.id}</td>
                <td>${produto.descricao}</td>
                <td>${produto.valor}</td>
                <td><button><a href='${linkTo[ProdutosController].editar}?cod=${produto.id}'>Editar</a></button></td>
                <td><button><a href='${linkTo[ProdutosController].excluir}?id=${produto.id}'>Remover</a></button></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
