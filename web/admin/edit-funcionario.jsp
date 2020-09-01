<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Informações do Funcionário</h1>
                        </div>
                        <c:choose>
                            <c:when test="${param.action eq 'novo'}">
                                <c:url value="../FuncionarioServlet" var="actionurl">
                                    <c:param name="action" value="adicionar"/>                                    
                                </c:url>
                            </c:when>
                            <c:when test="${param.action eq 'modificar'}">
                                <c:url value="../FuncionarioServlet" var="actionurl">
                                    <c:param name="action" value="editar"/>                                    
                                </c:url>
                                <c:set var="id" value="${param.id}"/>                                        
                                <c:set var="nome" value="${param.nome}"/>                                        
                            </c:when>
                        </c:choose>
                        <form class="user" action="${actionurl}" method="post">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="nomecompleto" name="nome" placeholder="Nome Completo" value="${funcionario.nome}" required>
                                </div>
                                <c:choose>
                                    <c:when test="${param.action eq 'novo'}">
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control form-control-user" id="CPF" name="cpf" placeholder="CPF" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-user" id="email" name="email" placeholder="Email" required>                                        
                                    </div>
                                </c:when>
                                <c:otherwise>                                                                              
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="cpf" placeholder="CPF" disabled value="${funcionario.cpf}">
                                    </div>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user" id="email" placeholder="Email" disabled value="${funcionario.email}">                                        
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="form-group row">
                        <div class="col-sm-9 mb-3 mb-sm-0">
                            <input type="text" class="form-control form-control-user" id="endereco" name="endereco" placeholder="Endereço" value="${funcionario.endereco.endereco}" required>
                        </div>
                        <div class="col-sm-3">
                            <input type="text" class="form-control form-control-user" id="endereconum" name="num" placeholder="Número" value="${funcionario.endereco.numero}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                            <input type="text" class="form-control form-control-user" id="complemento" name="compl" placeholder="Complemento" value="${funcionario.endereco.complemento}">
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control form-control-user" id="bairro" name="bairro" placeholder="Bairro" value="${funcionario.endereco.bairro}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                            <select class="form-control" style="border-radius: 50px;" name="cidade" id="cidade" required>                             
                                <option value="${funcionario.endereco.cidade.id}">${funcionario.endereco.cidade.nome}</option>                             
                            </select>
                        </div>
                        <div class="col-sm-4">
                            <c:choose>
                                <c:when test="${param.action eq 'novo'}">                                    
                                    <select class="form-control" style="border-radius: 50px;" name="estado" id="estado" required>
                                        <c:forEach items="${applicationScope.estados}" var="estado">     
                                            <option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="form-control" style="border-radius: 50px;" name="estado" id="estado" required>
                                        <option value="${funcionario.endereco.estado.id}">${funcionario.endereco.estado.nome} - ${funcionario.endereco.estado.sigla}</option>  
                                        <c:forEach items="${applicationScope.estados}" var="estado">     
                                            <c:if test="${funcionario.endereco.estado.id != estado.id}">                                                                
                                                <option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>                                                    
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-8 mb-3 mb-sm-0">
                            <input type="text" class="form-control form-control-user" id="cep" name="cep" placeholder="CEP" value="${funcionario.endereco.cep}" required>
                        </div>
                        <div class="col-sm-4">
                            <input type="tel" class="form-control form-control-user" id="tel" name="tel" placeholder="Telefone" value="${funcionario.telefone}" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <input type="password" class="form-control form-control-user" id="password" name="senha" placeholder="Senha" required>
                        </div>
                        <div class="col-sm-3 pt-3 pl-5">
                            <c:if test="${sessionScope.login.tipoUsuario.id eq 3}">
                                <input class="form-check-input" type="checkbox" id="gerente" name="gerente" value="Gerente"/>            
                                <label class="form-check-label" for="gerente">Gerente</label>  
                            </c:if>
                        </div>
                    </div>

                    <c:if test="${param.action eq 'modificar'}" >
                        <input type="hidden" value="${funcionario.id}" name="id"/> 
                    </c:if>
                    <input id="submitBtn" type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                    <c:url value="../FuncionarioServlet" var="funcionarios">
                        <c:param name="action" value="listfuncionarios"/>
                    </c:url>
                    <a href="${funcionarios}" class="btn btn-primary btn-user btn-block btn btn-secondary">Voltar</a>
                    <hr>
                    </form>
                    <c:remove scope="session" var="funcionario"/>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="footer.jsp" %>
<script>
    $(document).ready(function () {
        var $seuCampoCpf = $("#CPF");
    });

    $(document).ready(function () {
        var $seuCampoCpf = $("#CPF");
        $seuCampoCpf.mask('000.000.000-00', {reverse: true});
    });
    $(document).ready(function () {
        var $seuCampoTel = $("#tel");
    });

    $(document).ready(function () {
        var $seuCampoTel = $("#tel");
        $seuCampoTel.mask('00 0 0000-0000', {reverse: true});
    });
    $(document).ready(function () {
        var $seuCampoCep = $("#cep");
    });

    $(document).ready(function () {
        var $seuCampoCep = $("#cep");
        $seuCampoCep.mask('00.000-000', {reverse: true});
    });
</script>
<script type="text/javascript" >

    $(document).ready(function () {
        $("#estado").change(function () {
            getCidades();
        });
    });

    function getCidades() {
        var estadoId = $("#estado").val();
        var url = "AJAXServlet";
        $.ajax({
            url: url, // URL da sua Servlet
            data: {
                estadoId: estadoId
            }, // Parâmetro passado para a Servlet
            dataType: 'json',
            success: function (data) {
                // Se sucesso, limpa e preenche a combo de cidade
                // alert(JSON.stringify(data));
                $("#cidade").empty();
                $.each(data, function (i, obj) {
                    $("#cidade").append('<option value=' + obj.id + '>' + obj.nome + '</option>');
                });
            },
            error: function (request, textStatus, errorThrown) {
                alert(request.status + ', Error: ' + request.statusText);
                // Erro
            }
        });
    }
</script>
<script>
    $(window).on('load', function () {
        getCidades();
    });
</script>
