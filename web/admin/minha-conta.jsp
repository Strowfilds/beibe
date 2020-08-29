<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<jsp:include page="header.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <!-- PAINEL COM OS DADOS DA CONTA -->
                <c:choose>
                    <c:when test="${empty sessionScope.usuario}">
                        <div class="row container-fluid">                            
                            <div class="p-5 col-12">
                                <div class="text-center">
                                    <div class="alert alert-danger" role="alert">
                                        <h4 class="alert-heading p-3">Ops! Algo de errado não está certo.</h4>
                                        <hr>
                                        <p> Não foi possível carregar os dados do usuário!</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:catch var="exc">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Informações do <c:out value="${login.tipoUsuario.value}"/> </h1>
                                    </div>
                                    <form class="user">
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="Nome Completo"  value="${usuario.nome}">
                                            </div>
                                            <div class="col-sm-6">                                                
                                                <input type="text" class="form-control form-control-user" id="cpf" placeholder="CPF" disabled value="${usuario.cpf}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email" disabled value="${usuario.email}">
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-9 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Endereço" value="${usuario.endereco.endereco}">
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Número" value="${usuario.endereco.numero}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Complemento" value="${usuario.endereco.complemento}">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Bairro" value="${usuario.endereco.bairro}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="Cidade" value="${usuario.endereco.cidade.nome}">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-user" id="exampleRepeattext" placeholder="Estado" value="${usuario.endereco.estado.nome}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" placeholder="CEP" value="${usuario.endereco.cep}">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="tel" class="form-control form-control-user" id="exampleRepeattext" placeholder="Telefone" value="${usuario.telefone}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Senha" required>
                                            </div>
                                        </div>
                                        <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">
                                        <c:if test="${login.tipoUsuario.id eq 3}">
                                            <input type="submit" value="Excluir Conta De Usuário" class="btn btn-primary btn-user btn-block btn-danger">
                                        </c:if>
                                        <hr>
                                    </form>
                                </div>
                            </div>
                            <c:remove scope="session" var="usuario" />
                        </c:catch>
                    </c:otherwise>
                </c:choose>
                <c:if test="${not empty exc}">
                    <div class="p-5">
                        <div class="alert alert-danger" role="alert">
                            Ocorreu algum problema ao carregar a tela com informações.
                        </div>
                    </div>
                </c:if>
                <!-- PAINEL COM OS DADOS DA CONTA -->
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<jsp:include page="footer.jsp" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script>
    $(document).ready(function () {
        var $seuCampoCpf = $("#cpf");
    });

    $(document).ready(function () {
        var $seuCampoCpf = $("#cpf");
        $seuCampoCpf.mask('000.000.000-00', {reverse: true});
    });
</script>