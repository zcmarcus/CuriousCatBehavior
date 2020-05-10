<%@include file="../template/taglib.jsp"%>
<c:set var="title" value="Error 404: Page Not Found" />
<%@include file="../template/head.jsp"%>

<html class="h-100">
<body class="h-100">

    <div class="container-fluid d-flex flex-column h-100">
        <div class="container">
            <div class="row">
                <div class="col-6 offset-3">
                    <h1 class="text-center bg-error">Sorry, the page you requested was not found. :( Double-check that url!</h1>
                    <img src="${pageContext.request.contextPath}/images/sadcat.jpg" alt="a sad-looking cat resting its head on a piece of fabric">
                </div>
            </div>
        </div>

        <%@include file="../template/footer.jsp"%>



    </div>


</body>
</html>
