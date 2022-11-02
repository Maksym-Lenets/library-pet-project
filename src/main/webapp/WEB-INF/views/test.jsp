<html>
<%@include file="parts/headTag.jsp" %>
<script type="text/javascript" src="resources/js/test.js" defer></script>
<head>
    <title>Title</title>

</head>
<body>



   <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle">Edit Book</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">



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
                <button type="button" class="btn btn-primary" onclick="addColumns()">
                    <span class="fa fa-check"></span>
                    addColumns
                </button>
            </div>
        </div>
    </div>

</body>
</html>