<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Search" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody d-flex flex-column">
    <%@include file="template/navbar.jsp"%>

    <div class="container-fluid mt-5">
        <div mt-5>
            <h2 class="">Find video on YouTube</h2>
            <div mt-5>
                <p>
                    Enter your query in the box below. You may enter a search term, a YouTube video ID (the part after '?v= )</sup>
                    or even a full video url, as pictured below.
                </p>
            </div>
            <div class="my-2 py-2">
<%--                FIXME: remove if not needed--%>
<%--                <div>--%>
<%--                    <img class="border" src="images/exampleVideoId.png" alt="example of a youtube video url with the id portion highlight">--%>
<%--                </div>--%>
            </div>




            <div class="row mb-5">
                <div class="col-6 align-self-center">
                    <form class="form-inline mt-2 mb-5" method="GET" action="youtubeSearchAction">
                        <input class="form-control mr-md-2" name="searchTerm" type="search" placeholder="Enter search term(s) or video URL..." size="40" aria-label="Search">
                        <button class="btn my-2 my-sm-0 youtubeSearchButton" type="submit" name="submit" value="searchSubmit">
                            <i class="fa fa-caret-right fa-3 youtubeSearchArrow"></i>
                        </button>
                    </form>
                </div>
                <div class="col-6">
                    <div class="">
                        <strong>powered by</strong> <img class="youtubeLogo" src="images/youtubeLogo.jpg" alt="youtube logo">
                    </div>
                </div>
            </div>






            <c:if test="${!empty searchData}">
            <div class="mt-5">
                <p>
                    Click a video in the results that appear below to select for use in your post.
                </p>
            </div>


            <h3>Results for: "${searchTerm}"</h3>

            <div class="row text-center text-lg-left">


                    <c:forEach items="${searchData.getItems()}" var="item">
                        <div class="col-lg-3 col-md-4 col-6 mt-4">
                            <div>
                                <a href="createPostAction?videoUrl=${item.getId().getVideoId()}&videoTitle=${item.getSnippet().getURLEncodedTitle()}" class=" mt-1 mb-1 ">
                                    <img class="img-fluid img-thumbnail" src="${item.getSnippet().getThumbnails().getMedium().getUrl()}" alt="">
                                </a>
                            </div>
                            <div>
                                <a href="http://www.youtube.com/watch?v=${item.getId().getVideoId()}">${item.getSnippet().getTitle()}</a>
                            </div>
                        </div>
                    </c:forEach>


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
                                    <a class="page-link" href="youtubeSearchAction?searchTerm=${searchTerm}&pageToken=${searchData.getPrevPageToken()}" tabindex="-1">Previous Page</a>
                                </c:when>
                                <c:otherwise>
                                    <span class="page-link">Previous Page</span>
                                </c:otherwise>
                            </c:choose>

                        </li>
                        <li class="page-item">
                            <c:choose>
                                <c:when test="${not empty searchData.getNextPageToken()}">
                                    <a class="page-link" href="youtubeSearchAction?searchTerm=${searchTerm}&pageToken=${searchData.getNextPageToken()}">Next Page</a>
                                </c:when>
                            </c:choose>
                        </li>
                    </ul>
                </nav>
            </div>

            </c:if>
        </div>

    </div>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>
