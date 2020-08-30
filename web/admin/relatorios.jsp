<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="edit-cliente.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Cliente</a>
          </div>

        </div>
        
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
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Relatório de Funcionários</th>
                        <th><a href="###########RELATÓRIO#############"><i class="fas fa-download" style="color: GREY;"></i></a></th>
                      </tr>
                      <!-- fim Dados cliente -->
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Relatório de Produtos Mais Reclamados</th>
                        <th><a href="###########RELATÓRIO#############"><i class="fas fa-download" style="color: GREY;"></i></a></th>
                      </tr>
                      <!-- fim Dados cliente -->
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Relatório de Atendimentos em Aberto Por Data</th>
                        <th>Da data: <input type="date" name="datade"></th>
                        <th>Até a data: <input type="date" name="dataate"></th>
                        <th><a href="###########RELATÓRIO#############"><i class="fas fa-download" style="color: GREY;"></i></a></th>
                      </tr>
                      <!-- fim Dados cliente -->
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Relatório de Reclamações</th>
                        <th>Situação: <select><option value="all">Todas</option><option value="aberto">Aberto</option><option value="concluido">Concluído</option></select></th>
                        <th><a href="###########RELATÓRIO#############"><i class="fas fa-download" style="color: GREY;"></i></a></th>
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

      </div>
      <!-- End of Main Content -->

      <%@include file="footer.jsp" %>