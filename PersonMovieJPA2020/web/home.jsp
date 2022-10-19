<%-- 
    Document   : home.jsp
    Created on : 17-mar-2020, 20:17:43
    Author     : pacopulido
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Movie"%>
<%@page import="entities.Person"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/mycss.css">
</head>

<body>
    <%
    String urlImg = "https://image.tmdb.org/t/p/w500";
    String ficha = (String)session.getAttribute("ficha");
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.US);
    %>
    <div class="container px-0 shadow">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="img/logotmdb.png" width="64" alt="logo">
            </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" class="<%=(ficha.equals("person")?"active":"")%>" href="Controller?op=personomovie&ficha=person">Person</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" class="<%=(ficha.equals("movie")?"active":"")%>" href="Controller?op=personomovie&ficha=movie">Movie</a>
                    </li>
                </ul>
                    <form class="form-inline my-2 my-lg-0" action="Controller?op=loginregister" method="POST">
                    <input class="form-control mr-sm-2" type="text" placeholder="dni" name="dni">
                    <input class="form-control mr-sm-2" type="text" placeholder="nombre" name="nombre">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login/Register</button>
                </form>
            </div>
        </nav>
        <!-- Person -->
        <%
        if (ficha.equals("person")) {
             List<Person> lp=(List) session.getAttribute("lp");
        %>
        <div class="row justify-content-center px-3">
            <% for (int i=0; i<lp.size(); i++){
                Person person = lp.get(i);%>
          
            <div class="col-md-6 col-lg-4 p-3">
                <div class="card h-100">
                    <img class="card-img-top" src="<%=person.getFoto()==null?"img/noimage.png":urlImg+person.getFoto() %>" class="img-fluid" alt="">
                    <div class="card-body">
                        <p class="text-center">
                            <span class="display-4">
                                &#9733;&#9733;&#9733;
                            </span>
                        <p>
                        <h4 class="card-title text-center"><%=person.getNombre() %></h4>
                    </div>
                    <div class="text-center">
                        <span class="rating">
                            <a href="Controller?op=rating&rating=1">&#9733;</a>
                            <a href="Controller?op=rating&rating=2">&#9733;</a>
                            <a href="Controller?op=rating&rating=3">&#9733;</a>
                            <a href="Controller?op=rating&rating=4">&#9733;</a>
                            <a href="Controller?op=rating&rating=5">&#9733;</a>
			</span>	
                    </div>
                    <div class="card-footer text-center">
                        <button class="btn btn-success" data-i="<%=i %>" data-person="<%=person.getNombre() %>" data-toggle="modal" data-target="#modalmovies">FILMOGRAFÍA</button>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        <%}%>
        <!-- Movie -->
        <%if (ficha.equals("movie")) {  
            List<Movie> lm=(List) session.getAttribute("lm");
        %>
        <div class="row justify-content-center px-3">
            <% for (Movie movie:lm){%>
            <div class="col-lg-6 p-3">
                <div class="card p-2 h-100">
                    <div class="row">
                        <div class="col">
                            <img src="<%=movie.getPoster()==null?"img/noimage.png":urlImg+movie.getPoster() %>" class="img-fluid" alt="">
                        </div>
                        <div class="col p-2">
                            <h4 class="card-title"><%=movie.getTitulo() %></h4>
                            <h5 class="card-text"><%=sdf.format(movie.getFecha()) %></h5>
                            <p><%=movie.getTrama() %> </p>

                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        
        <%}%>
        <footer>
            <h2 class="text-center bg-dark text-success py-3">The MovieDB - Azarquiel 2020</h2>
        </footer>
    </div>
<!-- Modal -->
<div class="modal fade" id="modalmovies" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <h3 class="modal-title bg-dark text-success text-center">Movies</h3>
            <div class="modal-header">
                <h4 class="text-success"></h4>
            </div>
            <div class="modal-body" id="movies">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="js/myjs.js"></script>
</body>

</html>
