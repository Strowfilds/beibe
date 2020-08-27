<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Cabelereira Leila | Beibe | Serviços</title>
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
							<li class="menu-item current-menu-item"><a href="servicos.jsp">Serviços</a></li>
							<li class="menu-item"><a href="galeria.jsp">Galeria</a></li>
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
						<p>Cabeleireira Leila: cabelos, unhas, hidratação e unha. Cabeleireira Leila: venha fazer suas unhas, seus cabelos, e até mesmo hidratar suas madeixas de cabelo conosco. Tudo esterilizado para você não ficar mal</p>

						<div class="row">
							<div class="col-md-3">
								<div class="feature">
									<img src="images/icon-2.png" class="feature-image">
									<h3 class="feature-title">Cabelos</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse, minus, totam. Officia </p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<img src="images/icon-3.png" class="feature-image">
									<h3 class="feature-title">Unha</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste, omnis cum, </p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<img src="images/icon-6.png" class="feature-image">
									<h3 class="feature-title">Hidratação</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse, minus, totam. Officia ea</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="feature">
									<img src="images/icon-4.png" class="feature-image">
									<h3 class="feature-title">Unhas</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam, facere numquam porro </p>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-6">
								<div class="price-list">
									<h2 class="section-title">Preço pra home</h2>
									<ul class="prices">
										<li>Cabelos<span class="price">R$50</span></li>
										<li>Unha<span class="price">R$50</span></li>
										<li>Hidratação<span class="price">R$50</span></li>
										<li>Unhas<span class="price">R$50</span></li>
									</ul>
								</div>
							</div>
							<div class="col-md-6">
								<div class="price-list">
									<h2 class="section-title">Preço pra muié</h2>
									<ul class="prices">
										<li>Cabelos<span class="price">R$50</span></li>
										<li>Unha<span class="price">R$50</span></li>
										<li>Hidratação<span class="price">R$50</span></li>
										<li>Unhas<span class="price">R$50</span></li>
									</ul>
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