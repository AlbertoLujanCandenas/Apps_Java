<%@page import="model.Estacion"%>
<%@page import="model.LineaLista"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Metro</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
	<%
		//El controller pasa a la session las lineas nada mas empezar
		ArrayList<LineaLista> lineas = (ArrayList<LineaLista>) session.getAttribute("lineas");
	
		//Obtenemos las estaciones desde el request, despues hay que hacer un if para cuando no haya estaciones
		ArrayList<Estacion> estaciones = (ArrayList<Estacion>) request.getAttribute("estaciones");
		
		//Esto lo hacemos para saber la linea que esta seleccionada actualmente, ya que un request rebota, es decir:
		//La pagina le manda datos al controller, este pone los datos que se le pidan y luego el request rebota de nuevo a la web, entonces se va 
		//a tener tambien los datos que se pusieron cuando se llamo al controller.
		//En nuestro caso se le puso al request el atributo linea cuando se selecciono una en el formulario
		String lineaElegida = request.getParameter("linea");
	%>
    <div class="container shadow">
        <div class="row justify-content-center">
            <div class="col-6">
                <div class="form-group">
                    <form action="Controller?op=dameestaciones" method="post">
                        <label for="">Linea</label>
                        <!-- name = nombre de la variable que viaja -->
                        <!-- El onChange hace que se haga el submit automaticamente en cuanto se elija, sin tener que poner un boton -->
                        <select class="form-control" name="linea" id="linea" onchange="this.form.submit()">
                        	<option value="null" disabled="disabled">Elija linea</option>
                        	<%
                        		for(LineaLista linea:lineas){
                        	%>
                        	<option value="<%=linea.getNlinea()%>"><%=linea.getInifin()%></option>
                        	<%
                        		}
                        	%>
                        </select>
                    </form>

                </div>
            </div>
        </div>
    	<% if(estaciones != null){ %>
    	<div class="row justify-content-center">
            <div class="col-8">
            	<table class="table">
                    <thead>
                        <tr>
                            <th>Nombre estacion</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    	<%
                       		for(Estacion estacion : estaciones){
						%>
                        	<tr>
                            	<td><%=estacion.getNombre() %></td>
                        	</tr>
                        <%
                        	}
                        %>
                        
                    </tbody>
                </table>
            </div>
        </div>
    	<%	}%>
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        
    <script type="text/javascript">
    	//Hay que ponerlo debajo del script que carga el jquery de bootstrap
    	$('#linea').val('<%=lineaElegida%>')
    	//Accedo al objeto de id linea y le pongo de valor el String de la lineaElegida
    </script>
</body>

</html>