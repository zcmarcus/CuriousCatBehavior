<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>



    <div class="container">


        <div class="row mt-5">

            <div class="col-12">

                <div>
                    <div class="videoWrapper">
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

                        <div class="mt-2">
                            <p>Tags:
                                <c:if test="${not empty post.tags}">
                                    <c:forEach items="${post.tags}" var="tag">
                                        <span class="text-info px-2 mx-2 font-weight-bold border rounded">
                                            ${tag.tagName}
                                        </span>
                                    </c:forEach>
                                </c:if>

                            </p>
                        </div>

                        <div class="mt-2">
                            <a class="btn btn-success" href="editPostAction?editId=${post.id}">Edit Post</a>
                        </div>

                        <div>
                            <div class="mt-2">
                                <h5>
                                    ${not empty post.comments
                                            ? (post.comments.size() == 1 ? "1 Comment" : String.valueOf(post.comments.size()).concat(" Comments"))
                                            : '0 Comments'}
                                </h5>

                            </div>

                            <div class="container-fluid mt-2">
                                <form class="form" action="addCommentAction" method="post">
                                    <input type="hidden" name="postId" value="${post.id}">
                                    <table class="table table-borderless" id="commentsTable">
                                        <thead></thead>
                                        <tbody>
                                        <c:choose>
                                            <c:when test="${not empty post.comments}">
                                                <c:forEach items="${post.comments}" var="comment">
                                                <tr>
                                                    <td rowspan="2">
                                                        <%-- Dicebear randomized Avatars API Call using comment author username as seed--%>
                                                        <object class="userIcon" data="https://avatars.dicebear.com/v2/jdenticon/${comment.user.userName}.svg?options[radius]=12&options[width]=48&options[height]=48"></object>
                                                    </td>
                                                    <td class="font-weight-bold">${comment.user.userName} - ${comment.getTimeElapsedSinceCreated() > 1 ? comment.getTimeElapsedSinceCreated().concat(' days ago') : 'less than a day ago'}</td>
                                                </tr>
                                                <tr>
                                                    <td>${comment.contentBody}</td>
                                                </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td>No one has commented yet. Be the first to comment!</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                        <tr>
                                            <td rowspan="2">
                                                <%-- Dicebear randomized Avatars API Call using logged-in user username as seed--%>
                                                <c:choose>
                                                    <c:when test="${not empty pageContext.request.remoteUser}">
                                                        <object class="userIcon" data="https://avatars.dicebear.com/v2/jdenticon/${pageContext.request.remoteUser}.svg?options[radius]=12&options[width]=48&options[height]=48"></object>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img id="guestIcon" class="userIcon" src="${pageContext.request.contextPath}/images/guestIcon.jpg"></img>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <textarea rows="4" cols="80" name="contentBody" id="contentBody"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <button type="submit" name="submit" id="submitCommentButton">Post Comment</button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </form>
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
