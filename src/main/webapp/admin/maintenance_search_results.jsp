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
    <table id="resultsDataTable" class="display">
        <thead>
        <th>UserID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Full Name</th>
        <th>Roles</th>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>${user.lastName}, ${user.firstName}</td>
                    <td>
                    <c:forEach var="userRole" items="${user.userRoles}">
                        Role ID: ${userRole.id}, Role Name: ${userRole.roleName} <br/>
                    </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>





    </table>

</div>

</body>
</html>
