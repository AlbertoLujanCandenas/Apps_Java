<%-- 
    Document   : showapuestas
    Created on : 24-ene-2022, 11:59:09
    Author     : diurno
--%>

<%@page import="entities.Apuesta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Apuesta> apuestas = (List<Apuesta>) session.getAttribute("apuestas");
    if (apuestas.size()==0) {%>
        <h3 class='text-danger'>Sin apuestas</h3>
    <%} else {
    %>
        <table>
            <% for (Apuesta apuesta:apuestas) { %>
                <tr><td><%=apuesta.getGolesl() %> - <%=apuesta.getGolesv() %> --> <%=apuesta.getCuantas() %></td></tr>
            <%}%>   
        </table>
    <%}%>