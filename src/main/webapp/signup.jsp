<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Sign Up" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>

    <div class="container">

        <div class="row">
            <div class="col-6 offset-3">
                <h3>New User Sign-up</h3>
                <p>
                    Fill out the form below to create a new user account. <em>All fields are required unless noted
                    otherwise.</em>
                </p>

                <c:if test="${not empty errorMsg}">
                    <div id="errorMessage">
                        <span id="errorMessageText" class="text-danger">${errorMsg}</span>
                    </div>
                </c:if>


                <form class="form" action="signupAction" method="post"
                      <%-- FIXME: Change to event listener in signup.js --%>
                      oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>

                    <div class="form-group">
                        <label for="username">Username: </label>
                        <input class="form-control" type="text" name="username" id="username" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password: </label>
                        <input type="password" class="form-control" name="password" id="password" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password: </label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" required>
                    </div>
                    <div class="text-danger mt-1 mb-1" id="passwordMatchStatus"></div>
                    <div class="form-group">
                        <label for="email">Email: </label>
                        <input class="form-control" type="email" name="email" id="email" required
                               value="${not empty email ? email : ''}">
                    </div>
                    <div class="form-group">
                        <label for="firstName">First Name (optional): </label>
                        <input class="form-control" type="text" name="firstName" id="firstName"
                               value="${not empty firstName ? firstName : ''}">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name (optional): </label>
                        <input class="form-control" type="text" name="lastName" id="lastName"
                               value="${not empty lastName ? lastName : ''}">
                    </div>
                    <c:if test="${userRoleNames.contains('admin')}">
                    <div class="form-group">
                        <label for="roleName">User Role (admin use only): </label>
                        <input class="form-control" type="text" name="roleName" id="roleName"
                               value="${not empty roleName ? roleName : ''}">
                    </div>
                    </c:if>

                    <div class="form-group">
                            <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create Account">
                        </div>
                </form>

            </div>
        </div>



    </div>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
