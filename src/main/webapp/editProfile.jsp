<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Profile" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>

    <div class="container">

        <div class="row">
            <div class="col-6 offset-3">
                <h3>Profile for user ${user.userName}</h3>
                <p>
                    Update any of the fields below and click 'Update Account' to save changes.
                </p>


                <c:choose>
                    <c:when test="${(user.userName == pageContext.request.remoteUser) or (pageContext.request.isUserInRole('admin'))}">
                        <form class="form" action="editProfileAction" method="post">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="userId" id="userId"
                                       value="${user.id}">

                            </div>
                            <div class="form-group">
                                <label for="username">Username: </label>
                                <input class="form-control" type="text" name="username" id="username" disabled>
                            </div>

                            <div class="form-group">
                                <label for="firstName">First Name (optional): </label>
                                <input class="form-control" type="text" name="firstName" id="firstName"
                                       value="${not empty user.firstName ? user.firstName : ''}">
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name (optional): </label>
                                <input class="form-control" type="text" name="lastName" id="lastName"
                                       value="${not empty user.lastName ? user.lastName : ''}">
                            </div>
                            <div class="form-group">
                                <label for="email">Email: </label>
                                <input class="form-control" type="text" name="email" id="email" required
                                       value="${not empty user.email ? user.email : ''}">
                            </div>
                            <c:if test="${pageContext.request.isUserInRole('admin')}">
                                <div class="form-group">
                                    <label for="roleNames">User Role (admin use only): </label>
                                    <input class="form-control" type="text" name="roleNames" id="roleNames" required
                                           value='<c:forEach items="${user.userRoles}" var="role">${role.roleName};</c:forEach>'>
                                </div>
                                <div>
                                    <small>
                                        Separate roles by semicolons (;).
                                    </small>
                                </div>
                            </c:if>

                            <div class="form-group mt-3">
                                <input type="submit" class="btn btn-primary mr-2" name="submit" id="submit" value="Update Account">
                                <input type="submit" class="btn btn-error" name="submit" id="submitDelete" value="Delete Account" onclick="return confirm('This action will permanently delete the user account. Are you sure you want to proceed?')">

                            </div>
                        </form>
                    </c:when>
                    <c:otherwise>
                        Nothing to see here. Head on back to the <a href="homeAction">home page</a>.
                    </c:otherwise>
                </c:choose>



            </div>
        </div>



    </div>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
