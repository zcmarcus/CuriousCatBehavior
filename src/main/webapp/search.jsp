<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Search" />
<%@include file="template/head.jsp"%>

<html>
<head>
    <title>Search</title>
</head>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>

    <div class="container">
        <h2 class="text-center">Search Results for: ${searchTerm}</h2>

        <div class="row text-center text-lg-left">


            <c:choose>
                <c:when test="${!empty searchItems}">
                    <c:forEach items="${searchItems}" var="item">
                        <div class="col-lg-3 col-md-4 col-6 mt-4">
                            <div>
                                <a href="http://www.youtube.com/watch?v=${item.getId().getVideoId()}" class=" mt-1 mb-1 ">
                                    <img class="img-fluid img-thumbnail" src="${item.getSnippet().getThumbnails().getMedium().getUrl()}" alt="">
                                </a>
                            </div>
                            <div>
                                <a href="http://www.youtube.com/watch?v=${item.getId().getVideoId()}">${item.getSnippet().getTitle()}</a>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
            </c:choose>

        </div>

        <div class="row mt-5 mb-5">
            <nav aria-label="youtubeSearchResultsPagination">
                <ul class="pagination">
                    <li class="page-item
                        <c:choose>
                            <c:when test="${empty searchData.getPrevPageToken()}">
                                disabled
                            </c:when>
                        </c:choose>
                    ">

                        <c:choose>
                            <c:when test="${not empty searchData.getPrevPageToken()}">
                                <a class="page-link" href="searchVideos?searchTerm=${searchTerm}&pageToken=${searchData.getPrevPageToken()}" tabindex="-1">Previous Page</a>
                            </c:when>
                            <c:otherwise>
                                <span class="page-link">Previous Page</span>
                            </c:otherwise>
                        </c:choose>

                    </li>
                    <li class="page-item">
                        <c:choose>
                            <c:when test="${not empty searchData.getNextPageToken()}">
                                <a class="page-link" href="searchVideos?searchTerm=${searchTerm}&pageToken=${searchData.getNextPageToken()}">Next Page</a>
                            </c:when>
                        </c:choose>
                    </li>
                </ul>
            </nav>
        </div>


        <footer class="text-center">
            <span>Some footer text - Copyright 2020</span>
        </footer>

    </div>

</div>
</body>
</html>
