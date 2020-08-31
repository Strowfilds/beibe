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
                            <h1 class="h4 text-gray-900 mb-4">Informações da Categoria</h1>
                        </div>
                        <div class="row">
                            <div class="col-lg-3 col-1"></div>
                            <div class="col-lg-6 col-10">
                                <c:choose>
                                    <c:when test="${param.action eq 'novo'}">
                                        <c:url value="../CategoriaServlet" var="actionurl">
                                            <c:param name="action" value="adicionar"/>                                    
                                        </c:url>
                                    </c:when>
                                    <c:when test="${param.action eq 'modificar'}">
                                        <c:url value="../CategoriaServlet" var="actionurl">
                                            <c:param name="action" value="editar"/>                                    
                                        </c:url>
                                        <c:set var="id" value="${param.id}"/>                                        
                                        <c:set var="nome" value="${param.nome}"/>                                        
                                    </c:when>
                                </c:choose>
                                <form class="user" action="${actionurl}" method="post">
                                    <div class="form-group row">
                                        <div class="col-12 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" id="nome" placeholder="Nome da Categoria" value="${empty nome ? '' : nome}" name="categoria" required>
                                        </div>
                                    </div>
                                    <c:if test="${not empty id}">
                                        <input type="hidden" value="${id}" name="id"/> 
                                    </c:if>
                                    <input id="submitBtn" type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success mb-2">
                                    <c:url value="../CategoriaServlet" var="voltar">
                                        <c:param name="action" value="listcategoria"/>
                                    </c:url>
                                    <a href="${voltar}" class="btn btn-primary btn-user btn-block btn btn-secondary">Voltar</a>
                                    <hr>
                                </form>
                            </div>
                            <div class="col-lg-3 col-1"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
