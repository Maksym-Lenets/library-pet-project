<html>
<%@include file="parts/headTag.jsp" %>
<head>
    <title>Books statistic</title>
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
                    <form action="/books/statistic" id="searchForm">
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
                        <h4>Number of
                            books ${endDate == null && startDate == null? 'gave to users' : ' were giving to users in selected period'}: ${givenBooks}</h4>
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

                <div class="row">
                    <div class="col">
                        <div class="card-body py-0">
                            <table class="table table-striped table-bordered" id="bookListTable">
                                <thead><h3>Average time of reading</h3></thead>
                                <tr class="table-primary">
                                    <th style="width:10%">Title</th>
                                    <th style="width:20%">Author</th>
                                    <th style="width:30%">AVG time of reading (days)</th>
                                    <th style="width:40%">By books copies</th>
                                </tr>
                                <tbody>
                                <c:forEach items="${booksWithReadingTime}" var="book">
                                    <tr>
                                        <td>${book.title}</td>
                                        <td>${book.author.fullName}</td>
                                        <td>${book.avgReadingTime}</td>

                                        <td>
                                            <c:forEach items="${book.copies}" var="copy" varStatus="loop">
                                                copy #${loop.index + 1} - ${copy.avgDaysOfReading} days
                                                <c:if test="${not loop.last}">;</c:if>
                                            </c:forEach>
                                        </td>


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
