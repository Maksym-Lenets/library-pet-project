
<html>
<%@include file="parts/headTag.jsp" %>
<%--<script type="text/javascript" src="resources/js/bookTable.js" defer></script>--%>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="./parts/header.jsp"></jsp:include>
<h2 id="welcome">Welcome ${user.firstName} to our library</h2>
<form>
    <div class="container">
        <table class="table table-striped table-bordered" id="bookListTable">
            <tr class="table-primary">
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Co-authors</th>
                <th>Copies</th>
                <th></th>
                <th></th>
            </tr>
            <tbody>
            <c:forEach items="${listBooks}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="/edit/${book.id}" target="_blank">${book.title}</a></td>
                    <td>${book.author.fullName}</td>
                    <td><c:forEach items="${book.coAuthors}"
                                   var="coAuthor"> ${coAuthor.fullName}; </c:forEach></td>
                    <td>${book.copiesAmount}</td>
                    <td><a href="<c:url value='/books/edit/${book.id}'/>"><span class='fa fa-pencil'></span></a></td>
                    <td><a href="<c:url value='/books/remove/${book.id}'/>"><span class='fa fa-remove'></span></a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</form>


</body>
</html>
