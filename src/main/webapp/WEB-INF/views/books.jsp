<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<%@include file="parts/headTag.jsp" %>
<head>
    <title>Books Page</title>

<%--    <script>
$(document).ready(function (){
    $('#bookdatatable').DataTable();
});
    </script>--%>

</head>

<body>

<div class="container">
    <table class="table table-hover" id="bookdatatable">
        <thead>
        <tr class="table-primary">
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
        </tr>
        </thead>

        <c:forEach items="${listBooks}" var="book">
            <tbody>
            <tr>
                <td> ${book.id}</td>
                <td> ${book.title}</td>
                <td> ${book.authorFullName} </td>
            </tr>
            </tbody>

        </c:forEach>
    </table>

<%--<table class="table table-striped" id="bookdatatable">--%>


</body>
</html>
