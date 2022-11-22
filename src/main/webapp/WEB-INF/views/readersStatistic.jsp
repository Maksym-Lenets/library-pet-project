<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/books.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<jsp:include page="parts/header.jsp"/>


<div class="container">

    <h4>Average readers age: ${averageAge}</h4>
    <div class="row">
        <div class="col-md-10">
            <div class="card">
                <div class="card-header">
                    <h5>Select period</h5>
                </div>
                <div class="card-body py-0">
                    <form action="/readers/statistic" id="searchForm">
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
                        <h4>Number of requests: ${requests.size()}</h4>
                        <div class="text-right">
                            <button type="reset" class="btn btn-danger" onclick="location.href='books/statistic';">
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
                <table class="table table-striped table-bordered" id="bookListTable">
                    <tr class="table-primary">
                        <th>User</th>
                        <th>Book</th>
                        <th>Request day</th>
                        <th>Get book day</th>
                        <th>Should be return day</th>
                        <th>Return day</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${requests}" var="request">
                        <tr>
                            <td>${request.user.email}</td>
                            <td>${request.bookInstance.book.title}</td>
                            <td>${request.requestDate}</td>
                            <td>${request.getBookDate}</td>
                            <td>${request.shouldBeReturn}</td>
                            <td>${request.returnBookDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>

</body>
</html>
