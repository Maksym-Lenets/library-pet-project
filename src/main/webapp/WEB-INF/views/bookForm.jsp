<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/bookForm.js" defer></script>
<script type="text/javascript" src="resources/js/authors.js" defer></script>
<head>
    <title>Title</title>


</head>
<body>
<jsp:include page="parts/header.jsp"/>

<br>

<div class="container">
    <jsp:useBean id="book" type="academy.softserve.library.dto.BookDto" scope="request"/>
    <%-- <h3><spring:message code="${book.isNew() ? 'book.add' : 'book.edit'}"/></h3>--%>

    <form:form method="post" modelAttribute="book" action="books/save">

        <form:hidden path="id"/>

        <spring:bind path="book.title">
            <div class="mb-3 row">
                <label for="title" class="col-sm-2 col-form-label">Title:</label>
                <div class="input">
                    <form:input path="title" type="text" id="title" class="form-control"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="book.availableCopiesAmount">
            <div class="mb-3 row">
                <label for="availableCopiesAmount" class="col-sm-2 col-form-label">Available Books:</label>
                <div class=>
                    <form:input path="availableCopiesAmount" type="text" readonly="true" class="form-control-plaintext"
                                id="availableCopiesAmount"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="book.copiesAmount">
            <div class="mb-3 row">
                <label for="copiesAmount" class="col-sm-2 col-form-label">Copies Amount:</label>
                <div class=>
                    <form:input path="copiesAmount" type="number" id="copiesAmount" class="form-control" name="quantity"
                                min="${book.copiesAmount - book.availableCopiesAmount}" max="1000"/>
                </div>
            </div>
        </spring:bind>


        <spring:bind path="book.author.fullName">
            <div class="mb-3 row">
                <label for="author.id" class="col-sm-2 col-form-label">Author:</label>
                <div class="input">
                    <form:select path="author.id" type="text" id="author.id"
                                 class="form-control">
                        <c:forEach items="${authorsArr}" var="authors">
                            <form:option value="${authors.id}" label="${authors.fullName}"/>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
        </spring:bind>
        <button type="button" class="btn btn-outline-primary" onclick="createAuthor()">Create New Author</button>
        <br> <br>
        <h5>Co-Authors: </h5>
        <div id="coAuthorsForm">
            <div id="authors_size" class=${book.coAuthors.size()}></div>

            <c:forEach items="${book.coAuthors}" var="coAuthor" varStatus="loop">
                <spring:bind path="book.coAuthors[${loop.index}].id">

                    <div class="mb-3 row" id="${loop.index}">
                        <label for="coAuthors[${loop.index}].id" class="col-sm-2 col-form-label">Co-Author
                            #${loop.index+1} :</label>

                        <div class="row">
                            <div class="input">
                                <form:select path="coAuthors[${loop.index}].id" type="text"
                                             id="book.coAuthors[${loop.index}].id"
                                             class="form-control">
                                    <c:forEach items="${authorsArr}" var="authors">
                                        <form:option value="${authors.id}" label="${authors.fullName}"/>
                                    </c:forEach>
                                </form:select>
                            </div>

                            <div class="col-auto my-1">
                                <button type="button" class="btn btn-outline-danger"
                                        onclick="removeCoAuthor(${loop.index})">
                                    <span class="fa fa-minus"></span>
                                </button>
                            </div>

                        </div>
                    </div>

                </spring:bind>
            </c:forEach>

        </div>

        <button type="button" class="btn btn-outline-primary" onclick="addCoAuthor()">
            <span class="fa fa-plus"> ADD</span>
        </button>
        <br> <br>

        <div class="row">
            <button class="btn btn-secondary" onclick="window.history.back()" type="button">Cancel</button>
            <button class="btn btn-primary" type="submit" style="margin-left: 10px;">Save</button>
        </div>

    </form:form>


</div>


<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle">Create Author</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form class="detailsForm" id="detailsForm">

                    <div class="form-group">
                        <label for="firstName" class="col-form-label">First Name</label>
                        <input class="form-control" id="firstName" name="firstName"
                               placeholder="First Name"/>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-form-label">Last name</label>
                        <input class="form-control" id="lastName" name="lastName"
                               placeholder="Last name"/>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    Cancel
                </button>
                <button type="button" class="btn btn-primary" onclick="saveAuthor()">
                    <span class="fa fa-check"></span>
                    Save
                </button>
            </div>
        </div>
    </div>
</div>


</body>
</html>
