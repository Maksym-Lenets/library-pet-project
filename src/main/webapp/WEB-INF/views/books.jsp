<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<%@include file="../parts/headTag.jsp" %>
<head>
    <title>Books Page</title>


</head>

<body>


<h1>Library</h1>
<div class="jumbotron pt-4">
    <div class="container">
        <b>
            Find your book:
            <input id="gfg" type="text"
                   placeholder="Search here">
        </b>
        <br>
        <br>
        <a href="/books/edit/0">
            <button class="btn btn-primary">
                <span class="fa fa-plus"></span>
                Add Book
            </button>
        </a>
        <br>
        <br>
        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
            <tbody id="booksTable">
            <c:forEach items="${listBooks}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="/bookdata/${book.id}" target="_blank">${book.title}</a></td>
                    <td>${book.authorFullName}</td>
                    <td>
                        <a href="/books/remove/${book.id}"> <span class='fa fa-remove'></span></a>
                        <a href="/books/edit/${book.id}"> <span class='fa fa-pencil'></span></a>
                        <span class='fa fa-plus'></span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("#gfg").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#booksTable tr").filter(function () {
                $(this).toggle($(this).text()
                    .toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>


</body>
</html>
