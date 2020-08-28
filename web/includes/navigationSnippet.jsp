<!-- Default snippet for navigation -->
<div class="main-navigation" style="margin: auto; margin-right: 0;">
    <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
    <ul class="menu">
        <li class="menu-item"><a href="sobre.jsp">Sobre</a></li>
        <li class="menu-item"><a href="servicos.jsp">Serviços</a></li>
        <li class="menu-item"><a href="galeria.jsp">Galeria</a></li>
        <li class="menu-item"><a href="contato.jsp">Contato</a></li>
        <c:url value="admin/login.jsp" var="login"/>
        <li class="menu-item"><a href="${login}">Entrar</a></li>
    </ul> <!-- .menu -->
</div> <!-- .main-navigation -->