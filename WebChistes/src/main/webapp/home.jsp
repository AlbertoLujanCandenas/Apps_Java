<%@page import="model.DAOCategoria"%>
<%@page import="model.DAOChiste"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Chiste"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="eS">

<head>
    <title>Chistes</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>

	<%
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) session.getAttribute("categorias");
		ArrayList<Chiste> chistes = (ArrayList<Chiste>) request.getAttribute("chistes");
		String categoriaActual = request.getParameter("categoria");
		
	%>
    <div class="container text-center shadow pb-4 rounded-bottom">

        <nav class="navbar navbar-expand-sm navbar-dark bg-primary shadow">
            <a class="navbar-brand" href="#"><img src="img/chistes.png" class="img-fluid" alt="logo"></a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="col text-right text-white">
                <h2 class="display-4">Azarquiel</h2>
            </div>
        </nav>

        <div class="row justify-content-center">
            <div class="col-8 my-5">
                <div class="row">
                    <div class="col">
                        <h3 class="bg-primary text-white rounded-top">Por Categorías</h3>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-6 p-4">
                        <form action="Controller?op=dameChistes" method="post">
                        
                            <select class="custom-select custom-select-lg mb-3" name="categoria" id="categoria" onchange="this.form.submit()">
                            
                            	<option selected disabled>Elija Categoría</option>
                            	
                            <%for(Categoria categoria : categorias){ %>
                                <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
                            <%}%>
                            
                            </select>
                        </form>
                    </div>
                    <button id="btnCategoria" type="button" class=" btn btn-primary btn-lg rounded-circle m-4 justify-align-center p-0"
                        data-toggle="modal" data-target="#modelId">
                        <i class="fa fa-plus" aria-hidden="true"></i>
                    </button>
                </div>
            </div>
			
			<%
				if(chistes != null){
					for(Chiste chiste:chistes){
			%>
            			<div class="col-8 text-white bg-secondary text-left rounded">
                			<h3 class="mt-3"><%= chiste.getTitulo()%> (<%=chiste.getIdCategoria() %>) - <%=chiste.getAdopo() %></h3>
                			<p class="mt-1"><%= chiste.getDescripcion()%></p>
            			</div>
            <%
					}
				}
            %>
            
        </div>

        <!-- Button trigger modal -->
        <button id="btnPpal" type="button " class=" btn btn-primary btn-lg rounded-circle" data-toggle="modal"
            data-target="#modelId">
            <i class="fa fa-plus" aria-hidden="true"></i>
        </button>

        <!-- Modal -->
        <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Nuevo chiste</h5>
                    </div>
                    <div class="modal-body d-flex flex-column bd-highlight mx-4">
                        <input type="text" name="apodo" placeholder="Apodo" class="my-4"/>

                        <select class="my-4">
                            <option selected disabled>Categoria</option>
                            <%for(Categoria categoria : categorias){ %>
                                <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>     
                            <%}%>
                        </select>

                        <input type="text" name="Titulo" placeholder="Titulo" class="my-4"/>
                        <input type="text" name="Descripcion" placeholder="Descripcion" class="my-4"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Aceptar <i class="fa fa-check-circle-o" aria-hidden="true"></i></button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close <i class="fa fa-times-circle-o" aria-hidden="true"></i></button>
                    </div>
                </div>
            </div>
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
	<script type="text/javascript">
		$('#categoria').val('<%= categoriaActual%>')
	</script>
</body>

</html>