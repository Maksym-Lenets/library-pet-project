<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/books.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>

<form>
    <div class="container">
        <h2 id="welcome">Welcome ${user.firstName} to library</h2>

        <%--        <div class="row">
                    <div class="col-7">
                        <div class="card">
                            <div class="card-header"><h5>Books search</h5></div>
                            <div class="card-body py-0">
                                <form id="filter">
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label class="col-form-label" for="startDate">DATA</label>
                                                <input class="form-control col-5" name="startDate" id="startDate">

                                                <label class="col-form-label" for="endDate">DATA2</label>
                                                <input class="form-control col-5" name="endDate" id="endDate">
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label class="col-form-label" for="startTime">DATA 3</label>
                                                <input class="form-control col-3" name="startTime" id="startTime">

                                                <label class="col-form-label" for="endTime">DATA 4</label>
                                                <input class="form-control col-3" name="endTime" id="endTime">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-right">
                                <button class="btn btn-danger" onclick="clearFilter()">
                                    <span class="fa fa-remove"></span>
                                    Cancel
                                </button>
                                <button class="btn btn-primary" onclick="updateTable()">
                                    <span class="fa fa-filter"></span>
                                    Filter
                                </button>
                            </div>
                        </div>
                    </div>
                </div>--%>


        <br>
        <button type="button" class="btn btn-outline-primary" onclick="location.href='books/create/'"> Create New Book
        </button>
        <br> <br>

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
                        <spring:url value="/books/edit/${book.id}" var="updateUrl"/>
                        <spring:url value="/books/remove/${book.id}" var="deleteUrl"/>
                        <spring:url value="/books/get/${book.id}" var="getBook"/>

                        <span class='fa fa-pencil' style="margin-left: 10px;" title="Update"
                              onclick="location.href='${updateUrl}'"></span>

                        <span class='fa fa-remove' style="margin-left: 10px;" title="Delete"
                              onclick="location.href='${deleteUrl}'"></span>

                        <span class='fa fa-plus' style="margin-left: 10px;" title="Get Book"
                              onclick="location.href='${getBook}'"></span>

                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div id ="lastPage" class="${lastPage}"></div>
        <div id ="currentPage" class="${currentPage}"></div>

        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center" id="page-items">
               <%-- <li class="page-item" >
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="/books/1">1</a></li>
                <li class="page-item active"><a class="page-link" href="/books/2">2</a></li>
                <li class="page-item"><a class="page-link" href="/books/3">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>--%>
            </ul>
        </nav>


    </div>
</form>


</body>
</html>
