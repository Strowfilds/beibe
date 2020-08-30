<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

        <title>Cabelereira Leila | Beibe | Erro</title>
        <link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="fonts/novecento-font/novecento-font.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="style.css">


    </head>

    <body>

        <div id="site-content">

            <header class="site-header">
                <div class="container">
                    <a id="branding" href="index.jsp">
                        <img src="images/logo.png" alt="Cabelereira Leila" class="logo">
                        <div class="logo-copy">
                            <h1 class="site-title">Cabelereira Leila</h1>

                        </div>
                    </a>

                    <%@include file="includes/navigationSnippet.jsp" %>

                    <div class="mobile-navigation"></div>
                </div>
            </header>

            <div class="row">
                <div class="col-md-12 text-center mb-4">
                    <i class="fas fa-sad-tear" style="color: white; font-size: 75px;"></i>
                    <h1><strong>ERRO 500</strong></h1>
                    <p>Tente atualizar a página ou retomar a navegação do passo anterior</p>
                    <p>Não há nada para ver aqui</p>
                    <p>Você não tem permissão para acessar esse conteúdo</p>
                </div>
                <div class="col-md-12 text-center">
                    <p>Mensagem: </p>
                    <p>${pageContext.exception.message}</p>
                </div>
                <div class="col-md-12 text-center">
                   <p>StackTrace: </p>
                   <p> ${pageContext.out.flush()}</p>
                   <p> ${pageContext.exception.printStackTrace(pageContext.response.writer)}</p>
                </div>
                <div class="col-3"></div>
            </div>

            <footer class="site-footer">
                <div class="container">


                    <div class="colophon">
                        <p> Copyright 2020 Cabelereira Leila. All rights reserved.</p>
                    </div>
                </div>
            </footer>
        </div>

        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>

    </body>

</html>