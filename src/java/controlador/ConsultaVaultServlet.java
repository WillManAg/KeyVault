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
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RegistroPassword;
import modelo.VaultDAO;

@WebServlet("/consultaVault")
public class ConsultaVaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexto
                = getServletContext();

        String rutaArchivo
                = contexto.getRealPath(
                        "/WEB-INF/vault.txt"
                );

        VaultDAO dao
                = new VaultDAO();

        ArrayList<RegistroPassword> registros
                = dao.leerRegistros(rutaArchivo);

        request.setAttribute(
                "registros",
                registros
        );

        request.getRequestDispatcher(
                "/vaultHistorico.jsp"
        ).forward(request, response);

    }

}
