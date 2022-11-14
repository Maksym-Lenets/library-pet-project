var authorsArr;
var form = $('#detailsForm');


function getAllAuthors() {
    $.ajax({
        type: "GET",
        url: "rest/allAuthors/"
    }).done(function (data) {
        authorsArr = data;
        addElement();
    });
}

function createAuthor() {
    $("#editRow").modal();
}

function saveAuthor() {
    $.ajax({
        type: "POST",
        url: "rest/author/",
        data: form.serialize()
    }).done(function (data) {
        $("#editRow").modal("hide");
        updateTable();
        authorsArr.add(data);
    });
}