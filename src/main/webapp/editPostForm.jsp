<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Edit Post - Form" />
<%@include file="template/head.jsp"%>
<html class="h-100">
<body class="h-100">
<div class="contentBody container-fluid d-flex flex-column">
    <%@include file="template/navbar.jsp"%>



    <div class="container">
        <h2 class="text-center">Edit Post</h2>




        <p class="mt-3">Make changes to your post below and hit 'Submit' to save changes. </p>

        <div class="row mt-5">

            <div class="col-12">

                <div class="row">
                    <div class="col-10">

                        <form class="form" action="editPostAction" method="post">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="postId" id="postId"
                                       value="${post.id}">

                            </div>
                            <div class="form-group mt-3 mb-3">
                                <h5>Video Title Placeholder</h5>
                                <h5>Video: ${not empty videoData ? videoData.getItems(0).getSnippet().getTitle() : ""}</h5>
                                <iframe id="videoPlayer" type="text/html" width="640" height="290"
                                <%-- FIXME: change 'origin' in URL to deployed app on AWS--%>
                                        src="https://www.youtube.com/embed/${post.videoUrl}?autoplay=0&origin=http://localhost:8080/ccb"
                                        frameborder="0">

                                </iframe>
                            </div>
                            <div class="form-group">
                                <label for="videoUrl">Video URL: </label>
                                <input type="text" class="form-control" name="videoUrl" id="videoUrl" readonly
                                <%--  TODO: check here to see if videoID null OR in other url format (e.g. AWS S3 link, ...)--%>
                                       value=<c:out value="${not empty post.videoUrl ? post.videoUrl : ''}" />  >

                            </div>

                            <div class="form-group mt-3">
                                <label for="title">Title: </label>
                                <input class="form-control" type="text" name="title" id="title" required value="${not empty post.title ? post.title : ''}">
                            </div>

                            <div class="form-group">
                                <label for="descriptionBody">Description: </label>
                                <textarea class="form-control" rows="3"  name="descriptionBody" required id="descriptionBody">${not empty post.descriptionBody ? post.descriptionBody : ''}</textarea>
                            </div>

                            <div class="form-group">
                                <label for="tags">Tags (optional): </label>
                                <input type="text" class="form-control" name="tags" id="tags"
                                       value="<c:if test="${not empty post.tags}">
                                               <c:forEach items="${post.tags}" var="tag">
                                                   ${tag};&nbsp
                                               </c:forEach>
                                           </c:if>">
                            </div>

                            <div class="form-group">
                                <input type="submit" class="btn btn-success" name="submit" id="submitEdit" value="Save Changes">
                                <input type="submit" class="btn btn-error" name="submit" id="submitDelete" value="Delete Post" onclick="return confirm('This will permanently delete the post. Are you sure you want to proceed?')">
                            </div>
                        </form>

                    </div>
                </div>







            </div>

        </div>




    </div>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>

