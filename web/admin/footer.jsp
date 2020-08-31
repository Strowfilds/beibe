 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; BEIBE 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Partindo já?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">X</span>
          </button>
        </div>
        <div class="modal-body">Pressione "Logout" abaixo se você realmente deseja sair</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
          <c:url value="../LogoutServlet" var="logout"/>
          <a class="btn btn-primary" href="${logout}">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- -->
  <script src='https://code.jquery.com/jquery-latest.min.js'></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
  <script type="text/javascript" src="js/cpf.js"></script>

  
  

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

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
  <!--
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
  -->
</body>
</html>