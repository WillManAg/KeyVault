<%-- 
    Document   : index
    Created on : 9 oct 2026, 12:14:54
    Author     : william.marin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.EvaluadorPassword"%>

<%

    String password = request.getParameter("password");
    
    Integer puntuacion = null;
    String evaluar = null;
    
    if (password != null && !password.isEmpty()) {
        
        EvaluadorPassword evaluador = new EvaluadorPassword();
        
        puntuacion = evaluador.calcularFortaleza(password);
        
        evaluar = evaluador.nivelPassword(puntuacion);
        
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="index.jsp" method="post">
            
            <label>Contraseña</label>
            
            <input type="text" name="password">
            <input type="submit" name="Evaluar">
            
        </form>
        
        <%
            if (puntuacion != null) {
        %>
        
        <h2>Resultado</h2>
        
        <p>Puntuación = <%= puntuacion %> </p>
        
        <p>Nota de la contraseña = <%= evaluar %> </p>
        
        
        <% } %>
        
    </body>
</html>
