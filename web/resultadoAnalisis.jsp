<%-- 
    Document   : resultadoAnalisis
    Created on : 9 oct 2026, 12:15:11
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer puntuacion =
            (Integer) request.getAttribute("puntuacion");

    String nivel =
            (String) request.getAttribute("nivel");

    String consejo =
            (String) request.getAttribute("consejo");
%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Resultado del análisis</title>

    </head>

    <body>

        <h1>Resultado del análisis</h1>


        <p>
            Fortaleza de la contraseña:
            <strong><%= puntuacion %>%</strong>
        </p>


        <progress value="<%= puntuacion %>"
                  max="100">
        </progress>


        <p>
            Nivel de seguridad:
            <strong><%= nivel %></strong>
        </p>


        <h2>Faltan los siguientes criterios</h2>

        <p>
            <%= consejo %>
        </p>


        <form action="<%= request.getContextPath() %>/index.jsp"
              method="get">

            <input type="submit"
                   value="Volver">

        </form>

    </body>

</html>
