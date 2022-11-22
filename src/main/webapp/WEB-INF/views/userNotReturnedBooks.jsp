<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/books.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>


<div class="container">

    <table class="table table-striped table-bordered" id="bookListTable">
        <tr class="table-primary">
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Date of registration</th>
            <th>Role</th>
            <th>Count</th>
        </tr>
        <tbody>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.email}</td>
                <td>${user.birthday}</td>
                <td>${user.registrationDate}</td>
                <td>${user.role}</td>
                <td>${user.countOfNotReturnedInBooksInTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
