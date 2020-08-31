<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Informações do Produto</h1>
                        </div>
                        <c:choose>
                            <c:when test="${param.action eq 'novo'}">
                                <c:url value="../ProdutoServlet" var="actionurl">
                                    <c:param name="action" value="adicionar"/>                                    
                                </c:url>
                            </c:when>
                            <c:when test="${param.action eq 'modificar'}">
                                <c:url value="../ProdutoServlet" var="actionurl">
                                    <c:param name="action" value="editar"/>                                    
                                </c:url>
                                <c:set var="id" value="${param.id}"/>                                        
                                <c:set var="nome" value="${param.nome}"/>                                        
                            </c:when>
                        </c:choose>
                        <form class="user" action="${actionurl}" method="post">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Nome" name="produto" value="${produto.nome}" required>
                                </div>
                                <div class="col-sm-6">
                                    <select class="form-control" style="border-radius: 50px; height: calc(2.2em + .75rem + 2px); " id="exampleLastName" name="categoria" required>
                                        <c:choose>
                                            <c:when test="${param.action eq 'novo'}">
                                                <c:forEach items="${sessionScope.categorias}" var="categoria">                                                    
                                                        <option value="${categoria.id}">${categoria.nome}</option>                                                    
                                                </c:forEach>
                                            </c:when>
                                            <c:when test="${param.action eq 'modificar'}">
                                                <option value="${produto.categoria.id}" selected>${produto.categoria.nome}</option>
                                                <c:forEach items="${sessionScope.categorias}" var="categoria">                                               
                                                    <c:if test="${categoria.id != produto.categoria.id}">
                                                        <option value="${categoria.id}">${categoria.nome}</option>         
                                                    </c:if>
                                                </c:forEach>
                                            </c:when>
                                        </c:choose>                                                                             
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-9 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Descrição" name="descricao" value="${produto.descricao}" required>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Peso" name="peso" value="${produto.peso}" required>
                                </div>
                            </div>
                            <c:if test="${not empty produto.id}">
                                <input type="hidden" value="${produto.id}" name="id"/> 
                            </c:if>
                            <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                            <c:url value="../ProdutoServlet" var="voltar">
                                <c:param name="action" value="listproduto"/>
                            </c:url>
                            <a href="${voltar}" class="btn btn-primary btn-user btn-block btn btn-secondary">Voltar</a>
                            <hr>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
