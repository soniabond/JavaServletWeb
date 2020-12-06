function $(sel) {
    return document.querySelector(sel);
}

var dialog = $('dialog');
var main = $('main');
var dialogButtons = document.querySelectorAll('.dialog-button');
let leaveDialogButton = document.getElementById('leave-dialog-button');
dialogButtons.forEach(function(btn) {
    btn.onclick = function() {	dialog.setAttribute('open', '');
        document.getElementById("button-name").textContent = "button";


        main.classList.add('de-emphasized');
    }
});


/*dialogButton.onclick = function() {	dialog.setAttribute('open', '');

	main.classList.add('de-emphasized');
}*/

leaveDialogButton.onclick = function() {
    if (dialog.close) {
        dialog.close();
    }
    else {
        dialog.removeAttribute('open');
    }

    main.classList.remove('de-emphasized');
}
