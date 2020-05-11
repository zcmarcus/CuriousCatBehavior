<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Create Post - Success" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>



    <div class="container">

        <h3 class="text-center">Success!</h3>
        <c:choose>
            <c:when test="${not empty newPostId}">
                <p>
                    Post with ID
                    <span class='text-success'>
                        <c:out value = "${newPostId}" />
                    </span> successfully created!
                    <span class="font-weight-bold">
                        <a href="viewPostAction?postId=${newPostId}">Click here</a>
                    </span>
                    to view the post.
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
