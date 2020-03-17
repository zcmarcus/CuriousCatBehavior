<%@include file="/template/taglib.jsp"%>
<c:set var="title" value="Maintenance - Home" />
<%@include file="/template/head.jsp"%>

<html>
<body>
<div class="container-fluid">
<h2>Maintenance Home</h2>

<h3>Users</h3>

    <form class="form" action="searchUser" method="get">
        <div class="form-inline">
            <div class="form-group">
                <label for="search-term"></label>
                <input type="text" id="search-term" name="search-term" class="form-control" placeholder="Enter search term">
            </div>
            <div class="form-group">
                <button name="submit" type="submit" value="findUser" class="btn btn-primary ml-3 my-1">Find User</button>
                <button name="submit" type="submit" value="viewAllUsers" class="btn btn-primary ml-3 my-1">View All Users</button>
            </div>
        </div>
        <div class="custom-control custom-radio custom-control-inline" aria-label="Search property user id">
            <input name="search-property" class="custom-control-input" type="radio" id="radio-user-id" checked="checked"  value="id">
            <label class="custom-control-label" for="radio-user-id">UserID</label>
        </div>

        <div class="custom-control custom-radio custom-control-inline" aria-label="Search property username">
            <input name="search-property" class="custom-control-input" type="radio" id="radio-user-name" value="userName">
            <label class="custom-control-label" for="radio-user-name">Username</label>
        </div>

        <div class="custom-control custom-radio custom-control-inline" aria-label="Search property - email">
            <input name="search-property" class="custom-control-input" type="radio" id="radio-user-email" value="email">
            <label class="custom-control-label" for="radio-user-email">Email</label>
        </div>



<%--        <div class="custom-control custom-radio custom-control-inline" aria-label="Search property - email">--%>
<%--            <input name="search-property" class="custom-control-input" type="radio" id="radio-user-role-name" value="id">--%>
<%--            <label class="custom-control-label" for="radio-user-role-name">User Role</label>--%>
<%--        </div>--%>


    </form>



</div>
</body>
</html>
