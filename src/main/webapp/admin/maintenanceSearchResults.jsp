<%@include file="../template/taglib.jsp"%>
<c:set var="title" value="Maintenance - Search Results" />
<%@include file="../template/head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#resultsDataTable').DataTable();
    } );
</script>
<html>


<body>
<div class="container-fluid">
    <h2>Search Results:</h2>
    <c:if test="${users != null}">

    <table id="resultsDataTable" class="display">
        <thead>
            <tr>
                <th>UserID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Full Name</th>
                <th>Roles</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>${user.lastName}, ${user.firstName}</td>
                    <td>Roles:
                    <c:forEach var="userRole" items="${user.userRoles}">
                        ${userRole.roleName} <br>
                    </c:forEach>
                    </td>
                    <td>
                        <a href="/viewProfileAction?userId=${user.id}">View Profile</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    </c:if>

    <c:if test="${posts != null}">

        <table id="resultsDataTable" class="display">
            <thead>
                <tr>
                    <th>PostID</th>
                    <th>Title</th>
                    <th>Description Body</th>
                    <th>Video URL</th>
                    <th>Created</th>
                    <th>Modified</th>
                    <th>User</th>
                    <th></th>
                </tr>

            </thead>
            <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.descriptionBody}</td>
                    <td>${post.videoUrl}</td>
                    <td>${post.createdDate}</td>
                    <td>${post.modifiedDate}</td>
                    <td>
                        <a href="maintenanceSearch?submitAction=getUserById&userSearchTerm=${post.user.id}">
                                ${post.user.id}: ${post.user.userName}
                        </a>
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

</body>
</html>
