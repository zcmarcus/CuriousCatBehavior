<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Delete User - Success" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>



    <div class="container">

        <h3 class="text-center">Post Deleted!</h3>
        <c:choose>
            <c:when test="${not empty userDeleted}">
                <p>
                    User account successfully deleted. <a href="homeAction">Return to home page</a>.
                </p>
            </c:when>
            <c:otherwise>
                <p>
                    <span class="text-warning">Oops! Something went wrong. Please
                        go back and check that all form fields were filled out correctly.
                    </span>
                </p>
            </c:otherwise>
        </c:choose>



    </div>


</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
