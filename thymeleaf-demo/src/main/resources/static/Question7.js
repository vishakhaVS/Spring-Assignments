$(function () {
    $("#getTime").click(function () {
        $.ajax({
            url: "/getTime",
            method: "GET"
        }).done(function (data) {
            if (data) {
                $("#showtime").html(data).css("color", "green");
            }
        }).fail(function (error) {
            $("#showtime").html(error).css("color", "red");
        })
    });
});