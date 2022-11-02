var ajaxUrl = "rest/books/";
var datatableApi;
var form = $('#detailsForm');
var editedBook;
var authorsArr;

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize()
    }).done(function () {
        console.log(form.serialize());
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
                    return row.author.fullName;
                }
            },
            {
                data: null,
                render: function (data, type, row) {
                    var coAuthors = '';
                    jQuery.each(row.coAuthors, function (i, val) {
                        coAuthors += val.fullName + '; ';
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

function createForm(data) {

    $(document.getElementById("detailsForm")).jsonForm({
        "schema": {

            "type": "object",
            "title": "Book",
            "properties": {
                "id": {
                    "title": "ID",
                    "type": "integer"
                },
                "title": {
                    "title": "Title",
                    "type": "string"
                },
                "author": {
                    "type": "object",
                    "title": "Author",
                    "properties": {
                        "id": {
                            "title": "ID",
                            "type": "integer"
                        },
                        "firstName": {
                            "type": "string",
                            "title": "First Name"
                        },
                        "lastName": {
                            "type": "string",
                            "title": "Last Name"
                        },
                        "fullName": {
                            "type": "string",
                            "title": "Author"
                        }
                    },
                    "multiEnum": {
                        "type": "array",
                        "uniqueItems": true,
                        "items": {
                            "enum": JSON.stringify(authorsArr)
                        }
                    }
                },
                "coAuthors": {
                    "type": "array",
                    "title": "Co-authors",
                    "items": {
                        "type": "object",
                        //"title": "Co-author",
                        "properties": {
                            "id": {
                                "title": "ID",
                                "type": "integer"
                            },
                            "firstName": {
                                "type": "string",
                                "title": "First Name"
                            },
                            "lastName": {
                                "type": "string",
                                "title": "Last Name"
                            },
                            "fullName": {
                                "type": "string",
                                "title": "Full Name"
                            }
                        }
                    }
                }
            }

        }, "form": [
            {
                "key": "id",
                "type": "hidden"
            },
            {
                "key": "title"
            },
            {
                "type": "fieldset",
                "title": "Author",
             //   "expandable": true,
                "items": [
                    {
                        "key": "author.id",
                    },
                    {
                        "key": "author.fullName",
                        //"readOnly": true
                    }
                ]
            },

            {   "type": "fieldset",
                "title": "Co-authors",
                "items":
            {
                "type": "array",
             //   "title": "Co-authors",
                "expandable1": true,
                "items": [{
                    "title": "Co-author {{idx}}",
                    "key": "coAuthors[].fullName"
                }]
            }}],
        "value": data

        //"value": {"id":5,"title":"book54325","authorFullName":"Henry James","copiesAmount":4,"author":{"id":5,"firstName":"Henry","lastName":"James"},"coAuthors":[{"id":2,"firstName":"James","lastName":"Joyce"},{"id":4,"firstName":"Charles","lastName":"Dickens"}]}

    });

}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function updateTable() {
    $.ajax({
        type: "GET",
        url: ajaxUrl
    }).done(updateTableByData);
}

function getAllAuthors() {
    $.ajax({
        url: ajaxUrl + "authors",
        type: "GET"
    }).done(function (data) {
        authorsArr = data;
    });
}


function updateRow(id) {
    getAllAuthors();
    $.get(ajaxUrl + id, function (data) {
        $(document.getElementById("detailsForm")).html('');
        createForm(data);
        //$(document.getElementById("detailsForm")).jsonToForm(data);

        //var formElement = document.getElementById("detailsForm");

        // populate(formElement, data);

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


