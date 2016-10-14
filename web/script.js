function getXmlHttpRequest() {
    return new XmlHttpRequest();
}

function getSumCommission() {
    var request = getXmlHttpRequest();
    var handler = getReadyStateHandler(request, updateCart);
    request.onreadystatechange = handler;
    request.open("POST", "cart.do", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send("currency=" + currency);
}
window.onload = function() {
    var array = ["RUB", "BYN"];
    var currencies = document.getElementById("currencies");
    var select = document.createElement("select");
    currencies.appendChild(select);
    for(var i = 0; array.length; i++) {
        var option = document.createElement("option");
        option.value = array[i];
        select.appendChild(option);
    }
}