<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Logout Successful" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">

    <div class="container">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <div class="row">
            <div class="col-6 offset-3">
                <%--TODO: add 5-sec JavaScript auto-redirect for either situation--%>
                    <p>
                        Logged out successfully!! <a href="homeAction">Click here</a> if you are not redirected after 5 seconds.
                    </p>
            </div>
        </div>

    </div>



</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
