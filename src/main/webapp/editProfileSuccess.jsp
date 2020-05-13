<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Edit Profile - Success" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>



    <div class="container">

        <h3 class="text-center">User Profile Updated!</h3>
        <c:choose>
            <c:when test="${not empty userId && (empty userDeleted)}">
                <p>
                    Changes successfully saved! View updated profile <a href="editProfileAction?userId=${userId}">here</a>.
                </p>
            </c:when>
            <c:when test="${not empty userDeleted}">
                <div id="userDeletedMessage">
                    User ${userDeleted.name} successfully deleted. Head on back to the <a href="homeAction">home page</a>.
                </div>

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
