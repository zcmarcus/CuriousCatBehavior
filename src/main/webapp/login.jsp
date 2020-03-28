<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Login" />
<%@include file="template/head.jsp"%>
<html>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-6 offset-3">
                <form class="form" action="j_security_check" method="POST">
                    <div class="form-group">
                        <label for="username">Username: </label>
                        <input class="form-control" type="text" name="j_username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input class="form-control" type="password" name="j_password" id="password">
                    </div>

                    <input class="btn btn-primary" type="submit" value="Log In">
                </form>
            </div>

        </div>


    </div>
</div>
</body>
</html>
