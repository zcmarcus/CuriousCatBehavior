<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Logout Successful" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">

    <div class="container">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <div class="row">
            <div class="col-6 offset-3">
                <%--TODO: add 5-sec JavaScript auto-redirect for either situation--%>
                    <p>
                        Logged out successfully!! <a href="${pageContext.request.contextPath}/index.jsp">Click here</a> if you are not redirected after 5 seconds.
                    </p>
            </div>
        </div>

    </div>




</body>
</html>
