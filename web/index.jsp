<%-- 
    Document   : index
    Created on : 9 oct 2026, 12:14:54
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%
    String ultimaEvaluacion = null;

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {

        for (int i = 0; i < cookies.length; i++) {

            if (cookies[i].getName().equals("ultimaEvaluacion")) {

                long fecha
                        = Long.parseLong(cookies[i].getValue());

                Date fechaAuditoria
                        = new Date(fecha);

                SimpleDateFormat formato
                        = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                ultimaEvaluacion
                        = formato.format(fechaAuditoria);

            }
        }
    }
%>


<%
    String nombreUsuario
            = (String) session.getAttribute("nombreUsuario");
%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>KeyVault</title>

    </head>

    <body>

        <h1>KeyVault</h1>

        <%
            if (nombreUsuario != null) {
        %>

        <p>
            Bienvenido, <strong><%= nombreUsuario%></strong>
        </p>

        <%
            }
        %>

        <h2>Auditoría de contraseña</h2>

        <%
            if (ultimaEvaluacion != null) {
        %>

        <p>
            Última evaluación:
            <%= ultimaEvaluacion%>
        </p>

        <%
        } else {
        %>

        <p>
            Todavía no se ha revisado ninguna contraseña...
        </p>

        <%
            }
        %>


        <form action="<%= request.getContextPath()%>/evaluaPassword"
              method="post">

            <%
                if (nombreUsuario == null) {
            %>

            <label for="usuario">
                Usuario:
            </label>

            <input type="text"
                   id="usuario"
                   name="usuario"
                   required>

            <br><br>

            <%
                }
            %>

            <label for="password">
                Introduce una contraseña:
            </label>

            <input type="text"
                   id="password"
                   name="password"
                   required>

            <input type="submit"
                   value="Analizar">

        </form>

    </body>

</html>
