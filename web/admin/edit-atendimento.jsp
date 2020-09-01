<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
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
                            <h1 class="h4 text-gray-900 mb-4">Informações do Atendimento</h1>
                        </div>
                        <c:choose>
                            <c:when test="${param.action eq 'novo'}">
                                <c:url value="../AtendimentoServlet" var="actionurl">
                                    <c:param name="action" value="adicionar"/>                                    
                                </c:url>
                            </c:when>
                            <c:when test="${param.action eq 'modificar'}">
                                <c:url value="../AtendimentoServlet" var="actionurl">
                                    <c:param name="action" value="modificar"/>                                    
                                </c:url>
                                <c:set var="id" value="${param.id}"/>                                        
                                <c:set var="nome" value="${param.nome}"/>                                        
                            </c:when>
                        </c:choose>
                        <form class="user" action="${actionurl}" method="post">                            
                            <div class="form-group row">
                                <div class="col-sm-5 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Nome Completo" disabled value="${atendimento.usuario.nome}">
                                </div>
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <input type="email" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email" disabled value="${atendimento.usuario.email}">
                                </div>
                                <div class="col-sm-3">
                                    <input type="tel" class="form-control form-control-user" id="exampleRepeattext" placeholder="Telefone" disabled value="${atendimento.usuario.telefone}">
                                </div>
                            </div>                            
                            <div class="form-group row">
                                <div class="col-sm-4 mb-3 mb-sm-0">
                                    <select class="form-control" style="border-radius: 50px; height: calc(2.2em + .75rem + 2px); " id="exampleLastName" name="produto" required>
                                        <c:choose>
                                            <c:when test="${param.action eq 'novo'}">
                                                <c:forEach items="${sessionScope.produtos}" var="produto">                                                    
                                                    <option value="${produto.id}">${produto.nome}</option>                                                    
                                                </c:forEach>
                                            </c:when>
                                            <c:when test="${param.action eq 'modificar'}">
                                                <option value="${atendimento.produto.id}" selected>${atendimento.produto.nome}</option>
                                                <c:forEach items="${sessionScope.produtos}" var="produto">                                               
                                                    <c:if test="${atendimento.produto.id != produto.id}">
                                                        <option value="${produto.id}">${produto.nome}</option>         
                                                    </c:if>
                                                </c:forEach>
                                            </c:when>
                                        </c:choose>                                                                             
                                    </select>
                                </div>                                                        
                                <div class="col-sm-3">
                                    <c:choose>
                                        <c:when test="${param.action eq 'novo'}">
                                            <select class="form-control" style="border-radius: 50px; height: calc(2.2em + .75rem + 2px); " id="exampleLastName" name="tipoatendimento" required>
                                                <c:forEach items="${sessionScope.tiposatendimento}" var="tipoatendimento">                                                    
                                                    <option value="${tipoatendimento.id}">${tipoatendimento.nome}</option>                                                    
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select class="form-control" style="border-radius: 50px; height: calc(2.2em + .75rem + 2px); " id="exampleLastName" name="tipoatendimento" disabled required>
                                                <option value="${atendimento.tipoAtendimento.id}" selected>${atendimento.tipoAtendimento.nome}</option>
                                            </select>                                            
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <c:if test="${param.action eq 'modificar'}">
                                    <div class="col-sm-3 pt-3 pl-5">
                                        <c:choose>
                                            <c:when test="${atendimento.aberto}">
                                                <input class="form-check-input" type="checkbox" id="resolvido" name="resolvido" value="Resolver"/>            
                                                <label class="form-check-label" for="resolvido">Resolvido?</label>                                                
                                            </c:when>
                                            <c:otherwise>
                                                <input class="form-check-input" type="checkbox" id="resolvido" name="resolvido" value="Resolver" checked disabled/>            
                                                <label class="form-check-label" for="resolvido">Resolvido?</label>  
                                            </c:otherwise>
                                        </c:choose>
                                    </div>                                    
                                </c:if>   
                                <c:if test="${param.action eq 'modificar'}">                                    
                                    <div class="col-sm-2 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Data e Hora" disabled value="${atendimento.dataHora}">
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-12 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Descrição" name="descricao" value="${atendimento.descricao}" required>
                                </div>
                            </div>
                            <c:if test="${login.tipoUsuario.id > 1}">                                        
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Solução" name="solucao" value="${atendimendo.solucao}" required>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${login.tipoUsuario.id eq 1}">                                        
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Solução" name="tipoatendimento" disabled value="${atendimendo.solucao}">
                                    </div>
                                </div>
                            </c:if>
                            <input type="hidden" value="${login.id}" name="id"/> 
                            <input type="hidden" value="${atendimento.usuario.id}" name="idAtendimento"/> 
                            <c:choose>
                                <c:when test="${atendimento.aberto or empty atendimento}">
                                    <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                                </c:otherwise>
                            </c:choose>
                            <c:url value="../AtendimentoServlet" var="voltar">
                                <c:param name="action" value="home"/>
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