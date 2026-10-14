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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RegistroPassword;
import modelo.VaultDAO;

@WebServlet("/guardaVault")
public class GuardaVaultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String password
                = request.getParameter("password");

        int puntuacion
                = Integer.parseInt(
                        request.getParameter("puntuacion")
                );

        SimpleDateFormat formato
                = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String fecha
                = formato.format(new Date());

        RegistroPassword registro
                = new RegistroPassword(
                        password,
                        puntuacion,
                        fecha
                );

        ServletContext contexto
                = getServletContext();

        String rutaArchivo
                = contexto.getRealPath(
                        "/WEB-INF/vault.txt"
                );

        VaultDAO dao
                = new VaultDAO();

        dao.guardarRegistro(
                rutaArchivo,
                registro
        );

        response.sendRedirect(
                request.getContextPath() + "/index.jsp"
        );

    }

}
