<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <c:url value="../ProdutoServlet" var="novo">
        <c:param name="action" value="novo"/>        
    </c:url>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="${novo}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Adicionar Produto</a>
    </div>

</div>

<!-- Clientes -->
<div class="row">
    <div class="col-md-12">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Produtos</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <c:choose>
                        <c:when test="${empty sessionScope.produtos}">
                            <p>Não existem produtos a serem apresentadas.</p>
                        </c:when>                        
                        <c:otherwise>      
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Categoria</th>
                                        <th>Descrição</th>
                                        <th>Peso</th>
                                        <th>Editar</th>
                                        <th>Remover</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Dados cliente -->
                                    <c:forEach items="${sessionScope.produtos}" var="produto">
                                    <tr>
                                        <td><c:out value="${produto.nome}"/></td>
                                        <td><c:out value="${produto.categoria.nome}"/></td>
                                        <td><c:out value="${produto.descricao}"/></td>
                                        <fmt:formatNumber value="${produto.peso}" type="number" var="pesoFmt" maxFractionDigits="2" pattern="##.##" />
                                        <td><c:out value="${pesoFmt} g"/></td>
                                            <c:url value="../ProdutoServlet" var="edit">
                                                <c:param name="action" value="modificar"/>
                                                <c:param name="id" value="${produto.id}"/>                                                
                                            </c:url>
                                            <td><a href="${edit}"><i class="fas fa-pencil-alt" style="color: orange;"></i></a></td>
                                            <c:choose>
                                                <c:when test="${produto.delSafe}">
                                                    <c:url value="../ProdutoServlet" var="remover">
                                                        <c:param name="action" value="remover"/>
                                                        <c:param name="id" value="${produto.id}"/>                                                                                                                
                                                    </c:url>
                                                    <td><a href="${remover}"><i class="fas fa-trash" style="color: red;"></i></a></td>
                                                </c:when>
                                                <c:otherwise>                                                                                          
                                                    <td><a href="#" title='Não é possível remover este produto!' disabled><i class="fas fa-trash" style="color: gray;"></i></a></td>                                                      
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                        </tr>
                                    </c:forEach>
                                    <!-- fim Dados cliente -->
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>  
                    <c:remove scope="session" var="produtos"/>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- fim clientes -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>