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
                                    <c:url value="../UsuarioServlet" var="actionurl">
                                        <c:param name="action" value="editar"/>                                    
                                    </c:url>
                                    <form class="user" action="${actionurl}" method="post">
                                        <input type="hidden" value="${login.id}" name="id"/> 
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="nomecompleto" name="nome" placeholder="Nome Completo"  value="${usuario.nome}">
                                            </div>
                                            <div class="col-sm-6">                                                
                                                <input type="text" class="form-control form-control-user" id="cpf" placeholder="CPF" disabled value="${usuario.cpf}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="email" placeholder="Email" disabled value="${usuario.email}">
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-9 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" name="endereco" placeholder="Endereço" value="${usuario.endereco.endereco}">
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control form-control-user" id="exampleRepeattext" name="num" placeholder="Número" value="${usuario.endereco.numero}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="exampleInputtext" name="compl" placeholder="Complemento" value="${usuario.endereco.complemento}">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control form-control-user" id="exampleRepeattext" name="bairro" placeholder="Bairro" value="${usuario.endereco.bairro}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-4">

                                                <select class="form-control" style="border-radius: 50rem;" name="estado" id="estado">
                                                    <option value="${usuario.endereco.estado.id}">${usuario.endereco.estado.nome} - ${usuario.endereco.estado.sigla}</option>  
                                                    <c:forEach items="${applicationScope.estados}" var="estado">     
                                                        <c:if test="${usuario.endereco.estado.id != estado.id}">                                                                
                                                            <option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>                                                    
                                                        </c:if>
                                                    </c:forEach>
                                                </select>                                                
                                            </div>
                                                    <div class="col-sm-8 mb-3 mb-sm-0">
                                                        <select class="form-control" style="border-radius: 50rem;" name="cidade" id="cidade">                             
                                                            <option value="${usuario.endereco.cidade.id}" selected>${usuario.endereco.cidade.nome}</option>                               
                                                        </select>                                                
                                                    </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-8 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" id="cep" name="cep" placeholder="CEP" value="${usuario.endereco.cep}">
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="tel" class="form-control form-control-user" id="tel" name="tel" placeholder="Telefone" value="${usuario.telefone}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user" id="exampleInputPassword" name="senha" placeholder="Senha" required>
                                            </div>
                                        </div>
                                        <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block btn btn-success">                                        
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

<%@include file="footer.jsp" %>
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
