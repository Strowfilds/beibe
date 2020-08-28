<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="edit-categoria.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Categoria</a>
          </div>

        </div>
        
        <!-- Clientes -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Categorias</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th>Nome</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Unhas</th>
                        <th><a href="edit-categoria.jsp"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="########EXCLUIR CATEGORIA###########"><i class="fas fa-trash" style="color: red;"></i></a></th>
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

      <jsp:include page="footer.jsp" />