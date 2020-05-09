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
                <%--TODO: add 5-sec JavaScript auto-redirect timeOut on successful login--%>
                <c:choose>
                    <c:when test="${!empty userId}">
                        <div>
                            Glad to see you, ${pageContext.request.remoteUser}!
                            Head on over to the <a href="${pageContext.request.contextPath}/index.jsp">main site</a> to get started!
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="text-error">
                            Oops! Something went wrong. Check that you entered the correct URL.
                        </div>
                        <div class="mt-2 mb-2">
                            Return to <a href="${pageContext.request.contextPath}/login.jsp">login page</a>.
                        </div>
                        <div>
                            Return to <a href="${pageContext.request.contextPath}/index.jsp">home page</a>.
                        </div>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>

    </div>




</body>
</html>
