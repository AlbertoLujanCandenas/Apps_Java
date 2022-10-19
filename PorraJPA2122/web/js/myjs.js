$(document).ready(function() {
    console.log('ready');
    init();
});

function init(){
    console.log('init');
   onshowapostar();
   onshowinfo();
}

function onshowapostar(){
	$('#modalapostar').on('show.bs.modal', function (event) {
            console.log('apostar');
	  var button = $(event.relatedTarget) // Button that triggered the modal
	 
	  var dni = button.data('dni')
          var idpartido = button.data('partido')
          var local = button.data('local')
          var visitante = button.data('visitante')
          
	  var modal = $(this)
	  modal.find('.modal-body span:first-child').text(local)
          modal.find('.modal-body span:last-child').text(visitante)
	  modal.find('form').attr("action", "Controller?op=apostar&dni="+dni+"&idpartido="+idpartido);
	})
}
function onshowinfo(){
    $('#modalinfo').on('show.bs.modal', function (event) {
        console.log('info');
        var button = $(event.relatedTarget) // Button that triggered the modal

        var idpartido = button.data('partido')
        var local = button.data('local')
        var visitante = button.data('visitante')

        var modal = $(this)
        modal.find('.modal-body h4').text(local+' - '+visitante)
        $.ajax({
              type: "GET",
              url: "Controller?op=apuestas&idpartido="+idpartido,
              success : function(info) {
                      modal.find('.modal-body div').html(info)
              }
        });
    })
}
