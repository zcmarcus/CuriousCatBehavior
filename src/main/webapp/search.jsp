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
                            <a href="http://www.youtube.com/watch?v=${item.getId().getVideoId()}" class="d-block mt-1 mb-1 h-100">
                                <img class="img-fluid img-thumbnail" src="${item.getSnippet().getThumbnails().getMedium().getUrl()}" alt="">
                            </a>
<%--                            <a href="http://www.youtube.com/watch?v=${item.getId().getVideoId()}">/watch?v=${item.getId().getVideoId()}</a>--%>
                            <a href="http://www.youtube.com/watch?v=${item.getSnippet().getTitle()}">/watch?v=${item.getSnipet().getTitle()}</a>

                        </div>
                    </c:forEach>
                </c:when>
            </c:choose>

<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/pWkk7iiCoDM/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/aob0ukAYfuI/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/EUfxH-pze7s/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/M185_qYH8vg/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/sesveuG_rNo/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/AvhMzHwiE_0/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/2gYsZUmockw/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/EMSDtjVHdQ8/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/8mUEy0ABdNE/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/G9Rfc1qccH4/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/aJeH0KcFkuc/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="col-lg-3 col-md-4 col-6">--%>
<%--                    <a href="#" class="d-block mb-4 h-100">--%>
<%--                        <img class="img-fluid img-thumbnail" src="https://source.unsplash.com/p2TQ-3Bh3Oo/400x300" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>

        </div>

    </div>




    </div>
</div>
</body>
</html>
