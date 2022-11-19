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
            <th>ID</th>
            <th>Title</th>
            <th>Status</th>
            <th>DateOfRequest</th>
            <th>GetBookDate</th>
            <th>ShouldBeReturn</th>
            <th>ReturnDate</th>
        </tr>
        <tbody>
        <c:forEach items="${listRequest}" var="request">
            <tr>
                <td>${request.id}</td>
                <td>${request.bookInstance.book.title}</td>
                <td>${request.bookInstance.status.name()}</td>
                <td>${request.requestDate}</td>
                <td>${request.getBookDate}</td>
                <td>${request.shouldBeReturn}</td>
                <td>${request.returnBookDate}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
