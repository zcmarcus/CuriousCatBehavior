<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>



    <div class="container">

        <h3 class="text-center">Success!</h3>

        <c:when test="${!empty newPostId}">
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



    </div>






    <%@include file="template/footer.jsp"%>

</div>
</body>
</html>