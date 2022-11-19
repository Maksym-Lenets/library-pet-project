<html>
<%@include file="parts/headTag.jsp" %>
<head>
    <title>Top books</title>
</head>
<body>
<jsp:include page="parts/header.jsp"/>

<br>
<div class="container">

    <div class="row">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header">
                    <h5>Select period</h5>
                </div>
                <div class="card-body py-0">
                    <form action="/books/top" id="searchForm">
                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label class="col-form-label" for="startDate">Start date</label>
                                    <input type="date" class="form-control col-10" name="startDate"
                                           id="startDate"
                                           value="${startDate == null ? '' : startDate}"
                                           onclick="this.value=''"/>
                                </div>

                                <div class="col">
                                    <label class="col-form-label" for="endDate">End Date</label>
                                    <input type="date" class="form-control col-10" name="endDate"
                                           id="endDate"
                                           value="${endDate == null ? '' : endDate}"
                                           onclick="this.value=''"/>
                                </div>
                            </div>
                        </div>
                        <div class="text-right">
                            <button type="reset" class="btn btn-danger" onclick="location.href='books/top';">
                                <span class="fa fa-remove"></span>
                                Cancel
                            </button>

                            <button type="submit" class="btn btn-primary">
                                <span class="fa fa-filter"></span>
                                Filter
                            </button>

                        </div>
                    </form>

                    <div class="row">
                        <div class="col">
                            <table class="table table-striped table-bordered" style="width:100%" id="topBookListTable">
                                <thead><h5>10 most popular</h5></thead>
                                <tr class="table-primary">
                                    <th style="width:40%">Title</th>
                                    <th style="width:60%">Author</th>

                                </tr>
                                <tbody>
                                <c:forEach items="${popularBooksList}" var="book">
                                    <tr>
                                        <td>${book.title}</td>
                                        <td>${book.author.fullName}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <table class="table table-striped table-bordered" style="width:100%" id="bookListTable">
                                <thead><h5>10 least popular</h5></thead>
                                <tr class="table-primary">
                                    <th style="width:40%">Title</th>
                                    <th style="width:60%">Author</th>

                                </tr>
                                <tbody>
                                <c:forEach items="${unpopularBooksList}" var="book">
                                    <tr>
                                        <td>${book.title}</td>
                                        <td>${book.author.fullName}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
