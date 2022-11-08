var coAuthorsAmount;


$(document).ready(function () {
    coAuthorsAmount = parseInt(document.getElementById("authors_size").getAttribute("class"));
});

function removeCoAuthor(elemId) {
    console.log(elemId);
    document.getElementById(elemId).remove();
    updateCoAuthorsOrderIndex();
}

function addCoAuthor(coAuthorNumber) {

    if (coAuthorsAmount == null) {
        coAuthorsAmount = coAuthorNumber;
    }
    if (authorsArr == null) {
        getAllAuthors();
    } else {
        addElement();
    }
}

function updateCoAuthorsOrderIndex() {
    var coauthorsElem = document.getElementById("coAuthorsForm").getElementsByTagName("select");
//var lableElem = document.getElementById("coAuthorsForm").getElementsByTagName("label");
    var i;
    for (i = 0; i < coauthorsElem.length; i++) {
        //   lableElem[i].innerHTML = "Co-Author #" + i;
        coauthorsElem[i].setAttribute("name", "coAuthors[" + i + "].id")
    }
    coAuthorsAmount = i;
}

function addElement() {
    var coAuthors = document.getElementById("coAuthorsForm");

    var div = document.createElement("div");
    div.setAttribute("class", "mb-3 row");
    div.setAttribute("id", coAuthorsAmount);

    var lable = document.createElement("lable");
    lable.setAttribute("for", "coAuthors[" + coAuthorsAmount + "].id");
    lable.setAttribute("class", "col-sm-2 col-form-label");
    lable.innerHTML = "Co-Author #" + (parseInt(coAuthorsAmount) + 1);

    var row = document.createElement("div");
    row.setAttribute("class", "row")

    var input = document.createElement("div");
    input.setAttribute("class", "input");

    var select = document.createElement("select");
    select.setAttribute("id", "book.coAuthors[" + coAuthorsAmount + "].id");
    select.setAttribute("name", "coAuthors[" + coAuthorsAmount + "].id");
    select.setAttribute("type", "text");
    select.setAttribute("class", "form-control");

    for (var i = 0; i < authorsArr.length; i++) {
        var option = document.createElement("option");
        option.setAttribute("value", authorsArr[i].id);
        option.innerHTML = authorsArr[i].fullName;
        select.appendChild(option);
    }

    var buttondiv = document.createElement("div");
    buttondiv.setAttribute("class", "col-auto my-1");

    var button = document.createElement("button");
    button.setAttribute("class", "btn btn-outline-danger");
    button.setAttribute("onClick", "removeCoAuthor(" + coAuthorsAmount + ")");
    button.innerHTML = "<span class=\"fa fa-minus\"></span>";


    div.appendChild(lable);

    input.appendChild(select);
    row.appendChild(input);

    buttondiv.appendChild(button);
    row.appendChild(buttondiv);

    div.appendChild(row);

    coAuthors.appendChild(div);


    coAuthorsAmount = coAuthorsAmount + 1;
}



