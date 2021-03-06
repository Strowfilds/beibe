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
              <form class="user" action="###########AtendimentoServlet#############">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nomecompleto" placeholder="Nome Completo" disabled value="#########nome do usuario###########">
                  </div>
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="email" class="form-control form-control-user" id="email" placeholder="Email" disabled value="###########email usuario###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6">
                    <input type="tel" class="form-control form-control-user" id="tel" placeholder="Telefone" disabled value="###########telefone###########">
                  </div>
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="cep" placeholder="CEP" disabled value="###########DATA E HORA###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="produto" placeholder="Produto" disabled value="###########PRODUTO###########">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="situacao" placeholder="Situação" disabled value="###########SITUAÇÂO###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user" id="tipoAtendimento" placeholder="Tipo do Atendimento" disabled value="###########TIPO DO ATENDIMENTO###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="descricao" placeholder="Descrição" disabled value="###########DESCRICAO###########">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-12">
                    <input type="text" class="form-control form-control-user" id="solucao" placeholder="Solução" disabled value="###########SOLUCAO###########">
                  </div>
                </div>
                <a href="clientes.jsp" class="btn btn-primary btn-user btn-block btn btn-secondary">Voltar</a>
                <hr>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<%@include file="footer.jsp" %>
