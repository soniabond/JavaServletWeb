

//document.getElementById("change-form").insertBefore(newDiv, addLanguageButton);
/*
addLanguageButton.innerHTML = "<<div class="search-item">
  <div id="add-item" class="info-box">
  </div>
</div>";*/
var changeButton = document.getElementById("change-profile");


changeButton.onclick = function(){

    var userName = document.getElementById("name");
    var userNameText = userName.textContent;
    userName.innerHTML = "<textarea>"+userNameText+"</textarea><br>";
    var userDescription = document.getElementById("user-description");
    var userDescriptionText= userDescription.textContent;
    userDescription.innerHTML = "<textarea rows=5 cols=80>"+userDescriptionText+"</textarea><br>";


    var languageDivs = document.querySelectorAll(".languageName");
    languageDivs.forEach(function(lang){
        var langName = lang.textContent;
        lang.innerHTML = "<textarea>"+langName+"</textarea><br>";
    });

    var languageDivs = document.querySelectorAll(".languageDesc");
    languageDivs.forEach(function(lang){
        var langName = lang.textContent;
        lang.innerHTML = "<textarea  rows=5 cols=80>"+langName+"</textarea><br>";
    });


//adding changeButton
    var newDiv = document.createElement("div");
    newDiv.classList.add("search-item");
    newDiv.id = "add";
    var addLanguageButton = document.getElementById("add-new-item");
    addLanguageButton.prepend(newDiv);
    newDiv = document.querySelectorAll(".search-item");
    newDiv = newDiv[newDiv.length-1];
    var innerDiv = document.createElement("div");
    innerDiv.id="add-item";
    innerDiv.classList.add("info-box");
    innerDiv.innerHTML = "<b>+</b>"
    newDiv.prepend(innerDiv);


    //change ChangeProfile button
    var changeProfileButton = document.getElementById("change-profile");
    changeProfileButton.textContent = "Save changes";
    var submitArea = document.createElement("input");
    submitArea.type = "submit";
    submitArea.value = "Save changes";
    submitArea.classList.add("submit-button");
    changeProfileButton.after(submitArea);
    changeProfileButton.remove();
}


var addLanguageButton = document.getElementById("add-new-item");
addLanguageButton.onclick = function(){
    var form = document.getElementsByClassName("profile-lang-data-content")[0];
    var newDiv = document.createElement("div");
    newDiv.classList.add("search-item");
    newDiv.classList.add("show");
    form.append(newDiv);
    newDiv = document.querySelectorAll(".search-item");
    newDiv = newDiv[newDiv.length-1];
    var innerDiv = document.createElement("div");
    innerDiv.id="info-page";
    innerDiv.classList.add("profile-box");
    select = document.createElement("select");


    opt1 = document.createElement("option");
    opt1.value = "java";
    opt1.textContent = "java";
    select.append(opt1);
    opt2 = document.createElement("option");
    opt2.value = "js";
    opt2.textContent = "js";
    select.append(opt2);
    innerDiv.append(select);
    textarea = document.createElement("textarea");
    textarea.rows = 5;
    textarea.cols = 80;
    textarea.textContent = "tell what you can teach";
    innerDiv.append(textarea);
    //"<textarea>"+"language name"+"</textarea><br>" + "<textarea rows=5 cols=80>"+"tell what you can teach"+"</textarea><br>";

    newDiv.append(innerDiv);

}
