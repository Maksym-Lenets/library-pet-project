var form = $('#detailsForm');
var ajaxUrl = "rest/books/";
var authorsArr;

function getAllAuthors() {
    $.ajax({
        url: ajaxUrl + "authors",
        type: "GET"
    }).done(function (data) {
        authorsArr = data;
    });

}

$(document).ready(function () {
   // getAllAuthors();
})

$("form").jsonForm({
    "schema": {
        "name": {
            "title": "Name",
            "description": "Nickname allowed",
            "type": "string"
        },
        "gender": {
            "title": "Gender",
            "description": "Your gender",
            "type": "string",
            "enum": [
                "male",
                "female",
                "alien"
            ]
        }
    }
});

function addColumns() {
    var container = document.getElementById("detailsForm");

    /*var documentFragment = document.createDocumentFragment();*/

    var div = document.createElement("div");
    div.setAttribute("class", "form-group");

    var lable = document.createElement("lable");
    lable.setAttribute("for", "coauthor");
    lable.setAttribute("class", "col-form-label");
    lable.innerHTML = "Coauthor";
    container.appendChild(lable);

    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("class", "form-control");
    input.setAttribute("id", "coauthor");
    input.setAttribute("name", "coauthor");
    input.setAttribute("placeholder", "Co-Author " + 1 + " Full Name");
    container.appendChild(input);

  //  container.appendChild(div);

}



