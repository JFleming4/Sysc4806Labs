$(document).ready(function () {
    var buddies = [];
    // document.appendChild()
    $("#submit").click(function(e) {
        e.preventDefault();
        var input = $("input");
        var params = {
            name: input[0].value,
            number: input[1].value,
            address: input[2].value
        };
        var uri = "/buddy";

        $.ajax({
            method: "POST",
            url: uri,
            contentType: 'application/json',
            data: JSON.stringify(params)
        }).then(function () {
            $.ajax({
                url: "/buddy"
            }).then(function(data) {
                buddies = data._embedded.buddy;
                var budDiv;
                if($("#buddies").length === 0) {
                    budDiv = document.createElement("div");
                    budDiv.setAttribute("id", "buddies");
                    $("form").append(budDiv);
                }
                budDiv = $("#buddies").empty();
                var list = document.createElement("ul");
                for( buddy in buddies) {
                    var text = "Name: " + buddies[buddy].name + " Number: \n" + buddies[buddy].number + " Address: " + buddies[buddy].address;
                    var listItem = document.createElement("li");
                    var textItem = document.createTextNode(text);
                    listItem.appendChild(textItem);
                    list.appendChild(listItem);
                }
                budDiv.append(list);
            })
        });
    });

});