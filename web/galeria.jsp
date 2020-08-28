<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Cabelereira Leila | Beibe | Galeria</title>
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

					
					<!-- Default snippet for navigation -->
					<div class="main-navigation">
						<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
						<ul class="menu">
							<li class="menu-item"><a href="sobre.jsp">Sobre</a></li>
							<li class="menu-item"><a href="servicos.jsp">Serviços</a></li>
							<li class="menu-item current-menu-item"><a href="galeria.jsp">Gallery</a></li>
							<li class="menu-item"><a href="contato.jsp">Contato</a></li>
							<li class="menu-item"><a href="login.jsp">Entrar</a></li>
						</ul> <!-- .menu -->
					</div> <!-- .main-navigation -->

					<div class="mobile-navigation"></div>
				</div>
			</header>

			<main class="main-content">
				<div class="page">
					<div class="container">
						<div class="text-center">
							<div class="filter-links filterable-nav">
								<select class="mobile-filter">
									<option value="*">Mostrar Tudo</option>
									<option value=".hair">Cabelos</option>
									<option value=".manicure">Unha</option>
									<option value=".pedicure">Hidratação</option>
									<option value=".face">Unhas</option>
								</select>
								<a href="#" class="current wow fadeInRight" data-filter="*">Mostrar Tudo</a>
								<a href="#" class="wow fadeInRight" data-wow-delay=".2s" data-filter=".hair">Cabelos</a>
								<a href="#" class="wow fadeInRight" data-wow-delay=".4s" data-filter=".manicure">Unha</a>
								<a href="#" class="wow fadeInRight" data-wow-delay=".6s" data-filter=".pedicure">Hidratação</a>
								<a href="#" class="wow fadeInRight" data-wow-delay=".8s" data-filter=".face">Unhas</a>
							</div>
						</div>

						<div class="filterable-items">
							<div class="gallery-item filterable-item manicure">
								<a href="images/gallery/large-gallery/gallery-1.jpg">
									<figure class="featured-image">
										<img src="images/gallery/gallery-1.jpg" alt="">
										<figcaption>
											<h2 class="gallery-title">Lorem ipsum dolor sit amet</h2>
											<p>Maecenas dictum suscipit</p>
										</figcaption>
									</figure>
								</a>
							</div>
							<div class="gallery-item filterable-item face">
								<a href="images/gallery/large-gallery/gallery-2.jpg">
									<figure class="featured-image">
										<img src="images/gallery/gallery-2.jpg" alt="">
										<figcaption>
											<h2 class="gallery-title">Consectetur adipisicing elit</h2>
											<p>Maecenas dictum suscipit</p>
										</figcaption>
									</figure>
								</a>
							</div>
							<div class="gallery-item filterable-item hair">
								<a href="images/gallery/large-gallery/gallery-3.jpg">
									<figure class="featured-image">
										<img src="images/gallery/gallery-3.jpg" alt="">
										<figcaption>
											<h2 class="gallery-title">Repellat fugit tenetur</h2> 
											<p>Maecenas dictum suscipit</p>
										</figcaption>
									</figure>
								</a>
							</div>
							<div class="gallery-item filterable-item pedicure">
								<a href="images/gallery/large-gallery/gallery-4.jpg">
									<figure class="featured-image">
										<img src="images/gallery/gallery-4.jpg" alt="">
										<figcaption>
											<h2 class="gallery-title">Asperiores quas voluptatem</h2>
											<p>Maecenas dictum suscipit</p>
										</figcaption>
									</figure>
								</a>
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