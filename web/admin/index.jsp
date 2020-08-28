<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
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
            <a class="collapse-item" href="forgot-password.jsp">Esqueci minha senha</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="tables_funcionarios.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Funcionários</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables_cliente.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Clientes</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables_horarios.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Atendimentos</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables_horarios.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Produtos</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables_horarios.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Categorias de Produtos</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables_horarios.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Atendimentos</span></a>
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
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Barbara Barbeira</span>
                <img class="img-profile rounded-circle" src="../images/gallery/barbara-barbeira.png">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Sua conta
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Configurações
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Notificações
                </a>
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

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Relatório de Funcionários</a>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Relatório de Produtos Mais Reclamados</a>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Relatório de Atendimentos em Aberto Por Data</a>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Relatório de Reclamações</a>
          </div>
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-plus fa-sm text-white-50"></i> Abrir um chamado</a>
          </div>

          

        </div>

        <!-- Funcionários -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Funcionários</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>Editar</th>
                        <th>Remover</th>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- Dados Funcionário -->
                      <tr>
                        <th>Cissa Magalhães</th>
                        <th>000.000.000-00</th>
                        <th>Rua dos Bobos, nº 0, apartamento 0, Centro, Curitiba - PR. CEP: 00.000-000</th>
                        <th>11 1111-1111</th>
                        <th><a href="#page-top"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="#page-top"><i class="fas fa-trash" style="color: red;"></i></a></th>
                      </tr>
                      <!-- fim Dados Funcionário -->
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- fim Funcionários -->

        <!-- Clientes -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Clientes</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Endereço</th>
                        <th>Telefone</th>
                        <th>Editar</th>
                        <th>Remover</th>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Cissa Magalhães</th>
                        <th>000.000.000-00</th>
                        <th>Rua dos Bobos, nº 0, apartamento 0, Centro, Curitiba - PR. CEP: 00.000-000</th>
                        <th>11 1111-1111</th>
                        <th><a href="#page-top"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="#page-top"><i class="fas fa-trash" style="color: red;"></i></a></th>
                      </tr>
                      <!-- fim Dados cliente -->
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- fim clientes -->

        <!-- atendimentos funcionário -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Atendimentos do Funcionário</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th colspan="9">Não há atendimentos marcados</th>
                      </tr>
                    </thead>
                    <thead>
                      <tr>
                        <th>Data/Hora</th>
                        <th>Cliente</th>
                        <th>Situação Do Atendimento</th>
                        <th>Produto</th>
                        <th>Tipo Do Atendimento</th>
                        <th>Descrição</th>
                        <th>Solução Apresentada</th>
                        <th>Editar</th>
                        <th>Salvar</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>11-11-2020 | 09:00</th>
                        <th>Maria de Lourdes</th>
                        <th>
                          <select>
                            <option value="aberto">Aberto</option>
                            <option value="em andamento">Em andamento</option>
                            <option value="congelado">Congelado</option>
                            <option value="pendente">Pendente</option>
                            <option value="concluido">Concluído</option>
                          </select>
                        </th>
                        <th>
                          <select>
                            <option value="Base">Base</option>
                            <option value="Hidratante">Hidratante</option>
                            <option value="Protese de Unha">Prótese de Unha</option>
                            <option value="Agua Oxigenada">Água Oxigenada</option>
                            <option value="Algodao">Algodão</option>
                          </select>
                        </th>
                        <th>
                          <select>
                            <option value="Presencial">Presencial</option>
                            <option value="Telefonico">Telefônico</option>
                            <option value="Online">Online</option>
                          </select>
                        </th>
                        <th><input type="text" name="description" value="lorem ipsum bla bla bla"></th>
                        <th><input type="text" name="solution" value="lorem ipsum bla bla bla"></th>
                        <th><a href="#page-top"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="#page-top"><i class="fas fa-save" style="color: grey;"></i></a></th>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- atendimentos funcionário -->

        <!-- atendimentos cliente -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Atendimentos do Cliente</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th colspan="9">Não há atendimentos marcados</th>
                      </tr>
                    </thead>
                    <thead>
                      <tr>
                        <th>Data/Hora</th>
                        <th>Cliente</th>
                        <th>Situação Do Atendimento</th>
                        <th>Produto</th>
                        <th>Tipo Do Atendimento</th>
                        <th>Descrição</th>
                        <th>Solução Apresentada</th>
                        <th>Editar</th>
                        <th>Resolvido</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>11-11-2020 | 09:00</th>
                        <th>Maria de Lourdes</th>
                        <th>
                          <button style="pointer-events: none;" type="button" class="btn btn-primary">Aberto</button>
                          <button style="pointer-events: none;" type="button" class="btn btn-success">Resolvido</button>
                          <button style="pointer-events: none;" type="button" class="btn btn-danger">Pendente</button>
                          <button style="pointer-events: none;" type="button" class="btn btn-warning">Em andamento</button>
                          <button style="pointer-events: none;" type="button" class="btn btn-info">Congelado</button>
                        </th>
                        <th>
                          Hidratante
                        </th>
                        <th>
                          Telefônico
                        </th>
                        <th>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip</th>
                        <th>Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</th>
                        <th><a href="#page-top"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th>
                          <a href="#page-top">Marcar como resolvido<i class="fas fa-check" style="color: green;"></i></a></th>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- atendimentos cliente -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; BEIBE 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Partindo já?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Pressione "Logout" abaixo se você realmente deseja sair</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.jsp">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
