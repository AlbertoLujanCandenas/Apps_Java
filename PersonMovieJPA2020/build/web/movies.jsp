<%-- 
    Document   : movies
    Created on : 17-mar-2020, 21:33:44
    Author     : pacopulido
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="entities.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String urlImg = "https://image.tmdb.org/t/p/w500";
    List<Movie> lmp = (List<Movie>)request.getAttribute("lmp");
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.US);
%>
<div class="row justify-content-center px-3">
    <% for (Movie movie:lmp){%>
    <div class="col-12">
        <div class="card p-2 h-100">
            <div class="row">
                <div class="col-4">
                    <img width="100" src="<%=movie.getPoster()==null?"img/noimage.png":urlImg+movie.getPoster() %>" class="img-fluid" alt="">
                </div>
                <div class="col-8">
                    <h4 class="card-title"><%=movie.getTitulo() %></h4>
                    <h5 class="card-text"><%=sdf.format(movie.getFecha()) %></h5>
                </div>
            </div>
        </div>
    </div>
    <%}%>
</div>
        
