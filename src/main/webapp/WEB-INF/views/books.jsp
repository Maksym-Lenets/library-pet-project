<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/bookTable.js" defer></script>
<head>
    <title>Books Page</title>

</head>

<body>
<form>
    <div class="container">
        <table class="table table-striped table-bordered" id="bookListTable">
            <thead>
            <tr class="table-primary">
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Co-authors</th>
                <th>Copies</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</form>


<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle">Edit Book</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="title" class="col-form-label">Title</label>
                        <input class="form-control" id="title" name="title"
                               placeholder="Title"/>
                    </div>

                    <div class="form-group">
                        <label for="authorFullName" class="col-form-label">Author</label>
                        <input type="text" class="form-control" id="authorFullName" name="authorFullName"
                               placeholder="Author"/>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    <span class="fa fa-close"></span>
                    Cancel
                </button>
                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    Save
                </button>
            </div>
        </div>
    </div>
</div>




</body>
</html>
