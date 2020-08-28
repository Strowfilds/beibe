<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

        <title>Cabelereira Leila | Beibe | Contato</title>
        <!-- Loading third party fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="fonts/novecento-font/novecento-font.css" rel="stylesheet" type="text/css">
        <!-- Loading main css file -->
        <link rel="stylesheet" href="style.css">

        <!--[if lt IE 9]>
        <script src="js/ie-support/html5.js"></script>
        <script src="js/ie-support/respond.js"></script>
        <![endif]-->

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
                    </a> <!-- #branding -->

                    <%@include file="includes/navigationSnippet.jsp" %>

                    <div class="mobile-navigation"></div>
                </div>
            </header>

            <main class="main-content">
                <div class="page">
                    <div class="container">
                        <p>Omnis iste natus error sit voluptatem doloremque laudantium totam rem aperiam eaque ipsa quae ab illo inventore veritatis et quasi architecto Omnis iste natus error sit voluptatem doloremque laudantium totam rem aperiam eaque ipsa quae ab illo inventore veritatis et quasi architecto iste natus error sit voluptatem doloremque laudantium totam rem aperiam eaque ipsa quae ab illo inventore veritatis et quasi architecto</p>

                        <div class="row">
                            <div class="col-md-5">
                                <form action="#" class="contact-form">
                                    <input type="text" id="name" placeholder="Nome...">
                                    <input type="text" id="email" placeholder="Email...">
                                    <input type="text" id="website" placeholder="Site...">
                                    <textarea name="" id="message" placeholder="Mensagem..."></textarea>
                                    <div class="text-right">
                                        <button class="button large" type="submit">Enviar Mensagem</button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-6 col-md-offset-1">
                                <div class="map-container">
                                    <div class="map"></div>
                                    <div class="address-info">
                                        <address>
                                            <img src="images/icon-map-small.png" class="icon">
                                            <p><strong>Cabelereira Leila</strong> Paula Gomes 380, São Francisco</p>
                                        </address>
                                        <div class="contact-info">
                                            <a href="mailto:contact@companyname.com" class="mail"><img src="images/icon-envelope-small.png" class="icon">leila@cabelereira.com</a>
                                            <a href="tel:(500)942042259" class="phone"><img src="images/icon-phone-small.png" class="icon">(41)4141-4141</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

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