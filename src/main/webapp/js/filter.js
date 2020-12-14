filterSelection("all");
function filterSelection(c) {
    var x, i;
    x = document.getElementsByClassName("search-item");
    if (c == "all"){
        c = "";
        // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1) {
                w3AddClass(x[i], "show");
            }
        }}
    else{
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
        }
        for (var j = 0; j < c.length; j++) {
            c[j]
            for (i = 0; i < x.length; i++) {
                if (x[i].className.indexOf(c[j]) > -1) {
                    w3AddClass(x[i], "show");
                }
            }
        }
    }
}

// Show filtered elements
function w3AddClass(element, name) {
    var i, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (i = 0; i < arr2.length; i++) {
        if (arr1.indexOf(arr2[i]) == -1) {
            element.className += " " + arr2[i];
        }
    }
}

// Hide elements that are not selected
function w3RemoveClass(element, name) {
    var i, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (i = 0; i < arr2.length; i++) {
        while (arr1.indexOf(arr2[i]) > -1) {
            arr1.splice(arr1.indexOf(arr2[i]), 1);
        }
    }
    element.className = arr1.join(" ");
}

function allChecked(){
    var inputs = document.querySelectorAll("input");
    var checkedItems = [];
    checkedItems = [];
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].checked){
            checkedItems.push(inputs[i].value);
        }
    }
    console.log(checkedItems);
    console.log(inputs.length);
    if(checkedItems.length == 0){
        checkedItems="all";
    }

    filterSelection(checkedItems);
}


var item = document.getElementById("el");
item.getElementsByClassName("language-mark");
