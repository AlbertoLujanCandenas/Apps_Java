<%@page import="java.util.ArrayList"%>
<%@page import="model.Marca"%>
<%@page import="model.Bici"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Alltricks</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<% ArrayList<Marca> marcas = (ArrayList<Marca>) session.getAttribute("marcas");
	//ArrayList<Marca> marcaSola = (ArrayList<Marca>) session.getAttribute("marcaSola"); 
	ArrayList<Bici> bicis = (ArrayList<Bici>) request.getAttribute("bicis");
	//ArrayList<Bici> biciSola = (ArrayList<Bici>) request.getAttribute("biciSola");
	ArrayList<Bici> biciMarca = (ArrayList<Bici>) request.getAttribute("biciMarca");
	String ordenado = request.getParameter("ordenado");
	String marcaSeleccionada =(String)request.getAttribute("marcaSeleccionada");
	ArrayList<Bici> biciFavorita = (ArrayList<Bici>) request.getAttribute("biciFavorita");
	
	
%>

    <div class="container shadow p-0">
        <nav class="navbar navbar-expand navbar-light bg-primary">
            <div class="nav navbar-nav">
                <a class="nav-item nav-link active ml-4" href="#">
                    <img src="img/logo-white.png" alt="Alltricks">
                </a>
            </div>
        </nav>

        <div class="row justify-content-center d-flex align-items-center px-3">

            <div class="col-12 col-md-4 my-1">
                <!--Form marcas-->
                <form action="Controller?op=dameBicis" method="post">
                    <select class="form-control" name="marca" onchange="this.form.submit()">
                        <option value="" disabled>Elija marca</option>
                       <%for(Marca marca: marcas){ %>
                                <option value="<%=marca.getId()%>"><%=marca.getNombre()%></option>
                                <%} %>
                        
                        
                    </select>
                </form>
            </div>

            <div class="col-12 col-md-4 my-1">
                <!--Form ordenar-->
                <form action="Controller?op=ordenar" method="post">
                    <select class="form-control" name="biciOrdenada" onchange="this.form.submit()">
                        <option value="null" disabled>Ordenar por</option>
                        <option value="precio asc">Precio Ascendente</option>
                        <option value="precio desc">Precio Descendente</option>
                        <option value="marca">Marca</option>
                    </select>
                </form>
            </div>

            <!--Favoritos-->
            <div class="col-12 col-md-2 text-right my-1">
                <form action="Controller?op=fav" method="post">
                    <button type="submit" class="btn">
                        <span class=" display-4 text-secondary">
                            &#9733;
                        </span>
                    </button>
                </form>
            </div>
        </div>

        <div class="row px-3">
        <%
           		if(biciMarca != null){
           			for(Bici bici: biciMarca){
           				
           %>
            <div class="col-12 col-md-6 col-lg-4 ">
                <div class="card my-2">
                    <img class="card-img-top" src="<%=bici.getFoto() %>" alt="Bicicletas"/>
                    <div class="card-body">
                        <h4 class="card-title"><%=marcaSeleccionada %></h4>
                        <p class="card-text"><%=bici.getDescripcion() %></p>
                        <p class="card-text"><%=bici.getPrecio() %></p>
                        <% String colorEstrella;
                        if(bici.getFav()==0){
                        	colorEstrella = "secondary";	
                        }else{
                        	colorEstrella = "warning";
                        }
                        %>
                        <a href="Controller?op=ponerFav" class="display-4 text-<%=colorEstrella %>">&#9733;</a>
                    </div>
                </div>
            </div>
            <%
           		
           			}
           		}
           %>
           
                   <%
                   if(bicis != null){
                	   for(Bici bici: bicis){	
           					
           %>
            <div class="col-12 col-md-6 col-lg-4 ">
                <div class="card my-2">
                    <img class="card-img-top" src="<%=bici.getFoto() %>" alt="Bicicletas"/>
                    <div class="card-body">
                        <h4 class="card-title"></h4>
                        <p class="card-text"><%=bici.getDescripcion() %></p>
                        <p class="card-text"><%=bici.getPrecio() %></p>
                        <% String colorEstrella;
                        if(bici.getFav()==0){
                        	colorEstrella = "secondary";	
                        }else{
                        	colorEstrella = "warning";
                        }
                        %>
                        <a href="Controller?op=ponerFav" class="display-4 text-<%=colorEstrella %>">&#9733;</a>
                    </div>
                </div>
            </div>
            <%
                   }
                   }
           			
           	           %>
        </div>
        
                <%
           		if(biciFavorita != null){
           			for(Bici bici: biciFavorita){
           				
           %>
            <div class="col-12 col-md-6 col-lg-4 ">
                <div class="card my-2">
                    <img class="card-img-top" src="<%=bici.getFoto() %>" alt="Bicicletas"/>
                    <div class="card-body">
                        <h4 class="card-title"><%=marcaSeleccionada %></h4>
                        <p class="card-text"><%=bici.getDescripcion() %></p>
                        <p class="card-text"><%=bici.getPrecio() %></p>
                        <% String colorEstrella;
                        if(bici.getFav()==0){
                        	colorEstrella = "secondary";	
                        }else{
                        	colorEstrella = "warning";
                        }
                        %>
                        <a href="Controller?op=ponerFav" class="display-4 text-<%=colorEstrella %>">&#9733;</a>
                    </div>
                </div>
            </div>
            <%
           		
           			}
           		}
           %>
        



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