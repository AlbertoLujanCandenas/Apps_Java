$(document).ready(function () {
    console.log('ready')
    init()
});

function init() {
     // Listeners
    loadMovies()
}

function loadMovies() {
    $('#modalmovies').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var i = button.data('i')
        var nombre = button.data('person')
        var modal = $(this)
        console.log('i='+i)
        modal.find('h4').text(nombre) 
        
        $.ajax({
            type: "GET",
            url: "Controller?op=movies&i=" + i,
            success: function (info) {
                $("#movies").html(info)
            }
        })
    })
}
