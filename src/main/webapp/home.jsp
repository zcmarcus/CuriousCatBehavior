<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>

    <div class="container-fluid">
        <div class="my-5">
            <div class="titleHeading display-1 text-center">catsplain me <span class="boldHeadingSpan">this!</span></div>
        </div>
        <div class="row mt-5">
            <div class="col-3">
                <h4>Popular Tags</h4>
                <c:choose>
                <c:when test="${not empty allTags}">

                    <table id="tagsTable" class="display table table-striped">
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
            <div class="col-8 offset-1">
                <c:if test="${not empty allPosts}">

                    <table id="postsTable" class="display table table-striped dataTableClickable"  >
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






</div>
<%@include file="template/footer.jsp"%>

</body>
</html>

<script>
    initializeDataTables();
</script>
