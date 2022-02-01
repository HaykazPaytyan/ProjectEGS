$(document).ready(function(){
    $('#user_form').submit(function(e){
        e.preventDefault();

    var user_first_name = $('#first_name').val();
    var user_last_name = $('#last_name').val();
    var user_email = $('#email').val();
    var user_password = $('#password').val();
    var user_password_repeat = $('#password_repeat').val();


        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/user',
            data: JSON.stringify({first_name: user_first_name,last_name: user_last_name, email: user_email,password: user_password, password_repeat:user_password_repeat}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                window.location.href = "http://localhost:8080/account";
            }
        });

    });

});