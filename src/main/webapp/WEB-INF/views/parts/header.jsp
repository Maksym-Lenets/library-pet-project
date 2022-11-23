<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@include file="headTag.jsp" %>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">LIBRARY</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/books">Books<%--<span class="sr-only">(current)</span>--%></a>
            </li>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="/users/books/statistic">My books</a>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link" href="/books/top">Top 10</a>
            </li>
            <sec:authorize access="hasRole('MANAGER')">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Statistics
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/books/statistic">Books</a>
                        <a class="dropdown-item" href="#">Users</a>
                        <a class="dropdown-item" href="/readers/statistic">Readers</a>
                        <a class="dropdown-item" href="/users/not_returned_book/statistic">Overdue readers</a>
                    </div>
                </li>
            </sec:authorize>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link disabled" href="#">Disabled</a>--%>
            <%--            </li>--%>
        </ul>
        <div class="text-end">
            <sec:authorize access="!isAuthenticated()">
                <span id="login">
                    <a href="login">
                        <button type="button" class="btn btn-warning ">Login</button>
                    </a>

                    <a href="register">
                        <button type="button" class="btn btn-warning">Sign-up</button>
                    </a>
                </span>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="logout" id="logout">
                    <button type="button" onclick="localStorage.clear()" class="btn btn-warning">Logout</button>
                </a>
            </sec:authorize>
        </div>

    </div>
</nav>

<%--<script>--%>
<%--    const isLogin = <%= firstName != null%>;--%>
<%--    const id = isLogin ? 'logout' : 'login'--%>
<%--    document.getElementById(id).removeAttribute('hidden');--%>
<%--</script>--%>
</body>
</html>
