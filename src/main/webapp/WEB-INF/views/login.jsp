<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 30.10.2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>

<div class="login-form">
    <c:if test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>
    <c:if test = "${not empty successMsg}">
        <div class="alert alert-danger" role="alert">${successMsg}</div>
    </c:if>
    <div class="container-fluid">
        <form method="post">
            <div class="mt-3">
                <input type="text" name="email" placeholder="Email" class="form-control">
            </div>
            <div class="mt-3">
                <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button class=" btn btn-dark btn-block mt-3">Submit</button>
            <div class="mt-3">
                <a href="register" class=" btn btn-success btn-block mt-3"> To Registration</a>
            </div>
        </form>
    </div>
</div>


</body>
</html>
