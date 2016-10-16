function getOffer(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        alert("Success!!!");
    }
    xhr.open("GET", "offer", true);
    xhr.send();
}

/*
window.onload = function() {
    var array = ["RUB", "BYN", "USD", "EUR"];
    var currencies = document.getElementById("currencies");
    var select = document.createElement("select");
    currencies.appendChild(select);
    for(var i = 0; array.length; i++) {
        var option = document.createElement("option");
        option.value = array[i];
        select.appendChild(option);
    }
}*/
