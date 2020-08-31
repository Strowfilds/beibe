<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Registro</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">       

    </head>

    <body style="background-color: #151215">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block" style="background-image: url(../images/gallery/gallery-3.jpg); background-repeat: no-repeat; background-size: cover;"></div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Cadastre-se</h1>
                                </div>
                                <c:url value="/UsuarioServlet" var="login">
                                    <c:param name="action" value="autocadastro" />
                                </c:url>
                                <form class="user" action="${login}" method="post">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" name="nome" placeholder="Nome Completo" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control form-control-user" name="cpf" id="CPF" placeholder="CPF" value="00000000000" required>
                                            <div id="resultadoValidacao"></div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-user" name="email" placeholder="Email" required>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-9 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" name="endereco" placeholder="Endereço" required>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="num" maxlength="5" class="form-control form-control-user" name="num" placeholder="Número" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-8 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" name="compl" placeholder="Complemento">
                                        </div>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control form-control-user" name="bairro" placeholder="Bairro" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <select class="form-control" style="border-radius: 50px;" name="cidade" id="cidade">                             
                                                <option value="0" selected>Selecione um estado</option>                               
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <select class="form-control" style="border-radius: 50px;" name="estado" id="estado">
                                                <c:forEach items="${applicationScope.estados}" var="estado">                                                    
                                                    <option value="${estado.id}">${estado.nome} - ${estado.sigla}</option>                                                    
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="text" class="form-control form-control-user" id="cep" name="cep" placeholder="CEP" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="tel" class="form-control form-control-user" id="tel" name="tel" placeholder="Telefone" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="password" class="form-control form-control-user" id="psw" name="senha" placeholder="Senha" required>
                                        </div>                                        
                                    </div>
                                    <input id="submitBtn" type="submit" value="Cadastre-me" class="btn btn-primary btn-user btn-block">
                                    <hr>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="login.jsp">Já tem uma conta? Faça o Login</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- -->
        <script src='https://code.jquery.com/jquery-latest.min.js'></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
        <!--<script type="text/javascript" src="js/cpf.js"></script>-->

        
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
    </body>

</html>
