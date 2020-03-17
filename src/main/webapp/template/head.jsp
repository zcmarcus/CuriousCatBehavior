<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--  This app's client ID created in Google Developer Console (for use with Google Signin)--%>
    <%--  TODO: can alternatively specify client ID in gapi.auth2.init() --%>
    <meta name="google-signin-client_id" content="957495172888-dktv6coic4ctb7m9gchun82luk9q317d.apps.googleusercontent.com">


    <title>${title}</title>
    <%--  css Bootstrap 4--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--  custom CSS--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <%--  JQuery 3.0.0 full, not slim build--%>
    <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>

    <%--  Popper.js--%>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <%--  Bootstrap.js--%>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <%--  Google Platform Library--%>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <%--  Functions for Google Signin functionality--%>
    <script src="${pageContext.request.contextPath}/js/google_signin.js"></script>

    <%--  Font Awesome--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <%--  DataTables--%>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
</head>

