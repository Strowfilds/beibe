<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="header.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                                        <c:out value="Resolvido" /> <i class="fas fa-check-circle" style="color: green;"></i>
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
                                            <c:url value="../AtendimentoServlet" var="edit">
                                                <c:param name="action" value="modificar"/>
                                                <c:param name="id" value="${atendimento.id}"/>                                                
                                            </c:url>
                                            <td><a href="${edit}"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
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
<!-- atendimentos funcionário -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>