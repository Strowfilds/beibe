<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>BEIBE GESTÃO DE SALÕES</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar"style="background-color: #333; background-image: none;">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-cut
                           "></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">BEIBE</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">                
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content" style="background-color: #151215">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"> - </span>
                                    <img class="img-profile rounded-circle" src="../images/avatar.jpg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <div class="dropdown-divider"></div>
                                    <c:url value="../LogoutServlet" var="logout"/>
                                    <a class="dropdown-item" href="${logout}">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>Sair
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->                    
                    <c:choose>
                        <c:when test="${empty param.msg}">
                            <!-- Funcionários -->
                            <div class="row">
                                <div class="col-md-12 text-center mb-4">
                                    <i class="fas fa-sad-tear" style="color: white; font-size: 75px;"></i>
                                    <h1><strong>ERRO 500</strong></h1>
                                    <p>Tente atualizar a página ou retomar a navegação do passo anterior</p>
                                    <p>Não há nada para ver aqui</p>
                                    <p>Você não tem permissão para acessar esse conteúdo</p>
                                </div>
                                <div class="col-3"></div>
                                <div class="col-md-6">
                                    <p>Mensagem: </p>
                                    ${pageContext.exception.message}
                                </div>
                                <div class="col-3"></div>
                                <div class="col-3"></div>
                                <div class="col-md-6">
                                    <p>StackTrace: </p>
                                    ${pageContext.out.flush()}
                                    ${pageContext.exception.printStackTrace(pageContext.response.writer)}
                                </div>
                                <div class="col-3"></div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="row">
                                <div class="col-md-12 text-center mb-4">
                                    <i class="fas fa-sad-tear" style="color: white; font-size: 75px;"></i>
                                    <h1><strong>ERRO ${param.cod}</strong></h1>
                                    <p>${param.msg}</p>                                    
                                </div>                                
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <!-- fim Funcionários -->

                </div>
                <!-- End of Main Content -->

                <jsp:include page="footer.jsp" />
                <a href="../../../Exercicio7/src/java/servlets/LogoutServlet.java"></a>