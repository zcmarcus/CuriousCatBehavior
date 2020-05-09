<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Login - Error" />
<%@include file="template/head.jsp"%>
<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col-6-offset-3">
                <h2>Login failed.</h2>
                <p>Please check user login credentials and try again.</p>
            </div>
        </div>


    </div>


    <%@include file="template/footer.jsp"%>


</div>
</body>
</html>
