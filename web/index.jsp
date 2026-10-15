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

    Integer contadorClaves
            = (Integer) session.getAttribute("contadorClaves");
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

        <%
            if (contadorClaves != null) {
        %>

        <p>
            Claves guardadas en esta sesión:
            <strong><%= contadorClaves%></strong>
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

            <input type="button"
                   value="Generar contraseña"
                   onclick="generarPassword()">

            <input type="submit"
                   value="Analizar">

        </form>

        <br>

        <form action="<%= request.getContextPath()%>/consultaVault"
              method="get">

            <input type="submit"
                   value="Ver histórico del Vault">

        </form>

    </body>

    <script>

        function generarPassword() {

            const mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            const minusculas = "abcdefghijklmnopqrstuvwxyz";
            const numeros = "0123456789";
            const simbolos = "!@#$%&*";

            const caracteres =
                    mayusculas
                    + minusculas
                    + numeros
                    + simbolos;

            let password = "";

            password += mayusculas[
                    Math.floor(Math.random() * mayusculas.length)
            ];

            password += minusculas[
                    Math.floor(Math.random() * minusculas.length)
            ];

            password += numeros[
                    Math.floor(Math.random() * numeros.length)
            ];

            password += simbolos[
                    Math.floor(Math.random() * simbolos.length)
            ];


            while (password.length < 12) {

                password += caracteres[
                        Math.floor(Math.random() * caracteres.length)
                ];

            }


            document.getElementById("password").value = password;

        }

    </script>

</html>
