<%-- 
    Document   : home
    Created on : 14-ene-2022, 13:20:35
    Author     : diurno
--%>

<%@page import="entities.Usuario"%>
<%@page import="entities.Partido"%>
<%@page import="entities.Jornada"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

<head>
    <title>WebPorra - Azarquiel</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <%
        List<Jornada> jornadas = (List<Jornada>) session.getAttribute("jornadas");
        List<Partido> partidos = (List<Partido>) session.getAttribute("partidos");
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String indexjornada = (String)session.getAttribute("indexjornada");
    %>

    <div class="container shadow p-0 rounded-circulo">
        <nav class="navbar navbar-expand-sm navbar-light bg-azul">
            <a class="navbar-brand mr-auto" href="#"><img src="img/liga.png" alt=""></a>

            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavId">
                <%
                    if (usuario!=null) {%>
                        <span class="mr-3 display-4 text-white">Welcome <%=usuario.getNombre() %></span>
                        <span class="mr-3 display-4"><a href="Controller?op=logout" class="btn btn-danger"><i class="fa fa-sign-out"
                    aria-hidden="true"></i> LOG OUT</a></span>
                    <%}
                    else {%>
                        <span class="mr-3 display-4"><button class="btn btn-success" data-toggle="modal" data-target="#modallogin"><i class="fa fa-user-circle"
                    aria-hidden="true"></i> LOGIN</button></span>
                    <%}
                %>
                
                
            </div>
        </nav>
        
        <div class="row mx-0">
            <div class="col-md-6 offset-md-3">
                <form method="post" action="Controller?op=vajornada">
                    <div class="form-group">
                        <label for=""></label>
                        <select class="form-control" name="jornada" id="jornada" onchange="this.form.submit()">
                            <option value="null" disabled="">Elija jornada</option>
                            <% 
                                Jornada mijornada;
                                for (int i =0; i<jornadas.size();i++) {
                                   mijornada = jornadas.get(i);%>
                                   <option value="<%=i %>"><%=mijornada.getNombre() %> (<%=mijornada.getFechainicio() %> | <%=mijornada.getFechafin() %>)</option> 
                            <%  }
                            %>
                        </select>
                    </div>
                </form>
            </div>
        </div>
    <%
        if (partidos==null) {%>
            <div class="row mx-0">
                <div class="col my-3 mx-5">
                    <img src="img/bg.jpg" class="img-fluid" alt="">
                </div>
            </div>
    <%} else {
        for (Partido partido:partidos) {
    %>
        <div class="row justify-content-center mx-0 text-center align-items-center">

            <div class="col-1">
            <%
            if (usuario !=null) {
            %>
                <button type="button" class="btn btn-info px-3" data-toggle="modal" data-target="#modalinfo" data-partido="<%=partido.getIdpartido() %>" data-local="<%=partido.getLocal().getNombre() %>" data-visitante="<%=partido.getVisitante().getNombre() %>"><i class="fa fa-info-circle text-white" aria-hidden="true"></i></button>
            <%}%>
            </div>

            <div class="col-1">
                <img src="<%=partido.getLocal().getEscudo() %>" class="img-fluid" alt="">
            </div>
            <div class="col-2">
                <%=partido.getLocal().getNombre() %>
            </div>
            <div class="col-1">
                <%=partido.getGoleslocal() %> - <%=partido.getGolesvisitante() %>
            </div>
            <div class="col-2">
                <%=partido.getVisitante().getNombre() %>
            </div>
            <div class="col-1">
                <img src="<%=partido.getVisitante().getEscudo() %>" class="img-fluid" alt="">
            </div>
            <div class="col-1">
            <%
            if (usuario !=null) {
            %>                
                <button type="button" class="btn btn-info px-3 text-white" data-toggle="modal" data-target="#modalapostar" data-dni="<%=usuario.getDni() %>" data-partido="<%=partido.getIdpartido() %>" data-local="<%=partido.getLocal().getNombre() %>" data-visitante="<%=partido.getVisitante().getNombre() %>">APOSTAR</button>
            <%}%>                
            </div>
        </div>
    <%}}%>
    </div>
    <!--Modals-->
    <!-- Modal Login -->
<div class="modal fade" id="modallogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"> Login / Register</h5>
      </div>
        <form action="Controller?op=login" method="POST">
            <div class="modal-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">DNI</label>
                  <input required type="text" class="form-control" name="dni" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="D.N.I.">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Nombre</label>
                  <input type="text" class="form-control" name="nombre" id="exampleInputPassword1" placeholder="Nombre">
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
              <button class="btn btn-primary" type="submit">Login/Register</button>
            </div>
        </form>
    </div>
  </div>
</div>

<!-- Modal apostar -->
<div class="modal fade" id="modalapostar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
        <form method="POST" action="">  
            <h5 class="modal-title bg-primary text-white text-center py-3">Apostar</h5>
         
            <div class="modal-body">
                <div class="d-flex justify-content-center">
                    <span class="h4 text-success"></span><input type="text" name="goleslocal" size="2" class="mx-3"> - <input type="text" name="golesvisitante" size="2" class="mx-3"><span class="h4 text-warning"></span>
                </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Apostar</button>
            </div>
        </form>
    </div>
  </div>
</div>    
<!-- Modal info -->
<div class="modal fade" id="modalinfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
        <h5 class="modal-title bg-primary text-white text-center py-3">Información Apuestas</h5>
        <div class="modal-body">
            <h4 class="text-center"></h4>
            <div></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
        </div>
    </div>
  </div>
</div> 
<!-- Tostada-->
    <%
        // En esta posición vamos a sacar una tostada si es que el controller nos dió algún mensaje
        // Si tenemos mensaje lo quitamos de la sesión puesto que ya lo hemos visualizado
        String msg = (String)session.getAttribute("msg");
        if (msg!=null){
            session.removeAttribute("msg");%>
            <div style="position: absolute; top: 2%; right: 50%;"> <!-- div para colocar la tostada-->
                <!-- a la tostada le ponemos 2 seg de duración puesto que por defecto es de 500ms-->
                <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000">
                  <div class="toast-body text-center bg-danger text-white">
                    <%=msg %>
                  </div>
                </div>
            </div>
        <%}
    %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    
    <!-- Ojo Ojo -> quitar la palabra slim de la línea de abajo para que funcione AJAX -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="js/myjs.js"></script>
    <script>
        $('#jornada').val('<%=indexjornada %>')
        $('.toast').toast('show');
    </script>

</body>

</html>
