$(document).ready(function(){

    var url = window.location.pathname;
    var id = url.substring(url.lastIndexOf("/") + 1);

    $('#admin_delete_product').submit(function(e) {
        e.preventDefault();

        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/api/product/'+id,
            success: function(response) {
                window.location.href = "http://localhost:8080/admin";
            }
        });

    });


});