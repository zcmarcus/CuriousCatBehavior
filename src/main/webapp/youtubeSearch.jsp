<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Search" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>

    <div class="container">

        <h2>Find video on YouTube</h2>
        <div>
            <p>
                Enter your query in the box below. If you have a specific video you would like to select to use in
                your post, you may enter the video's ID<sup><i class="fa fa-asterisk"></i></sup> in the search box instead.
            </p>
        </div>
        <div class="mt-2">
            <div>
                <img src="images/example_youtube_video_id.png" alt="example of a youtube video url with the id portion highlight">
            </div>
            <div>
                <sup><i class="fa fa-asterisk"></i></sup>
                <small>
                    See the text highlighted in red in the image above for an example of a YouTube video ID.
                </small>
            </div>
        </div>
        <form class="form-inline mt-5 mb-3" method="GET" action="youtubeSearchAction">
            <input class="form-control mr-md-2" name="searchTerm" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-dark my-2 my-sm-0" type="submit" name="submit" value="searchSubmit">
                <i class="fa fa-search"></i>
            </button>
        </form>

        <div class="mt-2">
            <p>
                Click a video in the results below to use it in creating a new post.
            </p>
        </div>


        <h3>Search Results for: ${searchTerm}</h3>

        <div class="row text-center text-lg-left">

            <c:choose>
                <c:when test="${!empty searchItems}">
                    <c:forEach items="${searchItems}" var="item">
                        <div class="col-lg-3 col-md-4 col-6 mt-4">
                            <div>
                                <a href="createPostAction?videoUrl=${item.getId().getVideoId()}" class=" mt-1 mb-1 ">
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



    </div>

    <%@include file="template/footer.jsp"%>


</div>
</body>
</html>
