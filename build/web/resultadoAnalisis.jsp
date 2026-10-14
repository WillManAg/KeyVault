<%-- 
    Document   : resultadoAnalisis
    Created on : 9 oct 2026, 12:15:11
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Integer puntuacion
            = (Integer) request.getAttribute("puntuacion");

    String nivel
            = (String) request.getAttribute("nivel");

    String consejo
            = (String) request.getAttribute("consejo");

    String tiempoRotura
            = (String) request.getAttribute("tiempoRotura");

    String password
            = (String) request.getAttribute("password");
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
            <strong><%= puntuacion%>%</strong>
        </p>


        <progress value="<%= puntuacion%>"
                  max="100">
        </progress>


        <p>
            Nivel de seguridad:
            <strong><%= nivel%></strong>
        </p>

        <p>
            Tiempo estimado de rotura:
            <strong><%= tiempoRotura%></strong>
        </p>

        <h2>Recomendaciones para la contraseña</h2>

        <p>
            <%= consejo%>
        </p>

        <small>
            Estimación orientativa basada en la tabla de ataques de fuerza bruta con hardware de alta gama.
        </small>


        <form action="<%= request.getContextPath()%>/index.jsp"
              method="get">

            <input type="submit"
                   value="Volver">

        </form>

        <form action="<%= request.getContextPath()%>/guardaVault"
              method="post">

            <input type="hidden"
                   name="password"
                   value="<%= password%>">

            <input type="hidden"
                   name="puntuacion"
                   value="<%= puntuacion%>">

            <input type="submit"
                   value="Guardar en Vault">

        </form>

    </body>

</html>
