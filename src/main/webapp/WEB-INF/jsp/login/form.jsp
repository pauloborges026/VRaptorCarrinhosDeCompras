<%-- 
    Document   : form
    Created on : 28/11/2019, 19:54:11
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>

    <body class="text-center">        


        <div class="row">
            <div class="col-md-3">
                <form id="login-form" class="form-signin"  action="${linkTo[LoginController].validar}" method="post">
                    <label for="username" class="text-info">Usuário:</label><br>
                    <input type="text" name="cliente.usuario" id="username" class="form-control"> <br>
                    <label for="password" class="text-info">Senha:</label><br>
                    <input type="password" name="cliente.senha" id="password" class="form-control">
                    <input type="submit" name="submit" class="btn btn-primary btn-md" id="cl" value="Enviar">
                    ${mensagem}
                    
                    
                  
           
                    <h3><a href="${linkTo[ClientesController].form}" style="text-decoration: none; color: #117a8b">&nbsp;&nbsp;&nbsp;Fazer Cadastro!</a></h3>


                </form>
            </div>
        </div> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>  

    </body>
</html>
