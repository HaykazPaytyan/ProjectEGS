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

    $('#user_delete_form').submit(function(e){
        e.preventDefault();

        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/api/user/'+id,
            success: function (data) {
                window.location.href = "http://localhost:8080";
            }
        });

    });


});