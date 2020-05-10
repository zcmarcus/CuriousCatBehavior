<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>

    <div class="container-fluid">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <div class="row mx-4">
            <div class="col-3">
                <c:choose>
                <c:when test="${not empty allTags}">

                    <table id="allTagsTable" class="display table table-striped">
                        <thead>
                        <tr>
                            <th class="p-3"></th>
                        </tr>

                        </thead>
                        <tbody>
                        <c:forEach var="tag" items="${allTags}">
                            <tr>
                                <td class="p-3">${tag.tagName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </c:when>
                <c:otherwise>
                    <h5>No tags found in database</h5>
                </c:otherwise>
                </c:choose>
            </div>
            <div class="col-9">
                <c:if test="${not empty allPosts}">

                    <table id="allPostsTable" class="display table table-striped dataTableClickable"  >
                        <thead>
                        <tr>
                            <th class="p-3">Title</th>
                            <th class="p-3">Posted on</th>
                            <th class="p-3">User</th>
                            <th class="p-3"></th>
                        </tr>

                        </thead>
                        <tbody>
                        <c:forEach var="post" items="${allPosts}">
                            <tr>
                                <td class="font-weight-bold p-3 postTitleText">${post.title}</td>
                                <td class="p-3">${post.createdDate}</td>
                                <td class="p-3">
                                    by <span class="font-weight-bold text-underline">${post.user.userName}</span>
                                </td>
                                <td class="p-3">
                                    <a href="viewPostAction?postId=${post.id}">
                                        View Post
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </c:if>
            </div>

        </div>

    </div>





    <%@include file="template/footer.jsp"%>

</div>
</body>
</html>

<script>
    initializeDataTables();
</script>
