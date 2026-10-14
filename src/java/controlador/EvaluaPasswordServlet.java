/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 * 
 * @author william.marin
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EvaluadorPassword;

@WebServlet("/evaluaPassword")
public class EvaluaPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        String password =
                request.getParameter("password");


        EvaluadorPassword evaluador =
                new EvaluadorPassword();


        int puntuacion =
                evaluador.calcularFortaleza(password);


        String nivel =
                evaluador.nivelPassword(puntuacion);


        String consejo =
                evaluador.consejo(password);


        request.setAttribute(
                "puntuacion",
                puntuacion
        );


        request.setAttribute(
                "nivel",
                nivel
        );


        request.setAttribute(
                "consejo",
                consejo
        );


        request.getRequestDispatcher(
                "/resultadoAnalisis.jsp"
        ).forward(request, response);

    }

}
