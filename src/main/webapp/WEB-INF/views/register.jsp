<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 30.10.2022
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register.css">
</head>
<body>

<div class="register-form">
    <c:if test = "${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>
    <div class="container-fluid">
        <form:form method="post" modelAttribute="user">
            <div class="mt-3">
                <form:input type="text" path="firstName" placeholder="First Name" class="form-control" />
            </div>
            <div class="mt-3">
                <form:input type="text" path="lastName" placeholder="Last Name" class="form-control" />
            </div>
            <div class="mt-3">
                <form:input type="date" path="birthday" placeholder="Birthday (YYYY-MM-DD)" class="form-control" />
            </div>
            <div class="mt-3">
                <form:input type="text" path="email" placeholder="Email" class="form-control" />
            </div>
            <div class="mt-3">
                <form:input type="password" path="password" placeholder="Password" class="form-control" />
            </div>
            <button type="submit" class=" btn btn-dark btn-block mt-3">Register</button>
        </form:form>
    </div>
</div>


</body>
</html>