<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>



    <div class="container">


        <div class="row mt-5">

            <div class="col-12">

                <div>
                    <div>
                        <iframe id="youtubePlayer" type="text/html" width="640" height="360"
                            <%--FIXME: change to AWS-hosted url&ndash;%&gt;--%>
                                src="https://www.youtube.com/embed/${post.videoUrl}?autoplay=0&origin=http://localhost:8080/ccb"
                                frameborder="0">

                        </iframe>
                    </div>
                    <div>
                        <a href="http://www.youtube.com/watch?v=${post.videoUrl}">Source video on YouTube</a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-9">
                        <div class="row col-12">
                            <h3>${post.title}</h3>
                            <p>
                                <span class="text-success">${post.createdDate}</span>
                                by ${post.user.userName}
                            </p>

                        </div>

                        <div class="row col-12">
                            <p>
                                <span class="font-weight-bold">Description:</span>
                                ${post.descriptionBody}
                            </p>
                        </div>

                        <div>
                            <div class="mt-2">
                                <h5>#(X) Comments</h5>

                            </div>

                            <div class="mt-2">

                                    <table class="table" id="commentsTable">
                                        <thead>

                                        </thead>
                                        <tbody>
                                        <c:choose>
                                            <c:when test="${not empty comments}">
                                                <c:forEach items="${comments}" var="comment">
                                                <tr>
                                                    <td rowspan="2">(User Icon)</td>
                                                    <td>${comment.user.userName} - ${comment.createdDate}</td>
                                                </tr>
                                                <tr>
                                                    <td>${comment.commentBody}</td>
                                                </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td>No one has commented yet. Be the first to comment!</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                        </tbody>
                                    </table>
                            </div>
                        </div>

                    </div>


                </div>

                <div class="col-3">
                    <h4>Related posts</h4>
                </div>

            </div>

        </div>
    </div>


    <%@include file="template/footer.jsp"%>

</div>
</body>
</html>
