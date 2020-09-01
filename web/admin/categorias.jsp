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

    <!-- Page Heading -->
    <c:url value="../CategoriaServlet" var="novo">
        <c:param name="action" value="novo"/>        
    </c:url>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="${novo}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Categoria</a>
    </div>

</div>

<!-- Clientes -->
<div class="row">
    <div class="col-md-12">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Categorias</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <c:choose>
                        <c:when test="${empty sessionScope.categorias}">
                            <p>Não existem categorias a serem apresentadas.</p>
                        </c:when>                        
                        <c:otherwise>                            
                            <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th style="width:  5%">Editar</th>
                                        <th style="width:  5%">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Dados categorias -->
                                    <c:forEach items="${sessionScope.categorias}" var="categoria">                                        
                                        <tr>categorias
                                            <td><c:out value="${categoria.nome}"/></td>
                                            <c:url value="../CategoriaServlet" var="edit">
                                                <c:param name="action" value="modificar"/>
                                                <c:param name="id" value="${categoria.id}"/>
                                                <c:param name="nome" value="${categoria.nome}"/>
                                            </c:url>
                                            <td><a href="${edit}"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
                                                    <c:url value="../CategoriaServlet" var="remover">
                                                        <c:param name="action" value="remover"/>
                                                        <c:param name="id" value="${categoria.id}"/>                                                                                                                
                                                    </c:url>
                                            <td><a href="${remover}"><i class="fas fa-trash" style="color: red;"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    <!-- fim Dados categorias -->
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>  
                    <c:remove scope="session" var="categorias"/>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- fim clientes -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>