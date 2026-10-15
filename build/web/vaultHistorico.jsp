<%-- 
    Document   : vaultHistorico
    Created on : 9 oct 2026, 12:15:31
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.RegistroPassword"%>


<%
    ArrayList<RegistroPassword> registros
            = (ArrayList<RegistroPassword>) request.getAttribute("registros");
%>


<!DOCTYPE html>

<html>

    <head>

        <meta charset="UTF-8">

        <title>Histórico del Vault</title>

    </head>

    <body>

        <h1>Histórico del Vault</h1>


        <%
            if (registros != null && !registros.isEmpty()) {
        %>


        <table border="1">

            <tr>

                <th>Clave</th>

                <th>Fortaleza</th>

                <th>Fecha de registro</th>

            </tr>


            <%
                for (RegistroPassword registro : registros) {
            %>


            <tr>

                <td>
                    <%= registro.getClave()%>
                </td>

                <td>
                    <%= registro.getNivelFortaleza()%>%
                </td>

                <td>
                    <%= registro.getFechaRegistro()%>
                </td>

            </tr>


            <%
                }
            %>


        </table>


        <%
        } else {
        %>


        <p>
            Todavía no hay registros guardados en el Vault.
        </p>


        <%
            }
        %>


        <br>


        <form action="<%= request.getContextPath()%>/index.jsp"
              method="get">

            <input type="submit"
                   value="Volver">

        </form>


    </body>

</html>