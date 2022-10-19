<%@page import="modelMovie.Movie"%>
<%@page import="modelMovie.TMDBmovie"%>
<%@page import="modelPerson.Actor"%>
<%@page import="java.util.List"%>
<%@page import="api.Manejador"%>
<%@page import="modelPerson.TMDBperson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype html>
<html lang="en">
<head>
    <title>TMDB Alberto Lujan Candenas 2º DAM</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<%TMDBperson person = new Manejador("http://api.themoviedb.org/3/person/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataPerson();
List<Actor> actores = person.getResults();

TMDBmovie movie = new Manejador("http://api.themoviedb.org/3/movie/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf").getDataMovie();
List<Movie> peliculas = movie.getResults();
%>
    <div class="container shadow" style="border-radius:25px;">
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <a class="navbar-brand" href="#"><img src="img/logotmdb.png" alt="LOGO TMDB"></a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-flex justify-content-center" style="border-radius:25px;" id="collapsibleNavId">
                <ul class="navbar-nav mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link"><button type="button" class="btn btn-success" onclick="document.getElementById('person').style.display = 'flex';document.getElementById('movie').style.display = 'none';">Persons</button><span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link"><button type="button" class="btn btn-success" onclick="document.getElementById('person').style.display = 'flex';document.getElementById('person').style.display = 'none';">Movies</button></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link"><button type="button" class="btn btn-success" onclick="document.getElementById('movie').style.display = 'flex';document.getElementById('person').style.display = 'flex';">All</button></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row mt-3" id="person">
        <%for(Actor actor: actores)
        { %>
            <div class="col-md-6 col-lg-4 mb-3">
                <div class="card h-100">
                    <img class="card-img-top img-fluid" src="https://image.tmdb.org/t/p/w500<%=actor.getProfile_path()%>" alt="">
                    <div class="card-body">
                        <h5 class="card-title"><%=actor.getName() %></h5>
                        <p class="card-text"><%=actor.getId() %></p>
                        <p class="card-text"><%=actor.getPopularity() %></p>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
        <div class="row mt-3" id="movie">
        <%for(Movie movies: peliculas) {
        	%>
        
            <div class="col-md-6 col-lg-4 mb-3">
                <div class="card">
                    <img class="card-img-top" src="https://image.tmdb.org/t/p/w500<%=movies.getBackdrop_path()%>" alt="">
                    <div class="card-body">
                        <h5 class="card-title"><%=movies.getTitle() %></h5>
                        <p class="card-text"><%=movies.getRelease_date() %></p>
                        <p class="card-text"><%=movies.getVote_average() %></p>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
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