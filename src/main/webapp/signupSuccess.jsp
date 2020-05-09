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
            <%--TODO: add 5-sec JavaScript auto-redirect for account creation ???--%>
            <c:choose>
                <c:when test="${!empty newUserId}">
                    <p>
                        Account with ID
                        <span class='text-success'>
                            <c:out value = "${newUserId}" />
                        </span> successfully created! Visit
                        <a href='loginAction'>Login page</a> to log in.
                    </p>
                </c:when>
                <c:otherwise>
                    <c:otherwise>
                        <div class="text-error">
                            Oops! Something went wrong. Check that you entered the correct URL.
                        </div>
                        <div class="mt-2 mb-2">
                            Return to <a href="${pageContext.request.contextPath}/signup.jsp">sign-up page</a>.
                        </div>
                        <div>
                            Return to <a href="${pageContext.request.contextPath}/index.jsp">home page</a>.
                        </div>
                    </c:otherwise>
                </c:otherwise>

            </c:choose>
            </div>
        </div>

    </div>




</body>
</html>
