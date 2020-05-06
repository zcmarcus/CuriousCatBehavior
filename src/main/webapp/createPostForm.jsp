<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Create Post" />
<%@include file="template/head.jsp"%>
<html>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>



    <div class="container">
        <h2 class="text-center">Create a New Post!</h2>
        <p class="mt-3">Fill out the form below to create a new post. </p>

        <div class="row mt-5">

            <div class="col-12">

                <div class="row">
                    <div class="col-10">

                        <form class="form" action="createPostAction" method="post">
                            <div class="form-group">
                                <label for="title">Title: </label>
                                <input class="form-control" type="text" name="title" id="title">
                            </div>
                            <div class="form-group">
                                <h5>Video: ${videoTitle}</h5>
                                <iframe id="videoPlayer" type="text/html" width="640" height="360"
                                        <%-- FIXME: change 'origin' in URL to deployed app on AWS--%>
                                        src="https://www.youtube.com/embed/${videoUrl}?autoplay=1&origin=http://localhost:8080/ccb"
                                        frameborder="0">

                                </iframe>
                            </div>
                            <div class="form-group">
                                <label for="fullVideoUrl">Video URL: </label>
                                <input type="text" class="form-control" name="fullVideoUrl" id="fullVideoUrl" readonly
                                <%--  TODO: check here to see if videoID null OR in other url format (e.g. AWS S3 link, ...)--%>
                                       value=<c:out value="${not empty videoUrl ? fullYoutubeUrl : 'None'}" />  >
                                <input type="hidden" class="form-control" name="videoUrl" id="videoUrl"
                                       value="${videoUrl}">
                            </div>
                            <div class="form-group">
                                    <a href="${pageContext.request.contextPath}/youtubeSearch.jsp">
                                        <button type="button" class="btn btn-primary">
                                            Choose Different Video
                                        </button>
                                    </a>
                            </div>

                            <div class="form-group">
                                <label for="descriptionBody">Description: </label>
                                <textarea class="form-control" rows="3"  name="descriptionBody" id="descriptionBody"></textarea>
                            </div>

                            <div class="form-group">
                                <label for="tags">Tags (optional): </label>
                                <input type="text" class="form-control" name="tags" id="tags" placeholder="Example: newborn; growling noises; odd movements">
                                <small>
                                    To make your post easier for other users to find, include some words or phrases
                                    that help to describe the subject of your post. Separate each tag with a semicolon (";").
                                </small>
                            </div>

                            <div class="form-group">
                                <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Create New Post">
                            </div>
                        </form>

                    </div>
                </div>







            </div>

        </div>



    </div>

    <%@include file="template/footer.jsp"%>


</div>
</body>
</html>
