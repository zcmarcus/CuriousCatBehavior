<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Success" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">

    <div class="container">

        <div class="row mt-5">
            <div class="col-6 offset-3">
                <%--TODO: add 5-sec JavaScript auto-redirect timeOut on successful login--%>
                <c:choose>
                    <c:when test="${!empty userId}">
                        <div>
                            Glad to see you, ${pageContext.request.remoteUser}!
                            Head on over to the <a href="homeAction">main site</a> to get started!
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
                            Return to <a href="homeAction">home page</a>.
                        </div>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>

    </div>



</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
