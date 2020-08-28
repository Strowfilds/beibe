<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
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

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->

                <!-- Heading -->

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    </a>
                    <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Sua Conta:</h6>
                            <a class="collapse-item" href="logout.jsp">Logout</a>
                            <a class="collapse-item" href="register.jsp">Registrar</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Charts -->

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="funcionarios.jsp">
                        <i class="fas fa-fw fa-user-tie"></i>
                        <span>Funcionários</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="clientes.jsp">
                        <i class="fas fa-fw fa-users"></i>
                        <span>Clientes</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="atendimentos_funcionario.jsp">
                        <i class="fas fa-fw fa-fire"></i>
                        <span>Atendimentos</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="atendimentos_cliente.jsp">
                        <i class="fas fa-fw fa-fire"></i>
                        <span>Meus Atendimentos</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="produtos.jsp">
                        <i class="fas fa-fw fa-gift"></i>
                        <span>Produtos</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="categorias.jsp">
                        <i class="fas fa-fw fa-gifts"></i>
                        <span>Categorias de Produtos</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="minha-conta.jsp">
                        <i class="fas fa-fw fa-user"></i>
                        <span>Minha Conta</span></a>
                </li>

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
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><c:out value="${login.nome}"/></span>
                                    <img class="img-profile rounded-circle" src="../images/avatar.jpg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <span class="dropdown-item mr-2 d-none d-lg-inline">
                                        <strong><c:out value="${login.tipoUsuario.value}"/></strong>
                                        <span class="badge badge-secondary">
                                            <span class="mr-2 d-none d-lg-inline small">
                                                ID: <c:out value="${login.id}"/>
                                            </span>
                                        </span>
                                    </span>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Sair
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->