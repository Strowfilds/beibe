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
                <h1 class="h4 text-gray-900 mb-4">Informações do Cliente</h1>
              </div>
              <form class="user" action="###########ClienteServlet#############">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nomecompleto" placeholder="Nome Completo" disabled value="#########nome do usuario###########">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" maxlength="14" id="exampleLastName" placeholder="CPF" disabled value="##########cpf usuario#############">
                  </div>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user" id="email" placeholder="Email" value="###########email usuario###########">
                </div>
                <div class="form-group row">
                  <div class="col-sm-9 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="endereco" placeholder="Endereço" value="###########endereco usuario###########">
                  </div>
                  <div class="col-sm-3">
                    <input type="text" class="form-control form-control-user" id="endereconum" placeholder="Número" value="###########numero usuario###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-8 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="complemento" placeholder="Complemento" value="###########complemento usuário###########">
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control form-control-user" id="bairro" placeholder="Bairro" value="###########bairro usuario###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-8 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="cidade" placeholder="Cidade" value="###########cidade usuario###########">
                  </div>
                  <div class="col-sm-4">
                    <input type="text" class="form-control form-control-user" id="estado" placeholder="Estado" value="###########estado###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-8 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="cep" placeholder="CEP" value="###########CEP###########">
                  </div>
                  <div class="col-sm-4">
                    <input type="tel" class="form-control form-control-user" id="tel" placeholder="Telefone" value="###########telefone###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="password" placeholder="Senha" required>
                  </div>
                </div>
                <input id="submitBtn" type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
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