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
            <%--TODO: add 5-sec JavaScript auto-redirect for either situation--%>
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
                        <p class="text-error">
                            There was a problem creating new account. Please check that all required fields were filled out properly.
                            <a href="${pageContext.request.contextPath}/signup.jsp">Return to sign-up page page</a>.
                        </p>
                    </c:otherwise>
                </c:otherwise>

            </c:choose>
            </div>
        </div>

    </div>




</body>
</html>
