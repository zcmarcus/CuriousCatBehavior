<header class="navbar navbar-expand-md navbar-light sticky-top justify-content-between" style="background-color: #ffe6e6;">
    <a class="navbar-brand"><img src="${pageContext.request.contextPath}/images/logo.png" alt="drawing of cat with a question mark in a dialog bubble above its head" style="height: 80px; width: 80px; box-shadow: 1px 2px 3px lightgrey"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-nav-dropdown" aria-controls="navbar-nav-dropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar-nav-dropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Browse</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbar-dropdown-menu-link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Info
                </a>
                <div class="dropdown-menu" aria-labelledby="navbar-dropdown-menu-link">
                    <a class="dropdown-item" href="#">About</a>
                    <a class="dropdown-item" href="#">Item</a>
                    <a class="dropdown-item" href="#">Another Item</a>
                </div>
            </li>

            <c:if test="${userRoleNames.contains('admin')}">
                <li class="nav-item">
                    <a class="nav-link font-weight-bold" href="admin/maintenance_home.jsp">Administrator</a>
                </li>
            </c:if>


        </ul>

        <form class="form-inline my-2 my-md-0 ml-auto" method="GET" action="searchVideos">
            <input class="form-control mr-md-2" name="searchTerm" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="submit" value="searchSubmit">
                <i class="fa fa-search"></i>
            </button>
        </form>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">+ Add Video</a>
            </li>
            <c:if test="${pageContext.request.getRemoteUser() == null}">
                <li class="nav-item">
                    <a href="signup.jsp" class=" btn btn-outline-dark px-3 mx-3">Join</a>
                </li>
                <li class="nav-item">
                    <a href="loginAction" class=" btn btn-outline-primary px-3 mx-3">Log In</a>
                </li>
            </c:if>

            <c:if test="${pageContext.request.getRemoteUser() != null}">
                <li class="my-auto">
                    <a href="logoutAction" onclick="signOut();" class="px-3 mx-3">Sign out</a>
                </li>
            </c:if>

        </ul>
    </div>
</header>