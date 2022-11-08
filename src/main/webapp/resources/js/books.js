var lastPage;
var currentPage;

$(document).ready(function () {
    lastPage = parseInt(document.getElementById("lastPage").getAttribute("class"));
    currentPage = parseInt(document.getElementById("currentPage").getAttribute("class"));
    addPagination();
});

function addPagination() {
    var page = document.getElementById("page-items");

    var li = document.createElement("li");
    li.setAttribute("class", "page-item");

    //PREV
    var aElem = document.createElement("a");
    aElem.setAttribute("class", "page-link");
    if (currentPage > 1) {
        aElem.setAttribute("href", "/books/" + (currentPage - 1));
    } else {
        aElem.setAttribute("href", "/books/" + lastPage);
    }
    aElem.innerHTML = "Previous";

    li.appendChild(aElem);
    page.appendChild(li);


    var startIndex = (currentPage - 2) > 0 ? (currentPage - 2) : 1;
    var finishIndex = (currentPage + 2) < lastPage ? (currentPage + 2) : lastPage

    for (var i = startIndex; i <= finishIndex; i++) {
        li = document.createElement("li");
        if (i === currentPage) {
            li.setAttribute("class", "page-item active");
        } else {
            li.setAttribute("class", "page-item");
        }

        aElem = document.createElement("a");
        aElem.setAttribute("class", "page-link");
        aElem.setAttribute("href", "/books/" + i);


        aElem.innerHTML = "" + i;

        li.appendChild(aElem);
        page.appendChild(li);

    }


    //NEXT
    li = document.createElement("li");
    li.setAttribute("class", "page-item");
    aElem = document.createElement("a");
    aElem.setAttribute("class", "page-link");
    if (currentPage < lastPage) {
        aElem.setAttribute("href", "/books/" + (currentPage + 1));
    } else {
        aElem.setAttribute("href", "/books/" + 1);
    }
    aElem.innerHTML = "Next";

    li.appendChild(aElem);
    page.appendChild(li);
}

