<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>

    <script type="text/javascript" class="init">
        $(document).ready( function () {
            $('#allPostsTable').DataTable();
            $('#allTagsTable').DataTable();
        } );
    </script>


    <div class="container-fluid">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <div class="row">
            <div class="col-3">
                <c:if test="${allTags != null}">

                    <table id="allTagsTable" class="display">
                        <thead>
                        <tr>
                            <th></th>
                        </tr>

                        </thead>
                        <tbody>
                        <c:forEach var="tag" items="${allTags}">
                            <tr>
                                <td>${tag.tagName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </c:if>
            </div>
            <div class="col-9">
                <c:if test="${allPosts != null}">

                    <table id="allPostsTable" class="display">
                        <thead>
                        <tr>
                            <th>Title</th>
                            <th>Video URL</th>
                            <th>Posted on</th>
                            <th>User</th>
                            <th></th>
                        </tr>

                        </thead>
                        <tbody>
                        <c:forEach var="post" items="${allPosts}">
                            <tr>
                                <td>${post.title}</td>
                                <td>${post.videoUrl}</td>
                                <td>${post.createdDate}</td>
                                <td>
                                    by ${post.user.userName}
                                </td>
                                <td>
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
