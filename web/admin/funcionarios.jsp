<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp" %>
<c:choose>
    <c:when test="${sessionScoped.login.tipoUsuario.id < 3}">
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

    <!-- Page Heading -->
    <c:url value="../FuncionarioServlet" var="novo">
        <c:param name="action" value="novo"/>        
    </c:url>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="${novo}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Funcionário</a>
    </div>

</div>
<!-- Funcionários -->
<div class="row">
    <div class="col-md-12">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Funcionários</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <c:choose>
                        <c:when test="${empty sessionScope.funcionarios}">
                            <p>Não existem funcionários a serem apresentadas.</p>
                        </c:when>                        
                        <c:otherwise>      
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>Endereço</th>
                                        <th>Telefone</th>
                                        <th>Editar</th>
                                        <th>Remover</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Dados Funcionário -->
                                    <c:forEach items="${sessionScope.funcionarios}" var="funcionario">
                                        <tr>
                                            <td>
                                                <c:if test="${funcionario.tipoUsuario.id eq 3}">
                                                    <i class="fas fa-user-tie"></i>
                                                </c:if>
                                                <c:out value=" ${funcionario.nome}"/></td>
                                            <td><c:out value="${funcionario.cpf}"/></td>
                                            <td><c:out value="${funcionario.endereco.endereco} - ${funcionario.endereco.numero}"/></td>
                                            <td>${funcionario.telefone}</td>
                                            <c:url value="../FuncionarioServlet" var="edit">
                                                <c:param name="action" value="modificar"/>
                                                <c:param name="id" value="${funcionario.id}"/>                                                
                                            </c:url>
                                            <td><a href="${edit}"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
                                            <c:url value="../FuncionarioServlet" var="remover">
                                                <c:param name="action" value="remover"/>
                                                <c:param name="id" value="${funcionario.id}"/>                                                                                                                
                                            </c:url>
                                            <td><a href="${remover}"><i class="fas fa-trash" style="color: red;"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <!-- fim Dados Funcionário -->
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>  
                    <c:remove scope="session" var="funcionarios"/>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- fim Funcionários -->
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>