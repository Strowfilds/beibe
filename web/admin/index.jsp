<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<c:if test="${empty sessionScope.login}">     
    <jsp:forward page="erro.jsp" >
        <jsp:param name="msg" value="Usuário deve se autentificar para acessar o sistema."  />
        <jsp:param name="cod" value="403" />
    </jsp:forward>
</c:if>
<!-- Begin Page Content -->
<div class="container-fluid">

    <c:if test= "${sessionScope.login.tipoUsuario.id eq 3}">
        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="relatorios.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-download fa-sm text-white-50"></i> Gerar Relatórios</a>
        </div>
    </c:if>

    <c:if test= "${sessionScope.login.tipoUsuario.id eq 1}">
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <c:url value="../AtendimentoServlet" var="novoatendimento">
                <c:param name="action" value="novo"/>
            </c:url>
            <a href="${novoatendimento}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm f-right"><i class="fas fa-plus fa-sm text-white-50"></i> Abrir um chamado</a>
        </div>
    </c:if>

    <c:if test= "${sessionScope.login.tipoUsuario.id > 1}">
        <!-- Estatísticas ATENDIMENTOS -->
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
        </div>
        <!-- Estatísticas ATENDIMENTOS -->
    </c:if>
</div>
<c:if test="${sessionScope.login.tipoUsuario.id > 1}" >

    <!-- atendimentos abertos -->

    <div class="row">
        <div class="col-md-12">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Atendimentos abertos</h6>
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
            <!--
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
            -->
        </div>
    </div>
</c:if>
</div>

<!-- atendimentos funcionário -->
<c:if test="${sessionScope.login.tipoUsuario.id eq 1}" >
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
                            <c:choose>
                                <c:when test="${empty atendimentos}">
                                     <thead>
                                    <tr>
                                        <th colspan="9">Não há atendimentos marcados</th>
                                    </tr>
                                </thead>  
                                </c:when>
                                <c:otherwise>                                    
                                    <thead>
                                        <tr>
                                            <th>Data</th>                                            
                                            <th>Situação Do Atendimento</th>
                                            <th>Produto</th>
                                            <th>Tipo Do Atendimento</th>
                                            <th>Descrição</th>
                                            <th>Solução Apresentada</th>
                                            <th>Editar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.atendimentos}" var="atendimento">
                                        <tr>
                                            <td><fmt:formatDate value="${atendimento.dataHora}" pattern="dd/MM/yyyy"/> </td>                                            
                                            <td>
                                                <c:choose>
                                                    <c:when test="${atendimento.aberto}">
                                                        <c:out value="Em aberto" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="Resolvido" />
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:out value="${atendimento.produto.nome}"/>
                                            </td>
                                            <td>                                                
                                                <c:out value="${atendimento.tipoAtendimento.nome}"/>
                                            </td>
                                            <td><c:out value="${atendimento.descricao}"/></td>
                                            <td><c:out value="${atendimento.solucao}"/></td>
                                            <td><a href="#page-top"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
                                        </tr>                                            
                                        </c:forEach>
                                    </tbody>
                                </c:otherwise>
                            </c:choose>                            
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
</div>
<!-- atendimentos cliente -->
</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>
