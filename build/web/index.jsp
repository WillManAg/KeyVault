<%-- 
    Document   : index
    Created on : 9 oct 2026, 12:14:54
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>KeyVault</title>

    </head>

    <body>

        <h1>KeyVault</h1>

        <h2>Auditoría de contraseña</h2>


        <form action="<%= request.getContextPath() %>/evaluaPassword"
              method="post">

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
