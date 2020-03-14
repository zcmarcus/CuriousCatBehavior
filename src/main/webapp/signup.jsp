<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Sign Up" />
<%@include file="template/head.jsp"%>

<html>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>

    <div class="container">

        <div class="row">
            <div class="col-6 offset-3">

                <form class="form" action="signupAction" method="post">
                    <div class="form-group">
                        <label for="username">Username: </label>
                        <input class="form-control" type="text" name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <div class="form-group">
                        <label for="confirm_password">Confirm Password: </label>
                        <input type="password" class="form-control" name="confirm_password" id="confirm_password">
                    </div>
                    <div class="form-group">
                        <label for="email">Email: </label>
                        <input class="form-control" type="email" name="email" id="email">
                    </div>
                    <div class="form-group">
                        <label for="first_name">First Name: </label>
                        <input class="form-control" type="text" name="first_name" id="first_name">
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name: </label>
                        <input class="form-control" type="text" name="last_name" id="last_name">
                    </div>

                    <div class="form-group">
                        <label for="last_name">Role: </label>
                        <input class="form-control" type="text" name="role_name" id="role_name">
                    </div>

                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create Account">
                    </div>
                </form>

            </div>
        </div>

    </div>
</div>
</body>
</html>
