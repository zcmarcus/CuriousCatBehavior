<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Create Post - Choose" />
<%@include file="template/head.jsp"%>

<html class="h-100">
<body class="h-100">
<div class="contentBody container-fluid d-flex flex-column h-100">
    <%@include file="template/navbar.jsp"%>



    <div class="container">



        <h2 class="text-center">Create a New Post!</h2>

        <c:choose>
            <c:when test="${empty userId}">
                Users must be logged in to create new posts. Please <a href="loginAction">login here</a> first.
            </c:when>
        <c:otherwise>


        <p></p>

        <div class="row mt-5">

            <div class="col-12">

                <div class="row">
                    <div class="col-5">
                        <h3>Post with YouTube video</h3>
                        <div>
                            Select this option to create a new post using an existing video on YouTube.
                        </div>
                        <div>
                            <a href="youtubeSearch.jsp" class="btn btn-primary">Select</a>
                        </div>

                    </div>

                    <div class="col-1"></div>

                    <div class="col-1 dashedVerticalDivider">
                        <p>
                            x
                        </p>
                        <p>
                            x
                        </p>
                        <p>
                            x
                        </p>
                    </div>

                    <div class="col-5">
                        <h3>Upload a video</h3>
                        <div class="mt-5">
                            Select this option to create a new post by uploading a video directly
                            to CatsplainMeThis.
                        </div>
                        <div class="mt-2">
                            <a href="createPostUpload.jsp" class="btn btn-primary">Select</a>
                        </div>
                        <div class="mt-2">
                            <p>
                                <small class="text-error font-weight-bold">
                                    Note: This feature coming soon!
                                </small>
                            </p>
                        </div>
                    </div>
                </div>






            </div>


            </c:otherwise>
        </c:choose>


        </div>


    </div>

    <%@include file="template/footer.jsp"%>


</div>
</body>
</html>
