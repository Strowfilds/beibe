<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

        <title>Cabelereira Leila</title>
        <!-- Loading third party fonts -->
        <link href="./fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="fonts/novecento-font/novecento-font.css" rel="stylesheet" type="text/css">
        <!-- Loading main css file -->
        <link rel="stylesheet" href="style.css">

        <!--[if lt IE 9]>
        <script src="js/ie-support/html5.js"></script>
        <script src="js/ie-support/respond.js"></script>
        <![endif]-->
    </head>

    <body class="homepage header-collapse">

        <div id="site-content">

            <header class="site-header">
                <div class="container" style="padding: 10px 0; display: flex;">
                    <a id="branding" href="index.jsp">
                        <img src="images/logo.png" alt="Cabelereira Leila" class="logo" height="65">
                    </a> <!-- #branding -->

                    <!-- Default snippet for navigation -->
                    <div class="main-navigation" style="margin: auto; margin-right: 0;">
                        <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
                        <ul class="menu">
                            <li class="menu-item"><a href="sobre.jsp">Sobre</a></li>
                            <li class="menu-item"><a href="servicos.jsp">Serviços</a></li>
                            <li class="menu-item"><a href="galeria.jsp">Galeria</a></li>
                            <li class="menu-item"><a href="contato.jsp">Contato</a></li>
                            <li class="menu-item"><a href="login.jsp">Entrar</a></li>
                        </ul> <!-- .menu -->
                    </div> <!-- .main-navigation -->

                    <div class="mobile-navigation"></div>
                </div>
            </header>

            <div class="hero hero-slider">
                <ul class="slides">
                    <li data-bg-image="images/gallery/slider-1.jpg">
                        <div class="container">
                            <h3 class="slider-subtitle">O CENTRO DE CABELEIREIRO BEAUTY CENTER DA</h3>
                            <h2 class="slider-title">CABELEIREIRA LEILA</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa molestiae necessitatibus possimus ducimus facere, error, nostrum. Quos sapiente ducimus maxime odio alias dolor consequuntur, maiores commodi exercitationem veniam. Id, ex?</p>
                            <a href="#" class="button large">Saiba Mais</a>
                        </div>
                    </li>
                    <li data-bg-image="images/gallery/slider-2.jpg">
                        <div class="container">
                            <h3 class="slider-subtitle">O CENTRO DE CABELEIREIRO BEAUTY CENTER DA</h3>
                            <h2 class="slider-title">CABELEIREIRA LEILA</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. In maiores illo eligendi obcaecati reiciendis, vel perspiciatis aliquid esse architecto deleniti asperiores, laboriosam nemo rerum! Ipsam numquam delectus minus iure sit!</p>
                            <a href="#" class="button large">Saiba Mais</a>
                        </div>
                    </li>
                    <li data-bg-image="images/gallery/slider-3.jpg">
                        <div class="container">
                            <h3 class="slider-subtitle">O CENTRO DE CABELEIREIRO BEAUTY CENTER DA</h3>
                            <h2 class="slider-title">CABELEIREIRA LEILA</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam iure, alias error suscipit porro quidem minus, autem repellendus rerum labore corrupti! Quia quas, architecto, quis non pariatur quisquam nisi magnam.</p>
                            <a href="#" class="button large">Saiba Mais</a>
                        </div>
                    </li>
                </ul>
            </div>

            <main class="main-content">
                <div class="fullwidth-block latest-news-section">
                    <div class="container">
                        <h2 class="section-title">Fofocas</h2>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="news">
                                    <div class="entry-date">
                                        <div class="date">29</div>
                                        <div class="monthyear">07.2014</div>
                                    </div>
                                    <div class="entry-detail">
                                        <div class="entry-summary">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo velit, tempora aut nesciunt. <a href="#" class="more-icon"><img src="images/arrow.png"></a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="news">
                                    <div class="entry-date">
                                        <div class="date">29</div>
                                        <div class="monthyear">07.2014</div>
                                    </div>
                                    <div class="entry-detail">
                                        <div class="entry-summary">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum quo esse vero ipsa architecto <a href="#" class="more-icon"><img src="images/arrow.png"></a></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="news">
                                    <div class="entry-date">
                                        <div class="date">29</div>
                                        <div class="monthyear">07.2014</div>
                                    </div>
                                    <div class="entry-detail">
                                        <div class="entry-summary">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Distinctio, corporis,  <a href="#" class="more-icon"><img src="images/arrow.png"></a></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .row -->

                        <div class="text-center">
                            <a href="#" class="button no-gradient">Mais fofocas</a>
                        </div>
                    </div> <!-- .container -->
                </div> <!-- .fullwidth-block.latest-news-section -->

                <div class="fullwidth-block features-section">
                    <div class="container">
                        <h2 class="section-title">Nossos serviços</h2>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="feature">
                                    <img src="images/icon-7.png" class="feature-image">
                                    <h3 class="feature-title">Cabelos</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur dolor perferendis blanditiis voluptate maiores </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="feature">
                                    <img src="images/icon-4.png" class="feature-image">
                                    <h3 class="feature-title">Unha</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse, minus, totam. Officia ea accusamus quis tenetur quas </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="feature">
                                    <img src="images/icon-6.png" class="feature-image">
                                    <h3 class="feature-title">Hidratação</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste, omnis cum, quo dolorem molestias asperiores doloremque dolorum</p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="feature">
                                    <img src="images/icon-3.png" class="feature-image">
                                    <h3 class="feature-title">Unhas</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, facere numquam porro amet reiciendis maiores odio velit</p>
                                </div>
                            </div>
                        </div> <!-- .row -->
                    </div> <!-- .container -->
                </div> <!-- .fullwidth-block.features-section -->

                <div class="fullwidth-block team-section">
                    <div class="container">
                        <h2 class="section-title">Nossa Equipe</h2>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="team">
                                    <figure class="team-image"><img src="images/gallery/henry-hair.png"></figure>
                                    <h3 class="team-name">Henry Hair</h3>
                                    <div class="social-links">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="team">
                                    <figure class="team-image"><img src="images/gallery/dora-depiladora.png"></figure>
                                    <h3 class="team-name">Dora Depiladora</h3>
                                    <div class="social-links">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="team">
                                    <figure class="team-image"><img src="images/gallery/esteticista-cissa.png"></figure>
                                    <h3 class="team-name">Esteticista Cissa</h3>
                                    <div class="social-links">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="team">
                                    <figure class="team-image"><img src="images/gallery/barbara-barbeira.png"></figure>
                                    <h3 class="team-name">Bárbara Barbeira</h3>
                                    <div class="social-links">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .row -->
                    </div> <!-- .container -->
                </div> <!-- .fullwidth-block.team-section -->

                <div class="fullwidth-block information-section">
                    <div class="container">
                        <h2 class="section-title">Nossa História</h2>
                        <div class="row">
                            <div class="col-md-8">
                                <iframe width="727" height="409" src="https://www.youtube.com/embed/s11QaZ0J3dU" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                            <div class="col-md-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Praesentium odit, blanditiis aliquam officia soluta modi amet ex nihil nulla minima. Nam earum est magnam tempore corrupti quos consequatur, numquam voluptas! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque omnis minima accusamus nihil eligendi quas cumque rerum odit quo architecto repudiandae adipisci repellendus velit nostrum sed quisquam doloribus, consequatur sint.</p>
                            </div>
                        </div>
                    </div>
                </div> <!-- .fullwidth-block.information-section -->
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