<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Success" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">

    <div class="container">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <div class="row">
            <div class="col-6 offset-3">
                <%--TODO: add 5-sec JavaScript auto-redirect timeOut--%>
                <c:choose>
                    <c:when test="${!empty userId}">
                        <p>
                            Glad to see you, ${pageContext.request.remoteUser}!.
                            Head on over to the <a href="${pageContext.request.contextPath}/index.jsp">main site</a> to get started!
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p class="text-error">
                            Login unsuccessful. Please check that username and password are entered correctly and try again.
                            <a href="${pageContext.request.contextPath}/login.jsp">Return to login page</a>.
                        </p>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>

    </div>




</body>
</html>
