<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
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
