var ajaxUrl = "rest/books/";
var datatableApi;
var form = $('#detailsForm');

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize()
    }).done(function () {
        $("#editRow").modal("hide");
        updateTable();
    });
}

$(document).ready(function () {
    datatableApi = $('#bookListTable').DataTable({
        ajax: {
            url: ajaxUrl,
            dataSrc: ''
        },
        columns: [
            {data: 'id'},
            {data: 'title'},
            {
                data: null,
                render: function (data, type, row) {
                    return row.author.firstName + ' ' + row.author.lastName;
                }
            },
            {
                data: null,
                render: function (data, type, row) {
                    var coAuthors = '';
                    jQuery.each(row.coAuthors, function( i, val ) {
                        coAuthors += val.firstName + ' ' + val.lastName+'; ';
                    });
                    return coAuthors;
                }
            },
            {data: 'copiesAmount'},
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ]
    });
});

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function updateTable() {
    $.ajax({
        type: "GET",
        url: ajaxUrl
    }).done(updateTableByData);
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'><span class='fa fa-pencil'></span></a>";
    }
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: "DELETE"
    }).done(function () {
        updateTable();
    });
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'><span class='fa fa-remove'></span></a>";
    }


}


