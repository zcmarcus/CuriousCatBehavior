<%@include file="../template/taglib.jsp"%>
<c:set var="title" value="Maintenance - Home" />
<%@include file="../template/head.jsp"%>

<html>
<body>
<%@include file="../template/navbar.jsp"%>

<div class="container-fluid">
    <h2 class="mb-2">Maintenance Home</h2>


    <form class="form" action="maintenanceSearch" method="get">
        <h3 class="mb-2">Users</h3>

        <div class="form-inline mb-5">
            <div class="form-group">
                <label for="userSearchTerm"></label>
                <input type="text" id="userSearchTerm" name="userSearchTerm" class="form-control" placeholder="Enter part or all of a user detail">
            </div>
            <div class="form-group">
                <button name="submit" type="submit" value="findUsersByAny" class="btn btn-primary ml-3 my-1">Find User</button>
                <button name="submit" type="submit" value="viewAllUsers" class="btn btn-primary ml-3 my-1">View All Users</button>
            </div>
        </div>

        <h3 class="mb-2">Posts</h3>

        <div class="form-inline mb-5">
            <div class="form-group">
                <label for="postSearchTerm"></label>
                <input type="text" id="postSearchTerm" name="postSearchTerm" class="form-control" placeholder="Enter part or all of a post detail">
            </div>
            <div class="form-group">
                <button name="submit" type="submit" value="findPostsByAny" class="btn btn-primary ml-3 my-1">Find Post</button>
                <button name="submit" type="submit" value="viewAllPosts" class="btn btn-primary ml-3 my-1">View All Posts</button>
            </div>
        </div>
    </form>



</div>
</body>
</html>
