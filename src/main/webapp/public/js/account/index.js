$(document).ready(function(){

    var url = window.location.pathname;
    var id = url.substring(url.lastIndexOf("/") + 1);
    $("#edit_account").attr("href","http://localhost:8080/account/edit/" + id);
    $("#delete_account").attr("href","http://localhost:8080/account/delete/" + id);

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/user/'+id,
        dataType: 'JSON',
        success: function (response) {
           if (response === null){
               window.location.href = "http://localhost:8080";
           }

           $("#first_name_show").append(response.first_name);
           $("#last_name_show").append(response.last_name);
        }
    });


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/products',
        dataType: 'JSON',
        success: function (response) {
            var len = response.length;
            for(var i=0; i<len; i++){
                var id = response[i].id;
                var name = response[i].name;
                var price = response[i].price;
                var count = response[i].count;
                var code = response[i].code;

                var tr_str = "<tr class='text-center'>" +
                    "<td>" + id + "</td>" +
                    "<td>" + name + "</td>" +
                    "<td>" + price + "</td>" +
                    "<td>" + count + "</td>" +
                    "<td>" + code + "</td>" +
                    "<td>" + "<a class=\'btn btn-outline-success\' href='/api/user/"+ id +"'>Sell Product</a>" + "</td>" +
                    "</tr>";

                $("#products").append(tr_str);

            }
        }
    });
});