var lastPage;
var currentPage;

$(document).ready(function () {
    if (document.getElementById("lastPage").getAttribute("class") !== "") {
        lastPage = parseInt(document.getElementById("lastPage").getAttribute("class"));
        currentPage = parseInt(document.getElementById("currentPage").getAttribute("class"));
        addPagination();
    }

});

function addPagination() {
    var page = document.getElementById("page-items");

    var nav = document.createElement("nav");
    nav.setAttribute("aria-label", "Page navigation");

    var ul = document.createElement("ul");
    ul.setAttribute("class", "pagination justify-content-center");

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
    ul.appendChild(li);


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
        ul.appendChild(li);

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
    ul.appendChild(li);

    nav.appendChild(ul);
    page.appendChild(nav);
}

function hideSearch() {
    var search = document.getElementById("searchForm");
    var icon = document.getElementById("hideSearchIcon");
    if (search.style.display === "none") {
        search.style.display = "block";
        icon.setAttribute("class", "fa fa-angle-down");
    } else {
        search.style.display = "none";
        icon.setAttribute("class", "fa fa-angle-up");
    }
}