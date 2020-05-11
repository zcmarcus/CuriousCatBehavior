<%--If user authenticated but user id not yet set, redirect to LoginAction--%>

<c:if test="${(not empty pageContext.request.remoteUser) and (empty userId)}">
    <%--TODO:  get URL of page issueing request in order to set proper redirect to intended resource after successful login--%>
    <c:redirect url="loginAction" />
</c:if>


<header class="navbar navbar-expand-md navbar-light sticky-top justify-content-between" style="background-color: #ffe6e6;">
    <a class="rounded navbar-brand"><img src="${pageContext.request.contextPath}/images/logo.png" alt="drawing of cat with a question mark in a dialog bubble above its head" style="height: 80px; width: 80px; box-shadow: 1px 2px 3px lightgrey"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-nav-dropdown" aria-controls="navbar-nav-dropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar-nav-dropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="#">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle active" href="#" id="navbar-dropdown-about-menu-link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Info
                </a>
                <div class="dropdown-menu" aria-labelledby="navbar-dropdown-about-menu-link">
                    <a class="dropdown-item active" href="#">About</a>
                </div>
            </li>

            <c:if test="${pageContext.request.isUserInRole('admin')}">
                <li class="nav-item">
                    <a class="nav-link font-weight-bold active" href="admin/maintenanceHome.jsp">Administrator</a>
                </li>
            </c:if>


        </ul>

        <form class="form-inline my-2 my-md-0 ml-auto" method="GET" action="searchPosts">
            <input class="form-control mr-md-2" name="searchTerm" type="search" placeholder="Search posts" aria-label="Search" size="48">
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="submit" value="searchSubmit">
                <i class="fa fa-search"></i>
            </button>
        </form>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item px-3 mr-3">
                <a class="btn btn-outline text-dark nav-link" href="createPostChoice.jsp">+ Create New Post</a>
            </li>
            <c:if test="${(userId == null) or (pageContext.request.isUserInRole('admin')) }">
            <li class="nav-item">
                    <a href="signup.jsp" class="btn btn-dark text-light nav-link px-3 mx-1">Join</a>
                </li>
            </c:if>
            <c:if test="${userId == null}">
            <li class="nav-item">
                    <a href="loginAction" class="btn btn-primary text-light nav-link px-3 mx-2">Log In</a>
                </li>
            </c:if>

            <c:if test="${userId != null}">
                <li class="nav-item dropdown px-3 mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="navbar-dropdown-user" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbar-dropdown-user">
                        <a class="dropdown-item" href="/viewProfileAction?userId=${session.getAttribute('userId')}">Profile</a>
                        <a class="dropdown-item active" href="logoutAction" onclick="signOut();">Log Out</a>
                    </div>
                </li>

            </c:if>

        </ul>
    </div>
</header>