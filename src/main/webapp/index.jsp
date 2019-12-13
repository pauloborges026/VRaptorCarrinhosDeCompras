<%-- 
    Document   : index
    Created on : 17/10/2019, 09:31:11
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/signin.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <ul>
            <li><a href="${linkTo[LoginController].form}">Login</a></li>
            <li><a href="${linkTo[ProdutosController].form}">Cadastro Produtos</a></li>
            <li><a href="${linkTo[VendasController].form}">Vendas</a></li>
        </ul>



    <!--  <a href="${linkTo[LoginController].form}">Login</a><br><br>

<!-- <a href="${linkTo[ClientesController].form}">Cadastrar clientes</a><br><br>
<a href="${linkTo[ProdutosController].form}">Cadastrar produto</a><br><br>
<a href="${linkTo[ClientesController].lista}">Consultar clientes</a><br><br>
<a href="${linkTo[ProdutosController].lista}">Consultar produtos</a><br><br>
<a href="${linkTo[VendasController].form}">Carrinho de Compras</a>  !-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>  

    </body>
</html>
