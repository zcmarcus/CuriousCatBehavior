<%@include file="template/taglib.jsp"%>
<c:set var="title" value="Login" />
<%@include file="template/head.jsp"%>
<html>
<body>
<form action="j_security_check" method="POST">
    <table>
        <tr><td>User name: <input type="text" name="j_username"></td></tr>
        <tr><td>Password: <input type="password" name="j_password"></td></tr>
        <tr><th><input type="submit" value="Log In"></th></tr>
    </table>
</form>

</body>
</html>
