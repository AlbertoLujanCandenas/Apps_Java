<%@page import="model.Jugador"%>
<%@page import="model.Equipo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Fútbol</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
	<% 

		ArrayList<Equipo> equipos =(ArrayList<Equipo>)session.getAttribute("equipos");
		ArrayList<Jugador> jugadores = (ArrayList<Jugador>)request.getAttribute("jugadores");
	%>
    <div class="container shadow">
        <div class="row justify-content-center">
            <div class="col-6">
                <div class="form-group">
                    <form action="Controller?op=damejugadores" method="post">
                        <label for="">Equipo</label>
                        <select class="form-control" name="equipo" id="equipo" onchange="this.form.submit()">
                        <%
						for (Equipo equipo:equipos)  {%>
								<option value="<%=equipo.getCodequipo() %>"><%=equipo.getNombre() %></option>
						<% }%>
                        
                        </select>
                    </form>
                </div>

            </div>
        </div>
     	<%if(jugadores!=null){ %>
     	<div class="row justify-content-center">
            <div class="col-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre Jugador</th>

                        </tr>
                    </thead>
                    <tbody>
                    <%for(Jugador jugador:jugadores) {%>
                        <tr>
                            <td><%=jugador.getNombre() %></td>
                        </tr>
                    <%} %>
                    </tbody>
                </table>
            </div>
        </div>
   		<%} %>
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
</body>

</html>