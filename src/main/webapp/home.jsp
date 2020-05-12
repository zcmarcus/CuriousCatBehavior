<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>

    <div class="container">
        <div class="jumbotron my-2">
            <div class="titleHeading display-1 text-center">catsplain me <span class="boldHeadingSpan">this!</span></div>
        </div>
        <div class="row mt-5">
            <div class="col-2">
                <h3 class="mb-5 text-center">Popular Tags</h3>
                <c:choose>
                <c:when test="${not empty allTags}">

<%--                    <table id="tagsTable" class="table table-borderless">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th class="p-3"></th>--%>
<%--                        </tr>--%>

<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <c:forEach var="tag" items="${allTags}">--%>
<%--                            <tr>--%>
<%--                                <td class="p-3">--%>
<%--                                    <span class="text-info px-2 mx-2 font-weight-bold border rounded">--%>
<%--                                        <a href="searchTags?tagName=${tag.tagName}">${tag.tagName}</a>--%>
<%--                                    </span>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
<%--                        </tbody>--%>

<%--                    </table>--%>

                    <p clas="bg-light">
                        <c:forEach var="tag" items="${allTags}">
                                    <span class="text-info px-1 mx-2 font-weight-bold border rounded">
                                        <a href="searchTags?tagName=${tag.tagName}">${tag.tagName}</a>
                                    </span>
                        </c:forEach>
                    </p>

                </c:when>
                <c:otherwise>
                    <h5>No tags found in database</h5>
                </c:otherwise>
            </c:choose>
            </div>
            <div class="col-9 offset-1">
                <c:choose>
                    <c:when test="${empty newestPosts}">
                        <h3 class="mb-3 text-center">No posts in database.</h3>
                    </c:when>
                    <c:otherwise>
                    <h3 class="mb-3 text-center">Newest Posts</h3>
                    <table id="postsTable" class="display compact table table-striped dataTableClickable"  >
                        <thead>
                        <tr>
                            <th></th>
                            <th class="p-3">Title</th>
                            <th class="p-3">Posted</th>
                            <th class="p-3"></th>
                            <th class="p-3"></th>
                            <th class="p-3"></th>
                        </tr>

                        </thead>
                        <tbody>
                        <c:forEach var="post" items="${newestPosts}" varStatus="postCount">
                            <tr>
                                <td class="p-3"><img class="tableThumbnail" src="https://i.ytimg.com/vi/${post.videoUrl}/default.jpg" alt="youtube video thumbnail"/></td>
                                <td class="font-weight-bold p-3 postTitleText">${post.title}</td>
                                <td class="p-3">${post.getTimeElapsedSinceCreated() > 1 ? post.getTimeElapsedSinceCreated().concat(' days ago') : 'less than a day ago'}</td>
                                <td class="p-3">
                                    ${post.createdDate}
                                </td>
                                <td class="p-3">
                                    by <span class="font-weight-bold text-underline">${post.user.userName}</span>
                                </td>

                                <td class="p-3">
                                    <a href="viewPostAction?postId=${post.id}">View Post</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </c:otherwise>
                </c:choose>
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
