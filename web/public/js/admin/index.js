$(document).ready(function() {

    $(".tab-content-2").css("display", "none");

    $("#tab-1").click(function() {
        $(".tab-content-1").css("display", "block");
        $(".tab-content-2").css("display", "none");
    });

    $("#tab-2").click(function() {
        $(".tab-content-2").css("display", "block");
        $(".tab-content-1").css("display", "none");
    });


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/user',
        dataType: 'JSON',
        success: function(response) {
            var len = response.length;
            for (var i = 0; i < len; i++) {
                var id = response[i].id;
                var first_name = response[i].first_name;
                var last_name = response[i].last_name;
                var email = response[i].email;
                var password = response[i].password;

                var tr_str = "<tr class='text-center'>" +
                    "<td>" + id + "</td>" +
                    "<td>" + first_name + "</td>" +
                    "<td>" + last_name + "</td>" +
                    "<td>" + email + "</td>" +
                    "<td>" + password + "</td>" +
                    "<td>" + "<a class=\'btn btn-outline-success\' href='/admin/user/edit/" + id + "'>Edit User</a>" + "&nbsp;" + "<a class=\'btn btn-outline-danger\' href='/admin/user/delete/" + id + "'>Delete User</a>" + "</td>" +
                    "</tr>";

                $("#user_list").append(tr_str);

            }
        }
    });



    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/product',
        dataType: 'JSON',
        success: function(response) {
            var len = response.length;
            for (var i = 0; i < len; i++) {
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
                    "<td>" + "<a class=\'btn btn-outline-success\' href='/admin/product/edit/" + id + "'>Edit Product</a>" + "&nbsp;" + "<a class=\'btn btn-outline-danger\' href='/admin/product/delete/" + id + "'>Delete Product</a>" + "</td>" +
                    "</tr>";

                $("#product_list").append(tr_str);

            }
        }
    });

    $('#admin_create_user').submit(function(e) {
        e.preventDefault();

        var user_first_name = $('#first_name').val();
        var user_last_name = $('#last_name').val();
        var user_email = $('#email').val();
        var user_password = $('#password').val();
        var user_password_repeat = $('#password_repeat').val();


        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/user',
            data: JSON.stringify({first_name: user_first_name,last_name: user_last_name,email: user_email,password: user_password,password_repeat: user_password_repeat}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function(response) {
                window.location.href = "http://localhost:8080/admin";
            }
        });

    });

    $('#admin_create_product').submit(function(e) {
        e.preventDefault();

        var product_name = $('#name').val();
        var product_price = $('#price').val();
        var product_count = $('#count').val();
        var product_code = $('#code').val();



        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/product',
            data: JSON.stringify({name: product_name,price: product_price,count: product_count,code: product_code}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function(response) {
                window.location.href = "http://localhost:8080/admin";
            }
        });

    });
});