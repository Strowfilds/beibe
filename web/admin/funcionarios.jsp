<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="edit-funcionario.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Funcionário</a>
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
                        <th><a href="edit-funcionario.jsp"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="########EXCLUIR Funcionario###########"><i class="fas fa-trash" style="color: red;"></i></a></th>
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
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

     <%@include file="footer.jsp" %>
