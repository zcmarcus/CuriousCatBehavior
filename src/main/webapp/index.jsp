<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Home" />
<%@include file="template/head.jsp"%>

<html>
<body>
<div class="container-fluid">
    <%@include file="template/navbar.jsp"%>



    <div class="container">
        <h2 class="text-center">CatsplainMeThis!</h2>

        <c:if test="{empty successMessage}">
            <p><c:out value = "{successMessage}"/></p>
        </c:if>


            <div>

            </div>




    </div>

</div>
</body>
</html>
