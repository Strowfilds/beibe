<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<c:choose>
    <c:when test="${sessionScoped.login.tipoUsuario.id < 2}">
        <jsp:forward page="erro.jsp" >
            <jsp:param name="msg" value="Usuário não possui privilégio suficiente para acessar o sistema."  />
            <jsp:param name="cod" value="401" />
        </jsp:forward>
    </c:when>
</c:choose>
<c:if test="${empty sessionScope.login}">     
    <jsp:forward page="erro.jsp" >
        <jsp:param name="msg" value="Usuário deve se autentificar para acessar o sistema."  />
        <jsp:param name="cod" value="403" />
    </jsp:forward>
</c:if>

<!-- Begin Page Content -->
<div class="container-fluid">

</div>

<!-- atendimentos funcionário -->
<div class="row">
    <div class="col-md-12">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Atendimentos</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <c:choose>
                            <c:when test="${empty sessionScope.atendimentos}">
                                <thead>
                                    <tr>
                                        <th colspan="9">Não existem atendimentos</th>
                                    </tr>
                                </thead>
                            </c:when>
                            <c:when test="${fn:length(atendimentos) > 1}">
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
                                    <!-- DADOS ATENDIMENTOS -->
                                    <c:forEach items="${sessionScope.atendimentos}" var="atendimento">                                        
                                        <tr>
                                            <td><c:out value="atendimento.dataHora"/></td>
                                            <td><c:out value="atendimento.usuario.nome"/></td>
                                            <td>
                                                <c:out value="atendimento.aberto"/>
                                                <!--
                                                <button style="pointer-events: none;" type="button" class="btn btn-primary">Aberto</button>
                                                <button style="pointer-events: none;" type="button" class="btn btn-success">Resolvido</button>
                                                <button style="pointer-events: none;" type="button" class="btn btn-danger">Pendente</button>
                                                <button style="pointer-events: none;" type="button" class="btn btn-warning">Em andamento</button>
                                                <button style="pointer-events: none;" type="button" class="btn btn-info">Congelado</button>
                                                -->
                                            </td>
                                            <td>
                                                <c:out value="atendimento.produto.nome"/>
                                            </td>
                                            <td>
                                                <c:out value="atendimento.tipoAtendimento.nome"/>
                                            </td>
                                            <td><a href="###########CRIAR LINK BASEADO NA  JSP VIEW-ATENDIEMENTO####################">Mais detalhes</a></td>
                                            <td><a href="edit-atendimento.jsp"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
                                            <td><a href="##############EXCLUIR ATENDIMENTO##############"><i class="fas fa-trash" style="color: red;"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <!-- DADOS ATENDIMENTOS -->
                                </tbody>

                            </c:when>

                        </c:choose>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- atendimentos funcionário -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>