<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="edit-produto.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Produto</a>
          </div>

        </div>
        
        <!-- Clientes -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Produtos</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th>Nome</th>
                        <th>Categoria</th>
                        <th>Descrição</th>
                        <th>Peso</th>
                        <th>Editar</th>
                        <th>Remover</th>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- Dados cliente -->
                      <tr>
                        <th>Prótese de unhas</th>
                        <th>Unhas</th>
                        <th>Maior próteses de unhas permitidas pela ANVISA</th>
                        <th>50<span>g</span></th>
                        <th><a href="edit-produto.jsp"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="######DELETAR PRODUTO###############"><i class="fas fa-trash" style="color: red;"></i></a></th>
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