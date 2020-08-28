<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="edit-atendimento.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Abrir Chamado</a>
          </div>


        </div>
        
        <!-- atendimentos funcionário -->
        <!-- atendimentos cliente -->
        <div class="row">
          <div class="col-md-12">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Meus Chamados</h6>
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
                        <th>Detalhes</th>
                        <th>Editar</th>
                        <th>Remover</th>
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
                        <th><a href="###########CRIAR LINK BASEADO NA  JSP VIEW-ATENDIMENTO####################">Mais detalhes</a></th>
                        <th><a href="edit-atendimento.jsp"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></th>
                        <th><a href="##############EXCLUIR ATENDIMENTO##############"><i class="fas fa-trash" style="color: red;"></i></a></th>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- atendimentos cliente -->
        <!-- atendimentos funcionário -->

      </div>
      <!-- End of Main Content -->

      <jsp:include page="footer.jsp" />