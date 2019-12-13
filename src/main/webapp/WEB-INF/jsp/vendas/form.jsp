<%-- 
    Document   : form
    Created on : 31/10/2019, 08:47:56
    Author     : paulo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
               <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body>

        <p>Seja bem vindo ${clientelogado.cliente.nome}</p>

        <table border="1">
            <tr>
                <th>Item</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Quantidade</th>
                <th>Ação</th>
            </tr>

            <c:forEach items="${produtos}" var="produto">
                <form action="${linkTo[VendasController].add}" method="post">
                    <tr>
                        <td><input type="text" name="item.produto.id" value="${produto.id}"></td>
                        <td><input type="text" name="item.produto.descricao" value="${produto.descricao}"></td>
                        <td><input type="text" name="item.produto.valor" value="${produto.valor}"></td>
                        <td><input type="number" name="item.qtd"></td>
                        <td><input type="submit" value="Adicionar"></td>
                    </tr>
                </form>
            </c:forEach>

        </table>
        <br><br>
        <table border="1">
            <tr>
                <th>Item</th>
                <th>Descrição</th>
                <th>Valor Unt.</th>
                <th>Quantidade</th>
                <th>Total</th>
            </tr>
            <c:forEach items="${venda.itens}" var="itemvenda" varStatus="i">

                <tr>

                    <td>${i.index+1}</td>
                    <td>${itemvenda.produto.descricao}</td>
                    <td>${itemvenda.produto.valor}</td>
                    <td>${itemvenda.qtd}</td>
                    <td>${itemvenda.total()}</td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="5">${venda.total()}</td>
            </tr>
        </table>
        <br><br>
        <button><a href="${linkTo[VendasController].logout}">Resetar </a></button> 
        <button><a href="${linkTo[VendasController].salvar()}">Fechar Pedido</a></button>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>  
    </body>
</html>
