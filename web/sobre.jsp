<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

        <title>Cabelereira Leila | Beibe | Sobre</title>
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
                        <p>Fusce nec congue diam. Maecenas condimentum porttitor nibh in dignissim. Maecenas dictum felis id suscipit facilisis. Quisque et ipsum eleifend, commodo tellus at, ultrices purus. Suspendisse bibendum diam et tortor sodales sagittis. Phasellus rutrum justo libero, in gravida sem laoreet in. Aenean sed elit nec felis elementum scelerisque sit amet nec leo. Curabitur ipsum justo, laoreet quis feugiat at, blandit vel mauris. Vivamus luctus placerat nibh quis tempus. Nunc molestie, mi et suscipit vulputate, sem est rhoncus arcu, a vestibulum nunc magna ac tortor. Sed malesuada quis sem in tincidunt. Sed cursus enim orci, vitae vulputate est condimentum pharetra. Curabitur pretium est quis venenatis pharetra. Vestibulum a leo at quam rutrum vestibulum. Aenean tincidunt tellus quis tortor feugiat, rutrum sollicitudin .</p>

                        <div class="row">
                            <div class="col-md-4">
                                <h3 class="section-title">Sobre</h3>
                                <figure><img src="images/gallery/cabeleireira-leila2.jpg" alt=""></figure>
                                <h4>Donec pulvinar enim ante lacinia consectetur lorem dolor sit amet</h4>
                                <p>Aenean vitae nisl dapibus, blandit urna a, consequat arcu. Fusce blandit felis nec mattis condimentum. Phasellus accumsan nisi est, et tincidunt arcu aliquam non. Morbi fringilla, velit ac pretium condimentum, mi libero facilisis arcu, quis dictum mauris orci vel quam. Vestibulum et nulla lorem. Donec a tristique arcu. In eu nisi nec justo.</p>
                            </div>
                            <div class="col-md-4">
                                <h3 class="section-title">Paixão</h3>
                                <h4>Donec pulvinar enim ante lacinia consectetur lorem dolor sit amet</h4>
                                <p>Aenean vitae nisl dapibus, blandit urna a, consequat arcu. Fusce blandit felis nec mattis condimentum. Phasellus accumsan nisi est, et tincidunt arcu aliquam non.</p>
                                <h4>Donec pulvinar enim ante lacinia consectetur lorem dolor sit amet</h4>
                                <p>Aenean vitae nisl dapibus, blandit urna a, consequat arcu. Fusce blandit felis nec mattis condimentum. Phasellus accumsan nisi est, et tincidunt arcu aliquam non.</p>
                                <h4>Donec pulvinar enim ante lacinia consectetur lorem dolor sit amet</h4>
                                <p>Aenean vitae nisl dapibus, blandit urna a, consequat arcu. Fusce blandit felis nec mattis condimentum. Phasellus accumsan nisi est, et tincidunt arcu aliquam non.</p>
                            </div>
                            <div class="col-md-4">
                                <h3 class="section-title">Nossa equipe</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="team small">
                                            <figure class="team-image"><img src="images/gallery/esteticista-cissa.png"></figure>
                                            <h3 class="team-name">Dora depiladora</h3>
                                        </div>
                                        <div class="team small">
                                            <figure class="team-image"><img src="images/gallery/barbara-barbeira.png"></figure>
                                            <h3 class="team-name">Esteticista Cissa</h3>
                                        </div>

                                    </div>
                                    <div class="col-md-6">
                                        <div class="team small">
                                            <figure class="team-image"><img src="images/gallery/dora-depiladora.png"></figure>
                                            <h3 class="team-name">Barbara barbeira</h3>
                                        </div>
                                        <div class="team small">
                                            <figure class="team-image"><img src="images/gallery/henry-hair.png"></figure>
                                            <h3 class="team-name">Henry Hair</h3>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="team small">
                                            <figure class="team-image"><img src="images/gallery/massoterapeuta-massa.png"></figure>
                                            <h3 class="team-name">Massoterapeuta Massa</h3>
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
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>

    </body>

</html>