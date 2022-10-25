<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<%@include file="../parts/headTag.jsp" %>
<head>
    <title>Book form</title>
</head>
<body>


<h1>Book Form</h1>
<div class="modal-body">
    <div class="jumbotron pt-4">
        <div class="container">
            <form action="/books/save" method="post">
                <%--  <input type="hidden" id="id" name="id">--%>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="id">Id</label> <input type="text"
                                                              value="${book.id}" class="form-control"
                                                              id="id"
                                                              name="id"
                                                              readonly="readonly">
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="title">Title</label> <input type="text"
                                                                    value="${book.title }" class="form-control"
                                                                    id="title"
                                                                    name="title" placeholder="Enter book title">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="author">Author</label> <input type="text"
                                                                                value="${author.firstName}"
                                                                                class="form-control"
                                                                                id="author" name="author"
                                                                                placeholder="Enter Designation">
                        </div>
                    </div>
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
