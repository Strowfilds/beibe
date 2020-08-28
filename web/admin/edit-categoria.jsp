<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />
  <div class="container-fluid">
    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-12">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Informações da Categoria</h1>
              </div>
              <form class="user" action="###########CategoriaServlet#############">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Nome da Categoria" disabled value="#########nome do categoria###########">
                  </div>
                </div>
                <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                <a href="clientes.jsp" class="btn btn-primary btn-user btn-block btn btn-secondary">Voltar</a>
                <hr>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<jsp:include page="footer.jsp" />