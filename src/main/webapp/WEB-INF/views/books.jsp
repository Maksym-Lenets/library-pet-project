<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/books.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>


<div class="container">
    <h2 id="welcome">Welcome ${user.firstName} to library</h2>

    <div class="row">
        <div class="col-7">
            <div class="card">
                <div class="card-header">
                    <h5>Books search
                        <span class="${searchDisplay ? 'fa fa-angle-down' : 'fa fa-angle-up'}" id="hideSearchIcon"
                              onclick="hideSearch()"></span>
                    </h5>
                </div>
                <div class="card-body py-0">
                    <form action="/books/filter" id="searchForm"
                          style="${searchDisplay ? 'display:block;' : 'display:none;'}">
                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label class="col-form-label" for="bookTitle">Book title</label>
                                    <input type="text" class="form-control col-10" name="bookTitle"
                                           id="bookTitle"
                                           value="${bookTitle == null ? '' : bookTitle}"
                                           onclick="this.value=''"/>
                                </div>

                                <div class="col">
                                    <label class="col-form-label" for="authorName">Author Name</label>
                                    <input type="text" class="form-control col-10" name="authorName"
                                           id="authorName"
                                           value="${authorName == null ? '' : authorName}"
                                           onclick="this.value=''"/>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="reset" class="btn btn-danger" onclick="location.href='books/';">
                                <span class="fa fa-remove"></span>
                                Cancel
                            </button>

                            <button type="submit" class="btn btn-primary">
                                <span class="fa fa-filter"></span>
                                Filter
                            </button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

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
            <th>Copies/Available</th>
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
                <td style="text-align:center">${book.copiesAmount} / ${book.availableCopiesAmount}</td>

                <td>
                    <spring:url value="/books/edit/${book.id}" var="updateUrl"/>
                    <spring:url value="/books/remove/${book.id}" var="deleteUrl"/>
                    <spring:url value="/books/get/${book.id}" var="getBook"/>

                    <span class='fa fa-pencil' style="margin-left: 10px; color: limegreen;" title="Update"
                          onclick="location.href='${updateUrl}'"></span>

                    <span class='fa fa-remove' style="margin-left: 10px; color: red;" title="Delete"
                          onclick="location.href='${deleteUrl}'"></span>

                    <span class='fa fa-plus'
                          style='margin-left: 10px; ${book.availableCopiesAmount > 0 ? "color: slateblue;":""}'
                          title="Get Book"
                            <c:if test="${book.availableCopiesAmount > 0}"> onclick="location.href='${getBook}'"</c:if>
                    ></span>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div id="page-items">
    </div>
    <div id="currentPage" class="${currentPage}"></div>
    <div id="lastPage" class="${lastPage}"></div>


</div>

</body>
</html>
