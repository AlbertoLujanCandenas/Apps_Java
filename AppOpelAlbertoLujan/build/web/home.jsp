<%-- 
    Document   : jome
    Created on : 23-feb-2022, 8:46:29
    Author     : alber
--%>

<%@page import="Entities.Acabado"%>
<%@page import="Entities.Modeloacabado"%>
<%@page import="Entities.Usuario"%>
<%@page import="Entities.Modelo"%>
<%@page import="Entities.Tipo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

<head>
    <title>Examen Opel Alberto</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <% List<Tipo> tipos = (List<Tipo>) session.getAttribute("tipos");
        List<Modelo> modelos = (List<Modelo>) session.getAttribute("modelos");
        List<Modelo> modelosTipo = (List<Modelo>) session.getAttribute("modelosTipo");
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Modelo cochepulsado = (Modelo) session.getAttribute("idcoche");
        List<Acabado> acabados = (List<Acabado>) session.getAttribute("acabados");
        %>
    <div class="container shadow p-0 bg-light">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><img src="img/logo.png" class="img-fluid" alt=""></a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?op=inicio">TODOS</a>
                    </li>
                    <% for(Tipo tipo: tipos){ %>
                    <li class="nav-item">
                        <a class="nav-link" href="Controller?op=<%=tipo.getId()%>"><%=tipo.getNombre() %></a>
                    </li>
                    <%}%>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <% if(usuario != null){
                        %>
                            <span class="text-primary">Welcome <%=usuario.getNick() %> </span>
                            <a href="Controller?op=logout" class="btn btn-success ml-2">Logout</a>
                        <%}else{%>
                            <a href="" class="btn btn-danger" data-toggle="modal" data-target="#modalogin">Login</a>
                        <%}%>
                </form>
            </div>
        </nav>

                <% if(modelos != null){ %>
        <div class="row mx-1 justify-content-center">
            <%for(Modelo modelo: modelos){%>
            <div class="col mt-2">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><%=modelo.getNombre() %></h5>
                        <a href="Controller?op=cochepulsado&idcoche=<%=modelo.getId()%>">
                        <img src="<%=modelo.getImagen()%>" class="card-img-top img-fluid" alt=""> 
                        </a>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        <%}%>
        
                <% if(modelosTipo != null){ %>
        <div class="row mx-1 justify-content-center">
            <%for(Modelo modelo: modelosTipo){%>
            <div class="col mt-2">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><%=modelo.getNombre() %></h5>
                        <a href="Controller?op=cochepulsado&idcoche=<%=modelo.getId()%>">
                        <img src="<%=modelo.getImagen() %>" class="card-img-top img-fluid" alt="">
                        </a>
                    </div>                        
                </div>
            </div>
            <%}%>
        </div>
        <%}%>
        
        <!-- Modal Login-->
            <div class="modal fade" id="modalogin" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form method="POST" action="Controller?op=login">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Login/Register</h5>
                        </div>
                        <div class="modal-body">
                            <div class="row my-1">
                                <span class="font-weight-bold container">Usuario</span>
                            </div>
                            <div class="row my-1">
                                <input type="text" name="nick" class="container mx-3">
                            </div>
                            <div class="row my-1">
                                <span class="font-weight-bold container">Contraseña</span>
                            </div>
                            <div class="row my-1">
                                <input type="text" name="pass" class="container mx-3">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Login/Register</button>
                        </div>
                    </div>
                        </form>
                </div>
            </div>
        
        <%if(cochepulsado != null){ %>
        <!-- Acordeon-->
        <div class="row container justify-content-center m-1">
                <div class="col ">
                    <div class="row container mx-1 bg-secondary text-white text-center">
                        <div class="col text-center">
                            <h3><%=cochepulsado.getNombre() %></h3>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col text-center">
                            <img src="<%=cochepulsado.getImagen() %>" alt="" class="img-fluid">
                        </div>

                    </div>

                    <div class="row  mx-1  bg-secondary text-white ">
                        <div class="col text-center">
                            <h4>Acabados</h4>
                        </div>
                    </div>
                        <%for (Acabado acabado: acabados){ %>
                    <div class="row">
                        <div class="col mx-1 text-center">

                            <div id="accordion">
                                <div class="card">
                                    <div class="card-header" id="headingOne">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne"
                                                    aria-expanded="true" aria-controls="collapseOne">
                                                <%=acabado.getNombre() %>
                                            </button>
                                        </h5>
                                    </div>

                                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                                         data-parent="#accordion">
                                        <div class="card-body text-center">
                                            <p><%=cochepulsado.getModeloacabadoList() %></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        <%}%>
        
        <footer class="mt-3">
            <h3 class="text-center text-white bg-secondary py-3">Opel Alberto Lujan 2º CFGS DAM</h3>
        </footer>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
