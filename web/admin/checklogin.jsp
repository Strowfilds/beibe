<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.Login}">
    <c:set var="msg" value="Usuário deve se autentificar para acessar o sistema." scope="request" />
    <c:redirect url="${request.getContextPath}/index.jsp"/>
    <jsp:forward page="../djsp" />
</c:if>