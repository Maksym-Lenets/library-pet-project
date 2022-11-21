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
            <th>Title</th>
            <th>Status</th>
            <th>Day</th>
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
