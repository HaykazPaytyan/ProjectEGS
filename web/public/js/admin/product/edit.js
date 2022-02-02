$(document).ready(function() {

    var url = window.location.pathname;
    var id = url.substring(url.lastIndexOf("/") + 1);

    $('#admin_edit_product').submit(function(e) {
        e.preventDefault();

        var product_name = $('#name').val();
        var product_price = $('#price').val();
        var product_count = $('#count').val();
        var product_code = $('#code').val();



        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/api/product/'+ id,
            data: JSON.stringify({name: product_name,price: product_price,count: product_count,code: product_code}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function(response) {
                window.location.href = "http://localhost:8080/admin";
            }
        });

    });
});