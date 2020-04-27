<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>



    <div class="container">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <c:choose>
            <c:when test="${empty newUserId}"></c:when>
            <c:otherwise>
                <p>
                    Account with ID
                    <span class='text-success'>
                        <c:out value = "${newUserId}" />
                    </span> successfully created! Visit
                    <a href='loginAction'>Login page</a> to log in.
                </p>
            </c:otherwise>

        </c:choose>


            <div>

            </div>

    </div>





    <%@include file="template/footer.jsp"%>

</div>
</body>
</html>
