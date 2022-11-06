<html>
<%@include file="parts/headTag.jsp" %>
<%--<script type="text/javascript" src="resources/js/bookTable.js" defer></script>--%>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>
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
                <th>Actions</th>
            </tr>
            <tbody>
            <c:forEach items="${listBooks}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="/edit/${book.id}" target="_blank">${book.title}</a></td>
                    <td>${book.author.fullName}</td>

                    <td>
                        <c:forEach items="${book.coAuthors}" var="coAuthor" varStatus="loop">
                            ${coAuthor.fullName}
                            <c:if test="${not loop.last}">,</c:if>
                        </c:forEach>
                    </td>
                    <td>${book.copiesAmount}</td>

                    <td>
                        <spring:url value="/books/edit/${book.id}" var="updateUrl" />
                        <spring:url value="/books/remove/${book.id}" var="deleteUrl" />

                        <span class='fa fa-pencil' onclick="location.href='${updateUrl}'"></span>
                        <span class='fa fa-remove' onclick="location.href='${deleteUrl}'"></span>

                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</form>



</body>
</html>
