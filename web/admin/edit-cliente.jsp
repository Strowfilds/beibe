<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">
          <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <div class="col-lg-12">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h4 text-gray-900 mb-4">Informações do Cliente</h1>
                    </div>
                    <form class="user">
                      <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Nome Completo" disabled value="#########nome do usuario###########">
                        </div>
                        <div class="col-sm-6">
                          <input type="text" class="form-control form-control-user" id="exampleLastName" placeholder="CPF" disabled value="##########cpf usuario#############">
                        </div>
                      </div>
                      <div class="form-group">
                        <input type="email" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email" value="###########email usuario###########">
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-9 mb-3 mb-sm-0">
                          <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Endereço" value="###########endereco usuario###########">
                        </div>
                        <div class="col-sm-3">
                          <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Número" value="###########numero usuario###########">
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                          <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Complemento" value="###########complemento usuário###########">
                        </div>
                        <div class="col-sm-4">
                          <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Bairro" value="###########bairro usuario###########">
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                          <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Cidade" value="###########cidade usuario###########">
                        </div>
                        <div class="col-sm-4">
                          <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Estado" value="###########estado###########">
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                          <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="CEP" value="###########CEP###########">
                        </div>
                        <div class="col-sm-4">
                          <input type="tel" class="form-control form-control-user" id="exampleRepeattext" placeholder="Telefone" value="###########telefone###########">
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Senha" required>
                        </div>
                      </div>
                      <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                      <input type="submit" value="Excluir Conta De Usuário" class="btn btn-primary btn-user btn-block btn-danger">
                      <hr>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /.container-fluid -->

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
