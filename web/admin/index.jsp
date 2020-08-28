<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!-- Begin Page Content -->
<div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="relatorios.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Gerar Relatórios</a>
          </div>
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-plus fa-sm text-white-50"></i> Abrir um chamado</a>
          </div>

          <div class="row">

            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Atendimentos até o Momento</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">400</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Atendimentos Abertos</div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                        </div>
                        <div class="col">
                          <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Presencial</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">20 / 30</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-handshake fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Telefônico</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">20 / 30</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-phone fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Online</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">20 / 30</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-at fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
          

        </div>

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
                        <th><a href="#page-top"><i class="fas fa-save" style="color: grey;"></i></a></th>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
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
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
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

      <jsp:include page="footer.jsp" />
