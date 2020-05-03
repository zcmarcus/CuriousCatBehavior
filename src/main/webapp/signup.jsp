<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Sign Up" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>

    <div class="container">

        <div class="row">
            <div class="col-6 offset-3">
                <h3>New User Sign-up</h3>
                <p>
                    Fill out the form below to create a new user account. <em>All fields are required unless noted
                    otherwise.</em>
                </p>

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
                        <label for="first_name">First Name (optional): </label>
                        <input class="form-control" type="text" name="first_name" id="first_name">
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name (optional): </label>
                        <input class="form-control" type="text" name="last_name" id="last_name">
                    </div>
                    <c:if test="${session.userRoleNames.contains('admin')}">
                        <label for="role_name">User Role (admin use only): </label>
                        <input class="form-control" type="text" name="role_name" id="role_name">
                    </c:if>

                    <div class="form-group">
                            <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create Account">
                        </div>
                </form>

            </div>
        </div>



    </div>

    <%@include file="template/footer.jsp"%>

</div>
</body>
</html>
