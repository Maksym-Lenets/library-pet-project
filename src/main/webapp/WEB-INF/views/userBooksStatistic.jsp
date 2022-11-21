<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/books.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>


<div class="container">
    <c:choose>
        <c:when test="${listRequest.size() == 0}">
            <h4>You haven't start any book</h4>
        </c:when>
        <c:when test="${listRequest.size() == 1}">
            <h4>You have read 1 book</h4>
        </c:when>
        <c:otherwise>
            <h4>You have read ${listRequest.size()} books</h4>
        </c:otherwise>
    </c:choose>

    <table class="table table-striped table-bordered" id="bookListTable">
        <tr class="table-primary">
            <th>Title</th>
            <th>Status</th>
            <th>Days</th>
        </tr>
        <tbody>
        <c:forEach items="${listRequest}" var="request">
            <tr>
                <td>${request.title}</td>
                <td>${request.isRead ? "Complited" : "In progress"}</td>
                <td>${request.day}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
