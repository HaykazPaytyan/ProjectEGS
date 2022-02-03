$(document).ready(function(){

    var url = window.location.pathname;
    var id = url.substring(url.lastIndexOf("/") + 1);

    $('#admin_edit_user').submit(function(e) {
        e.preventDefault();

        var user_first_name = $('#first_name').val();
        var user_last_name = $('#last_name').val();
        var user_email = $('#email').val();
        var user_password = $('#password').val();
        var user_password_repeat = $('#password_repeat').val();


        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/api/user/edit/'+id,
            data: JSON.stringify({first_name: user_first_name,last_name: user_last_name,email: user_email,password: user_password,password_repeat: user_password_repeat}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function(response) {
                window.location.href = "http://localhost:8080/admin";
            }
        });

    });


});