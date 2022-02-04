$(document).ready(function(){
    $('#login').submit(function(e){
        e.preventDefault();

        var user_email = $('#email').val();
        var user_password = $('#password').val();


        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/auth',
            data: JSON.stringify({email: user_email,password: user_password}),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (response) {
                let jsonObject = JSON.parse(response);
                window.location.href = "http://localhost:8080/account/" + jsonObject.id;
            }
        });

    });

});